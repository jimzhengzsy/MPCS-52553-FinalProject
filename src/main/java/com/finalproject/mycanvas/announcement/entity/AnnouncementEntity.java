package com.finalproject.mycanvas.announcement.entity;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
@Table(name = "announcements")
public class AnnouncementEntity {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;
    private long teacherId;
    private String content;

}
