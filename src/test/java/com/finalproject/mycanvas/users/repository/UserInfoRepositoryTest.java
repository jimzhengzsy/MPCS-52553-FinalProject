package com.finalproject.mycanvas.users.repository;

import com.finalproject.mycanvas.users.entity.UserInfoEntity;
import com.finalproject.mycanvas.users.model.User;
import com.finalproject.mycanvas.users.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserInfoRepositoryTest {
    @Autowired
    

    public void SaveUserInfo() {
        User user = User.builder()
                .firstName("Lebron")
                .lastName("James")
                .email("LBJ23@gmail.com")
                .role("student")
                .status("active")
                .password("LBJ")
                .loginQuestion1("Lakers")
                .loginQuestion2("Basketball")
                .loginQuestion3("Nike")
                .build();

        UserInfo userInfo = UserInfo.builder()
                .email("LBJ23@gmail.com")
                .firstName("LB")
                .lastName("J")
                .build();

    }
}