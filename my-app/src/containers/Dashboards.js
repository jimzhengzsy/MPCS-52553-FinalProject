import React from "react";
import StuDashboards from "./StuDashboards";
import TeaDashboards from "./TeaDashboards";
import Sidebar from "./Sidebar";
import GridLayout from "react-grid-layout";

const layout = [
    { i: "content", x: 1, y: 0, w: 4, h: 1, static: true },
    { i: "sidebar", x: 0, y: 0, w: 1, h: 1, static: true }
];
const data =[
    {
        "id": 1,
        "points": 90,
        "teacherId": 10,
        "course": "mpcs 001",
        "name": "project",
        "due": "2018-04-30T05:00:00.000+00:00",
        "description": "blabla"
    },
    {
        "id": 2,
        "points": 90,
        "teacherId": 10,
        "course": "mpcs 001",
        "name": "project",
        "due": "2018-04-30T05:00:00.000+00:00",
        "description": "blabla"
    },
    {
        "id": 3,
        "points": 15,
        "teacherId": 10,
        "course": "mpcs 001",
        "name": "project",
        "due": "2018-04-28T05:00:00.000+00:00",
        "description": "jojo"
    }
]

export default function Dashboards(props){
    return(
        <GridLayout layout={layout} cols={5} width={1200}>
            <div key = "sidebar">
                <Sidebar />
            </div>
            <div key = "content">
                <StuDashboards toDo={data} upComing={data} pastDue={data}/>
            </div>
        </GridLayout>
    );

}