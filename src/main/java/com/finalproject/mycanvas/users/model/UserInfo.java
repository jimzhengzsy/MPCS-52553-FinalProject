package com.finalproject.mycanvas.users.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserInfo {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String role;
}
