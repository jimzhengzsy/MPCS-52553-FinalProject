import React from "react";
import Card from '@mui/material/Card';
import Typography from '@mui/material/Typography';
import CardActions from '@mui/material/CardActions';
import CardContent from '@mui/material/CardContent';
import Button from '@mui/material/Button';

export default function Assignment(props){
  return (
      <Card sx={{ minWidth: 100 }}>
        <CardContent>
            <Typography sx={{ fontSize: 14 }} color="text.secondary" gutterBottom>
                {props.course}
            </Typography>
            <Typography variant="h5" component="div">
                {props.name}
            </Typography>
            <Typography sx={{ mb: 1.5 }} color="text.secondary">
                {props.points}
            </Typography>
            <Typography variant="body2">
                {props.due}
            </Typography>
        </CardContent>
        <CardActions>
            <Button size="small">Learn More</Button>
        </CardActions>
    </Card>
    )

}







