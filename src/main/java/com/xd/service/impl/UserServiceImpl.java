package com.xd.service.impl;

import com.xd.mapper.UserMapper;
import com.xd.pojo.User;
import com.xd.service.UserService;
import com.xd.utils.UploadImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;


@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserMapper userMapper;
    
    
    
    @Override
    public User login(User user) {
        return userMapper.login(user);
    }

    @Override
    public Integer register(User user) {
        return userMapper.register(user);
    }

    @Override
    public User checkNicknane(String nickName) {
        return userMapper.checkNickname(nickName);
    }

    @Override
    public User checkEmail(String email) {
        return userMapper.checkEmail(email);
    }

    @Override
    public User getUserByNickname(String nickname) {
        return userMapper.getUserByNickname(nickname);
    }

    @Override
    public String updateProfileImg(User user, MultipartFile img, String savePath, HttpSession session) {
        String path = session.getServletContext().getRealPath(savePath);
        String imgName = UploadImage.upload(img,path);

        if (imgName == null){
            return null;
        }

        user.setProfile(imgName);
        userMapper.updateProfileImg(user);

        return imgName;
    }
}