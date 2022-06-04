package com.finalproject.mycanvas.users.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    private long id;
    private String firstName;
    private String lastName;
    private String userId;
    private String email;
    private String role;
    private String status;
    private String password;
    private String loginQuestion1;
    private String loginQuestion2;
    private String loginQuestion3;
    private String loginAnswer1;
    private String loginAnswer2;
    private String loginAnswer3;
}
