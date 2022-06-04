package com.finalproject.mycanvas.assignments.entity;

import com.finalproject.mycanvas.users.entity.UserEntity;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Data
@Table(name = "assignments")
public class AssignmentEntity {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)

    private long id;
    private long point;
    private long grade;
    private long teacherId;
    private long courseId;
    private String assignmentName;
    private Timestamp due_date;
    private String description;
    private String answer;

    @ManyToMany(
            mappedBy = "assignments",
            cascade = CascadeType.ALL)
    private List<UserEntity> userEntities;
}
