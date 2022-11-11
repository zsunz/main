package com.example.demo2.domain.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserDto { // SETTER까지 포함

    private long id; // PK
    private String user;
    private String password;
    private String name;
    private String email;


//    public UserDto(String user, String password, String name, String email){
//        this.user = user;
//        this.password = password;
//        this.name = name;
//        this.email = email;
//    }



}
