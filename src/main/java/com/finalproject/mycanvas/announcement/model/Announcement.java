package com.finalproject.mycanvas.announcement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Announcement {
    private long id;
    private long teacherId;
    private String content;
}
