package com.xd.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xd.pojo.Block;
import com.xd.pojo.Post;
import com.xd.pojo.Reply;
import com.xd.pojo.User;
import com.xd.service.BlockService;
import com.xd.service.PostService;
import com.xd.service.ReplyService;
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

        List<Block> blocks = blockService.getAllBlock();
        model.addAttribute("blocks",blocks);

        return "home";
    }


    @RequestMapping("/new")
    public String neww (Model model){

        List<Post> posts = postService.getAllPostsNew();
        model.addAttribute("posts",posts);

        List<Block> blocks = blockService.getAllBlock();
        model.addAttribute("blocks",blocks);

        return "home";
    }


    @RequestMapping(value = "/post/{pid}",method = RequestMethod.GET)
    public String post(Model model, @PathVariable int pid){
        
        Post p = postService.getPostById(pid);
        model.addAttribute("post",p);
        
        List<Reply> replies = replyService.getReplysByPostid(pid);
        model.addAttribute("replies",replies);
        
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
}