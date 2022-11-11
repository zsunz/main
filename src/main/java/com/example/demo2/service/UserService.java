package com.example.demo2.service;


import com.example.demo2.domain.user.User;
import com.example.demo2.domain.user.UserDto;
import com.example.demo2.domain.user.UserRepsoitory;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {

    @Autowired
    private UserRepsoitory repsoitory;

    //Controller -> CRUD Method

    public User createUser(UserDto userDto){
        User user = new User(userDto);
        return repsoitory.save(user);

    }

    public User readUserByUserAndPassword(String user, String password){
        User result = repsoitory.findMyUser(user, password);

        return result;
    }

    //read
    public User readUserById(long id){
        User user = repsoitory.findById(id).orElseThrow(
                () -> new IllegalArgumentException("사용자를 찾지 못했습니    다.")
        );
        return user;
    }


    public List<User> readUserAll(){
        return repsoitory.findAll();
    }

    //Update
    @Transactional
    public void updateUser(UserDto userDto){
        User user = readUserById(userDto.getId());
        if(user != null){
            user.setUser(userDto);
        }
    }

    //login



    //Delete
    @Transactional
    public void deleteUser(long id){
        repsoitory.deleteById(id);
    }

}
