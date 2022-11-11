package com.example.demo2.controller;

import com.example.demo2.domain.user.User;
import com.example.demo2.domain.user.UserDto;
import com.example.demo2.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.apache.logging.log4j.util.PerformanceSensitive;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class UserController {

    @Autowired
    private UserService service;

//    private UserService service;
//    public UserController(UserService service) {
//        this.service = service;
//    }


    //post
    //joimUser
    // 방법 1. 요청 파라미터 사용
//    @PostMapping("/v1/create/user")
//    public User joinUser(@RequestParam String user, @RequestParam String password, @RequestParam String name, @RequestParam String email){
//        UserDto userDto = null;

    // 방법2. url 패스값 사용
//    @PostMapping("/v1/join/user/{id}/{password}/{name}/{email}")
//    public User joinUser(@PathVariable String user, @PathVariable String password, @PathVariable String name, @PathVariable String email){
//        UserDto userDto = null;
//        userDto = new UserDto(user, password, name, email);
//        User result = service.createUser(userDto);
//
//        return result;
//
//    }

    // 방법3. 요청 객체 사용
    @PostMapping("/v1/join/user")
    public User joinUser(@RequestBody UserDto userDto){
        User result = service.createUser(userDto);
        return result;
    }



    @GetMapping("/v1/search/user")
    public User getUser(@RequestParam long id){
        User user = null;
        user = service.readUserById(id);
        return user;
    }

    @PostMapping("/v1/search/user/id")
    public User getUserByUserAndPassword(@RequestParam String user, @RequestParam String password){
        User result = service.readUserByUserAndPassword(user, password);
        return result;
    }

    //login
    @PostMapping("/v1/login/user")
    public void login(UserDto userDto, HttpServletRequest request){
        String user = request.getParameter("user");
        String password = request.getParameter("password");


        HttpSession session = request.getSession();
        session.setAttribute("log", 1);
    }

    //getUserAll
    @GetMapping("/v1/search/user/all")
    public List<User> getUserAll(){
        List<User> user = service.readUserAll();
         return user;

    }

    //post
    //updateUser
    @PostMapping("/v1/update/user")
    public void resettingUser(@RequestBody UserDto userDto){
        service.updateUser(userDto);
    }


    //post
    //deleteUser
//    @PostMapping("/v1/delete/user")
//    public void removeUser(long id){
//        service.deleteUser(id);
//    }

    @DeleteMapping("/v1/leave/user")
    public void leaveUser(@RequestParam long id){
        service.deleteUser(id);
    }



}
