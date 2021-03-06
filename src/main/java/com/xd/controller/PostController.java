package com.xd.controller;



import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xd.pojo.Block;
import com.xd.pojo.Post;
import com.xd.pojo.Reply;
import com.xd.pojo.User;
import com.xd.service.BlockService;
import com.xd.service.PostService;
import com.xd.service.ReplyService;
import com.xd.utils.FilterUtil;
import com.xd.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.Filter;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private BlockService blockService;

    @Autowired
    private ReplyService replyService;
    




    @RequestMapping({"","/home"})
    public String home(Model model){

        List<Post> posts = postService.getAllPostsNew();
        model.addAttribute("posts",posts);

        return "home";
    }


    @RequestMapping("/hot")
    public String neww (Model model){

        List<Post> posts = postService.getAllPostsHot();
        model.addAttribute("posts",posts);

        return "home";
    }

    private final static int PAGESIZE = 10;

    @RequestMapping(value = "/post/{pid}",method = RequestMethod.GET)
    public String post(Model model, @PathVariable(value = "pid") Integer pid ,@RequestParam(value = "page",required = false) Integer page){

        Post post = postService.getPostById(pid);
        if(post == null){
            model.addAttribute("error","404 Not Found");
            return "error";
        }


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
        ObjectMapper objectMapper = new ObjectMapper();
        String json = null;
        Map map = new HashMap();

        User u = (User) session.getAttribute("user");

        if (u == null){
            map.put("msg","unlogin");
            try {
                json = objectMapper.writeValueAsString(map);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }

            return json;
        }

        System.out.println(post.getBlock());

        post.setUser(u);
//        post.setTitle(FilterUtil.filter(post.getTitle()));
//        post.setContent(FilterUtil.filter(post.getContent()));

        postService.publishPost(post);

        map.put("msg","success");
        try {
            json = objectMapper.writeValueAsString(map);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return json;
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

        return "redirect:../post/"+pid;
    }

    @RequestMapping("post/del_post")
    public String delPost(Model model,Integer pid){

        postService.deletePost(pid);

        return "redirect:../home";
    }
}