package com.finalproject.mycanvas.announcement.repository;

import com.finalproject.mycanvas.announcement.entity.AnnouncementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnouncementRepository extends JpaRepository<AnnouncementEntity, Long> {
}
