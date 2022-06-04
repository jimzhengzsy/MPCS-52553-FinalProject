package com.finalproject.mycanvas.users.entity;

import lombok.Data;

@Data
public class LoginData {
    String email;
    String password;

    public LoginData(String email, String password) {
        this.email = email;
        this.password = password;}

}
