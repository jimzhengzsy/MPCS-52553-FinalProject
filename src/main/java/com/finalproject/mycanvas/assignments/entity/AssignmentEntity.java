package com.finalproject.mycanvas.assignments.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
@Table(name = "assignments")
public class AssignmentEntity {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)

    private long id;
    private long grade;
    private long teacherId;
    private Date due_date;
    private String description;
}
