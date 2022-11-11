package com.example.demo2.domain.user;

import org.springframework.data.annotation.QueryAnnotation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepsoitory extends JpaRepository<User, Long > {


    @Query(value = "SELECT * FROM user WHERE user=? and password = ?", nativeQuery = true)
    public User findMyUser(String user, String password);

    public User findByUserAndPassword(String user, String password);



}
