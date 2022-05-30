package com.finalproject.mycanvas.courses.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    private long id;
    private String name;
    private long teacherId;
    private String description;
    private String capacity;
}
