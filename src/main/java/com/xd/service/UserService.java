package com.xd.service;

import com.xd.pojo.User;

public interface UserService {

    //登陆
    User login(User user);

    //sign up
    Integer register(User user);

    //check nickname 
    User checkNicknane(String nickName);

    // check email
    User checkEmail(String email);

    // find user via nickname
    User getUserByNickname(String nickname);

    Integer updateProfileImg(User user);
}
