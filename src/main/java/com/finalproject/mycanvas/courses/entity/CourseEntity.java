package com.finalproject.mycanvas.courses.entity;

import lombok.Data;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

@Entity
@Data
@Table(name="courses")
public class CourseEntity {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)

    private long id;
    private String name;
    private long teacherId;
}
