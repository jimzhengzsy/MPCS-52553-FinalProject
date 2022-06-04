package com.finalproject.mycanvas.users.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "users_info")
public class UserInfoEntity {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String role;

    @OneToOne
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "id"
    )
    private UserEntity userEntity;
}
