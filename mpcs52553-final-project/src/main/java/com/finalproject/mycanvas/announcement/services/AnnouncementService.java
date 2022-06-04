package com.finalproject.mycanvas.announcement.services;

import com.finalproject.mycanvas.announcement.model.Announcement;
import org.springframework.http.ResponseEntity;

public interface AnnouncementService {
    ResponseEntity createAnnouncement(Announcement announcement) throws Exception;
}
