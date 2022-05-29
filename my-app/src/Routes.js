import React from "react";
import { Route, Routes } from "react-router-dom";
import Forget from "./containers/Forget";
import Login from "./containers/Login";
import Signup from "./containers/Signup";
import Sidebar from "./containers/Sidebar";
import Dashboards from "./containers/Dashboards";





export default function MyRoutes() {
    return (
        <Routes>


            <Route path="/" element={<Sidebar/>} />

            <Route path="/login" element={ <Login />} />

            <Route path="/signup" element = {<Signup />} />

            <Route path="/forget" element = {<Forget />} />

            <Route path="/dashboards" element = {<Dashboards />} />



    </Routes>
  );
}