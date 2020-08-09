package com.xd.service.impl;

import com.xd.dao.UserDao;
import com.xd.pojo.User;
import com.xd.service.UserService;
import com.xd.utils.UploadImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserDao userDao;
    
    
    
    @Override
    public User login(User user) {
        return userDao.login(user);
    }

    @Override
    public Integer register(User user) {
        user.setRegisterTime(System.currentTimeMillis());
        return userDao.register(user);
    }

    @Override
    public User checkNicknane(String nickName) {
        return userDao.checkNickname(nickName);
    }

    @Override
    public User checkEmail(String email) {
        return userDao.checkEmail(email);
    }

    @Override
    public User getUserByNickname(String nickname) {
        return userDao.getUserByNickname(nickname);
    }

    @Override
    public User getUserById(Integer id) {
        return userDao.getUserById(id);
    }

    @Override
    public String updateProfileImg(User user, MultipartFile img, String savePath, HttpSession session) {
        String path = session.getServletContext().getRealPath(savePath);
        String imgName = UploadImage.upload(img,path);

        if (imgName == null){
            return null;
        }

        user.setProfile(imgName);
        userDao.updateProfileImg(user);

        return imgName;
    }

    @Override
    public Integer updateInfo(User user) {
        return userDao.updateInfo(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public Integer ban(Integer uid) {
        return userDao.ban(uid);
    }
}