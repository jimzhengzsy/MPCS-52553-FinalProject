package com.finalproject.mycanvas.announcement.entity;

import com.finalproject.mycanvas.courses.entity.CourseEntity;
import com.finalproject.mycanvas.users.entity.UserEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Entity
@Data
@Table(name = "announcements")
public class AnnouncementEntity {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;
    private long teacherId;
    private String content;

    @ManyToMany(
            mappedBy = "announcementEntities",
            cascade = CascadeType.ALL)
    private List<UserEntity> userEntities;

    @ManyToMany(
            mappedBy = "announcementEntities",
            cascade = CascadeType.ALL)
    private List<CourseEntity> courseEntities;
}
