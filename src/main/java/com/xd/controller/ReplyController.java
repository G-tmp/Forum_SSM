package com.xd.controller;


import com.alibaba.fastjson.JSONObject;
import com.xd.pojo.Reply;
import com.xd.pojo.User;
import com.xd.service.PostService;
import com.xd.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("")
public class ReplyController {
        
    @Autowired
    private ReplyService replyService;

    @Autowired
    private PostService postService;
    
    
    @ResponseBody
    @RequestMapping("/publishReply")
    public String publishReply(@RequestBody  Reply reply, HttpSession session){
        JSONObject json = new JSONObject();

        User u = (User) session.getAttribute("user");

        //do not login
        if(u == null){
            json.put("msg","unlogin");
            return json.toString();
        }


        reply.setUser(u);
        
//        Reply r = new Reply();
//        r.setId(0);
//        reply.setReplyTo(r);

        replyService.publishReply(reply);


        json.put("msg","success");

        return json.toString();
    }

}
