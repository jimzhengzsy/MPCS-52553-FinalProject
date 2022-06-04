package com.finalproject.mycanvas.courses.entity;

import com.finalproject.mycanvas.announcement.entity.AnnouncementEntity;
import com.finalproject.mycanvas.assignments.entity.AssignmentEntity;
import com.finalproject.mycanvas.assignments.model.Assignment;
import com.finalproject.mycanvas.users.entity.UserEntity;
import lombok.Data;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name="courses")
public class CourseEntity {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)

    private long id;
    private String name;
    private long teacherId;
    private String description;
    private String capacity;


    @ManyToMany(
            mappedBy = "courses",
            cascade = CascadeType.ALL)
    private List<UserEntity> userEntities;


    @ManyToMany(
            cascade = CascadeType.ALL
    )
    @JoinTable(
            name = "course_announcement_map",
            joinColumns = @JoinColumn(
                    name = "course_id",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "announcement_id",
                    referencedColumnName = "id"
            )

    )
    private List<AnnouncementEntity> announcementEntities;

    @ManyToMany(
            cascade = CascadeType.ALL
    )
    @JoinTable(
            name = "course_assignment_map",
            joinColumns = @JoinColumn(
                    name = "course_id",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "assignment_id",
                    referencedColumnName = "id"
            )

    )
    private List<AssignmentEntity> assigmentEntities;
}
