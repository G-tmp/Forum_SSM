package com.xd.controller;


import com.alibaba.fastjson.JSONObject;
import com.xd.pojo.Post;
import com.xd.pojo.Reply;
import com.xd.pojo.User;
import com.xd.service.BlockService;
import com.xd.service.PostService;
import com.xd.service.ReplyService;
import com.xd.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private BlockService blockService;

    @Autowired
    private ReplyService replyService;
    




    @RequestMapping("/home")
    public String home(Model model){

        List<Post> posts = postService.getAllPosts();
        model.addAttribute("posts",posts);

        return "home";
    }


    @RequestMapping("/new")
    public String neww (Model model){

        List<Post> posts = postService.getAllPostsNew();
        model.addAttribute("posts",posts);

        return "home";
    }

    private static int PAGESIZE = 10;

    @RequestMapping(value = "/post/{pid}",method = RequestMethod.GET)
    public String post(Model model, @PathVariable(value = "pid") Integer pid ,@RequestParam(value = "p",required = false) Integer page){

        Post post = postService.getPostById(pid);
        model.addAttribute("post",post);

//        List<Reply> replies = replyService.getReplysByPostid(pid);
//        model.addAttribute("replies",replies);

        try {
            Page<Reply> replyPage = replyService.getPageReplysByPostid(pid,page,PAGESIZE);
            model.addAttribute("replyPage",replyPage);
        }catch (Exception e){
            e.printStackTrace();
        }


        return  "post";
    }



    @ResponseBody
    @RequestMapping(value = "/publishPost",method = RequestMethod.POST)
    public String addPost(@RequestBody Post post, HttpSession session){

        JSONObject json = new JSONObject();

        User u = (User) session.getAttribute("user");

        if (u == null){
            json.put("msg","unlogin");
            return json.toString();
        }


        post.setUser(u);

        postService.publishPost(post);

        json.put("msg","success");
        
        
        return json.toString();
    }


    @RequestMapping(value = "/search",method = RequestMethod.GET)
    public String searchTitle(Model model,String words){
        words = words.trim();

        if (words==""){
            model.addAttribute("error","不能为空");
            return "error";
        }


        List<Post> posts = postService.fuzzySearchTitle(words);
        model.addAttribute("posts",posts);

        return "home";
    }


    @RequestMapping("post/report_post")
    public String report_post(Model model,Integer pid,HttpSession session){

        User u = (User) session.getAttribute("user");

        //do not login
        if(u == null){
            model.addAttribute("error","请先登陆");
            return "error";
        }

        postService.reportPost(pid);

        return "home";
    }

    @RequestMapping("del")
    public String delPost(Model model,Integer pid){

        return "";
    }
}