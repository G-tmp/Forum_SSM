package com.xd.service;

import com.xd.pojo.User;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

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

    User getUserById(Integer id);

    /**
     *  if success , return image name
     *  else , return null
     *
     * @param user
     * @param img
     * @param request
     * @return
     */
    public String updateProfileImg(User user, MultipartFile img, HttpServletRequest request) throws IOException;

    Integer updateInfo(User user);

    List<User> getAllUsers();

    Integer ban(Integer uid);

}
