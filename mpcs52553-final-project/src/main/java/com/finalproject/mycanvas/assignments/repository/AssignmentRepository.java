package com.finalproject.mycanvas.assignments.repository;

import com.finalproject.mycanvas.assignments.entity.AssignmentEntity;
import com.finalproject.mycanvas.users.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssignmentRepository extends JpaRepository<AssignmentEntity, Long> {
}
