package com.finalproject.mycanvas.users.repository;

import com.finalproject.mycanvas.users.entity.UserEntity;
import com.finalproject.mycanvas.users.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    public UserEntity findByEmail(String Email);
}
