package com.xd.mapper;

import com.xd.pojo.User;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;


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


    Integer updateProfileImg(User user);


}
