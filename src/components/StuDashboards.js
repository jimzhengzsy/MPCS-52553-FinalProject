import React from "react";
import Assignment from "./Assignment";
import { Box, Container, Grid, Typography } from '@mui/material';



export default function StuDashboards(props){
    const to_do = props.toDo;
    const coming = props.upComing;
    const past = props.pastDue;

    return(
        <>
            <Typography align = "left" variant="h4" sx={{ mb: 5 }}>
                To Do
            </Typography>

            <Box sx={{
                display: 'grid',
                columnGap: 3,
                rowGap: 1,
                gridTemplateColumns: 'repeat(3, 1fr)',
                m: 5
            }}>
                {to_do.map(elem => (
                  <Assignment course={elem["course"]} name={elem["name"]}  due={elem["due"]}  points={elem["points"]}/>
                ))}
            </Box>



            <Typography align = "left" variant="h4" sx={{ mb: 5 }} >
                Upcoming
            </Typography>

            <Box sx={{
                display: 'grid',
                columnGap: 3,
                rowGap: 1,
                gridTemplateColumns: 'repeat(3, 1fr)',
                m: 5
            }}>
                {coming.map(elem => (
                  <Assignment course={elem["course"]} name={elem["name"]}  due={elem["due"]}  points={elem["points"]}/>
                ))}
            </Box>

            <Typography align = "left" variant="h4" sx={{ mb: 5 }}>
                Past
            </Typography>

            <Box sx={{
                display: 'grid',
                columnGap: 3,
                rowGap: 1,
                gridTemplateColumns: 'repeat(3, 1fr)',
                m: 5
            }}>
                {past.map(elem => (
                  <Assignment course={elem["course"]} name={elem["name"]}  due={elem["due"]}  points={elem["points"]}/>
                ))}
            </Box>
        </>
    )
}