package com.xd.controller;


import com.xd.pojo.Reply;
import com.xd.pojo.User;
import com.xd.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.faces.annotation.RequestMap;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("")
public class ReplyController {
        
    @Autowired
    private ReplyService replyService;

    
    
    @ResponseBody
    @RequestMapping("/publishReply")
    public String publishReply(@RequestBody  Reply reply, HttpSession session){
        
        System.out.println(reply);
        User u = (User) session.getAttribute("user");
        
        reply.setUser(u);
        
//        Reply r = new Reply();
//        r.setId(0);
//        reply.setReplyTo(r);
        System.out.println(reply.getReplyTo());

        replyService.publishReply(reply);

        return "{msg:success}";
    }

}
