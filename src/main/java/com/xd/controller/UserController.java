package com.xd.controller;



import com.alibaba.fastjson.JSONObject;
import com.xd.pojo.Post;
import com.xd.pojo.Reply;
import com.xd.pojo.User;
import com.xd.service.PostService;
import com.xd.service.ReplyService;
import com.xd.service.UserService;
import com.xd.utils.UploadImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
        User u=userService.login(user);
        
        JSONObject json=new JSONObject();
        
        //不存在用户
        if (u==null){
            json.put("msg","null");
            return json.toString();
        }
        
        //密码错误
        if (!u.getPassword().equals(user.getPassword())){
            json.put("msg","wrong");
            return json.toString();
        }

        if (u.getIsBanned() !=0 ){
            json.put("msg","banned");
            return json.toString();
        }

        //登陆成功,设置session
        session.setAttribute("user",u);

        json.put("msg","success");
        return json.toString();
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

        JSONObject json=new JSONObject();

        json.put("msg","success");

        return json.toString();
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

        JSONObject json = new JSONObject();

        System.out.println(nickname);

        // exist
        if (userService.checkNicknane(nickname) != null){
            json.put("msg","duplicate");
            return json.toString();
        }

        json.put("msg","unique");
        return json.toString();
    }
    
    
    
    @RequestMapping("/check_email")
    @ResponseBody
    public String mail(@RequestParam("email") @RequestBody String email){
        JSONObject json = new JSONObject();

        System.out.println(email);

        // exist
        if (userService.checkEmail(email) != null){
            json.put("msg","duplicate");
            return json.toString();
        }
        
        json.put("msg","unique");
        return json.toString();
    }
    
    
    
    @RequestMapping(value = "/u/{nickname}",method = RequestMethod.GET)
    public String profiles(Model model,@PathVariable String nickname){
        
        User u = userService.getUserByNickname(nickname);

        List<Post> posts = postService.getPostsByUserId(u.getId());
        model.addAttribute("posts",posts);

        List<Reply> replies = replyService.getReplysByPostid(u.getId());
        model.addAttribute("replies",replies);
        
        
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

        List<Reply> replies = replyService.getReplysByPostid(u.getId());
        model.addAttribute("replies",replies);

        return "profile";
    }



    @ResponseBody
    @RequestMapping(value = "/uploadImg",method = RequestMethod.POST)
    public String upload(@RequestParam("img") MultipartFile img, HttpServletRequest request){
        HttpSession session = request.getSession();

        System.out.println("img : "+img);
        JSONObject json = new JSONObject();

        User user = (User) session.getAttribute("user");

        String path = "resources/img_profile/";

        String imgName = userService.updateProfileImg(user,img,path,session);

        System.out.println("controller" + imgName);

        if (imgName == null){
            System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
            json.put("msg","failed");
            return json.toString();
        }


        json.put("msg","success");
        json.put("path",path+imgName);

        return json.toString();
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


    @RequestMapping("report")
    public String report(Model model,Integer rid){


        return "";
    }
}