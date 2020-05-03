package com.xd.mapper;

import com.xd.pojo.User;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface UserMapper {


    //登陆
    User login(User user);

    //sign up
    Integer register(User user);

    //check nickname 
    User checkNickname(String nickName);

    // check email
    User checkEmail(String email);

    // find user via nickname
    User getUserByNickname(String nickname);

    User getUserById(Integer id);

    Integer updateProfileImg(User user);

    Integer updateInfo(User user);

    List<User> getAllUsers();
}
