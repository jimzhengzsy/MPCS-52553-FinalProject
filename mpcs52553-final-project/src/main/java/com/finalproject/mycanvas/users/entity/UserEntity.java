package com.finalproject.mycanvas.users.entity;

import com.finalproject.mycanvas.announcement.entity.AnnouncementEntity;
import com.finalproject.mycanvas.assignments.entity.AssignmentEntity;
import com.finalproject.mycanvas.assignments.model.Assignment;
import com.finalproject.mycanvas.courses.entity.CourseEntity;
import com.finalproject.mycanvas.courses.model.Course;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    @Column(unique=true)
    private String userId;
    @Column(unique=true)
    private String email;
    private String role;
    private String status;
    private String password;
    private String loginQuestion1;
    private String loginQuestion2;
    private String loginQuestion3;
    private String loginAnswer1;
    private String loginAnswer2;
    private String loginAnswer3;

    @ManyToMany(
            cascade = CascadeType.ALL
    )
    @JoinTable(
            name = "user_assignment_map",
            joinColumns = @JoinColumn(
                    name = "user_id",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "assignment_id",
                    referencedColumnName = "id"
            )

    )
    private List<AssignmentEntity> assignments;

    @ManyToMany(
            cascade = CascadeType.ALL
    )
    @JoinTable(
            name = "user_announcement_map",
            joinColumns = @JoinColumn(
                    name = "user_id",
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
            name = "enrollment",
            joinColumns = @JoinColumn(
                    name = "user_id",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "courses_id",
                    referencedColumnName = "id"
            )

    )
    private List<CourseEntity> courses;
}
