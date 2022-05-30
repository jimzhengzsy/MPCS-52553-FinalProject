package com.finalproject.mycanvas.assignments.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Assignment {

    private long id;
    private long grade;
    private long teacherId;
    private String assignmentName;
    private Timestamp due_date;
    private String description;
}
