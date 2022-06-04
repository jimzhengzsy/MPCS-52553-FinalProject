package com.finalproject.mycanvas.announcement.services;

import com.finalproject.mycanvas.announcement.entity.AnnouncementEntity;
import com.finalproject.mycanvas.announcement.model.Announcement;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AnnouncementServiceImpl implements AnnouncementService{
    @Override
    public ResponseEntity createAnnouncement(Announcement announcement) throws Exception {
        AnnouncementEntity announcementEntity = new AnnouncementEntity();
        BeanUtils.copyProperties(announcement,announcementEntity);
        return ResponseEntity.ok(announcement);
    }
}
