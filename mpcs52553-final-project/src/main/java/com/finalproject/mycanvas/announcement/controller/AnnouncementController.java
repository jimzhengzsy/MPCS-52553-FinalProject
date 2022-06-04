package com.finalproject.mycanvas.announcement.controller;


import com.finalproject.mycanvas.announcement.model.Announcement;
import com.finalproject.mycanvas.announcement.services.AnnouncementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/")
public class AnnouncementController {

    private final AnnouncementService announcementService;

    public AnnouncementController(AnnouncementService announcementService) {
        this.announcementService = announcementService;
    }

    @PostMapping("/announcements")
    public ResponseEntity createAnnouncement(@RequestBody Announcement announcement) throws Exception{
        return announcementService.createAnnouncement(announcement);
    }



}
