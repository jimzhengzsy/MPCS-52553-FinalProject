import React from "react";
import Assignment from "./Assignment";
import { Box, Container, Grid, Typography } from '@mui/material';

export default function TeaDashboards(props){
    return(
        <>
            <Typography align = "left" variant="h4" sx={{ mb: 5 }}>
                To Grade
            </Typography>

            <Box sx={{
                display: 'grid',
                columnGap: 3,
                rowGap: 1,
                gridTemplateColumns: 'repeat(3, 1fr)',
                m: 5
            }}>
                <Assignment course = "mpcs 001" name={"Final"} due = "July 3" points = "/100"/>
                <Assignment course = "mpcs 001" name={"Final"} due = "July 3" points = "/100"/>
                <Assignment course = "mpcs 001" name={"Final"} due = "July 3" points = "/100"/>
            </Box>
        </>
    )
}