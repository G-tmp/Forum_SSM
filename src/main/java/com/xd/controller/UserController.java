package com.xd.controller;




import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xd.pojo.Post;
import com.xd.pojo.Reply;
import com.xd.pojo.User;
import com.xd.service.PostService;
import com.xd.service.ReplyService;
import com.xd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

    @Autowired
    private ReplyService replyService;





    @RequestMapping("forbiden")
    public String error(Model model){

        model.addAttribute("error","Permission denied");

        return "error";
    }
    
    
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(Model model){
        return "login";
    }

    
    
    @ResponseBody
    @RequestMapping(value = "/login" , method = RequestMethod.POST)
    public String login(@RequestBody User user, HttpSession session){
        Map map = new HashMap();
        ObjectMapper objectMapper = new ObjectMapper();
        String json = null;
        // 得到登陆user
        User u=userService.login(user);

        //不存在用户
        if (u == null){
            map.put("msg","null");

        //密码错误
        }else if (!u.getPassword().equals(user.getPassword())){
            map.put("msg","wrong");

        //封号
        }else if (u.getStates() == -1){
            map.put("msg","banned");

        //登陆成功,设置session
        }else {
            session.setAttribute("user",u);
            map.put("msg","success");
        }

        try {
            json = objectMapper.writeValueAsString(map);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return json;
    }


    
    @RequestMapping(value = "/register" , method = RequestMethod.GET)
    public String register(Model model){
        return "register";
    }

    
    
    @ResponseBody
    @RequestMapping(value = "/register" , method = RequestMethod.POST)
    public String doRegister(@RequestBody User user){

        user.setProfile("default.png");
        userService.register(user);

        String json = null;
        Map map = new HashMap();
        ObjectMapper objectMapper = new ObjectMapper();

        map.put("msg","success");
        try {
            json = objectMapper.writeValueAsString(map);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return json;
    }
    
    
    
    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String logout(Model model,HttpSession session){
        
        session.removeAttribute("user");

        return "redirect:home";
    }


    
    /**
     * Ajax
     * 
     * @param nickname
     * @return
     */
    @ResponseBody
    @RequestMapping("/check_nickname")
    public String nickname(@RequestParam("nickname") @RequestBody String nickname){

        String json = null;
        Map map = new HashMap();
        ObjectMapper objectMapper = new ObjectMapper();

        System.out.println(nickname);

        // nickname had exist
        if (userService.checkNicknane(nickname) != null){
            map.put("msg","duplicate");
        }else {
            map.put("msg","unique");
        }

        try {
            json = objectMapper.writeValueAsString(map);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return json;
    }
    
    
    
    @RequestMapping("/check_email")
    @ResponseBody
    public String mail(@RequestParam("email") @RequestBody String email){
        String json = null;
        Map map = new HashMap();
        ObjectMapper objectMapper = new ObjectMapper();

        System.out.println(email);

        // email had exist
        if (userService.checkEmail(email) != null){
            map.put("msg","duplicate");
        }else {
            map.put("msg","unique");
        }

        try {
            json = objectMapper.writeValueAsString(map);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return json;
    }
    
    
    
    @RequestMapping(value = "/user/{nickname}",method = RequestMethod.GET)
    public String profiles(Model model,@PathVariable String nickname){
        
        User u = userService.getUserByNickname(nickname);
        System.out.println(u);

        List<Post> posts = postService.getPostsByUserId(u.getId());
        model.addAttribute("posts",posts);

//        List<Reply> replies = replyService.getRepliesByUserId(u.getId());
//        model.addAttribute("replies",replies);
//
        
        model.addAttribute("user",u);

        return "user";
    }



    @RequestMapping("/profile")
    public String myProfile(Model model,HttpSession session){

        User u = (User) session.getAttribute("user");

        if (u == null){
            model.addAttribute("error","请先登陆");
            return "error";
        }

        model.addAttribute("user",u);

        List<Post> posts = postService.getPostsByUserId(u.getId());
        model.addAttribute("posts",posts);

//        List<Reply> replies = replyService.getRepliesByUserId(u.getId());
//        model.addAttribute("replies",replies);

        return "profile";
    }



    @ResponseBody
    @RequestMapping(value = "/uploadImg",method = RequestMethod.POST)
    public String upload(@RequestParam("img") MultipartFile img, HttpServletRequest request){
        HttpSession session = request.getSession();

        System.out.println("img : "+img);
        String json = null;
        Map map = new HashMap();
        ObjectMapper objectMapper = new ObjectMapper();
        String path = "resources/img_profile/";

        User user = (User) session.getAttribute("user");

        String imgName = null;
        try {
            imgName = userService.updateProfileImg(user,img,request);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("imgName : " + imgName);

        if (imgName == null){
            System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
            map.put("msg","failed");
        }else {
            map.put("msg","success");
            map.put("path",path+imgName);
        }

        try {
            json = objectMapper.writeValueAsString(map);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return json;
    }


    @RequestMapping(value = "updateMe",method = RequestMethod.GET)
    public String modify(Model model,HttpSession session){

        User me = (User) session.getAttribute("user");

        if (me == null){
            model.addAttribute("error","请先登陆");
            return "error";
        }

        model.addAttribute("user",me);

        return "user_update";
    }


    @RequestMapping(value = "updateMe",method = RequestMethod.POST)
    public String modify(Model model,User me,HttpSession session){

        userService.updateInfo(me);
        User user = userService.getUserById(me.getId());

        session.setAttribute("user",user);

        return "redirect:profile";
    }


    @RequestMapping(value = "ban",method = RequestMethod.GET)
    public String ban(Model model,Integer uid){

        userService.ban(uid);
        String nickname = userService.getUserById(uid).getNickname();

        return "redirect:u/"+nickname;
    }


//    @RequestMapping("report")
//    public String report(Model model,Integer rid){
//
//
//        return "";
//    }
}