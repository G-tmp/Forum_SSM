package com.xd.service;

import com.xd.pojo.User;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;

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

    /**
     * if success , return image name
     *
     * @param user
     * @param img
     * @param savePath
     * @param session
     * @return
     */
    public String updateProfileImg(User user, MultipartFile img, String savePath, HttpSession session);
}
