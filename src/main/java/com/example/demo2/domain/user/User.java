package com.example.demo2.domain.user;


import com.example.demo2.util.Timestamp;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "user")
@Entity
@NoArgsConstructor //기본생성자
@Getter // 게터



public class User extends Timestamp { // VO (GETTER만 제공)

    @Id
    private long id; // PK
    private String user;
    private String password;
    private String name;
    private String email;

    // super.regDate
    // super.modDate
    public User(UserDto userDto){
        this.user = userDto.getUser();
        this.password = userDto.getPassword();
        this.name = userDto.getName();
        this.email = userDto.getEmail();
    }

    //Update 용 setter
    public void setUser(UserDto userDto){
        this.password = userDto.getPassword();
        this.name = userDto.getName();
        this.email = userDto.getEmail();
    }


//    public long getCode() {
//        return code;
//    }
//
//    public String getId() {
//        return id;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String getEmail() {
//        return email;
//    }

//    public User(String id, String password, String name, String email){
//        this.id = id;
//        this.password = password;
//        this.name = name;
//        this.email = email;
//    }

}
