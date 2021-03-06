package com.xd.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xd.pojo.Post;
import com.xd.pojo.Reply;
import com.xd.pojo.User;
import com.xd.service.PostService;
import com.xd.service.ReplyService;
import com.xd.utils.FilterUtil;
import com.xd.vo.ReplyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("")
public class ReplyController {
        
    @Autowired
    private ReplyService replyService;

    @Autowired
    private PostService postService;
    


    @ResponseBody
    @RequestMapping("/publishReply")
    public String publishReply(ReplyVO replyVO, HttpServletRequest request){
        MultipartFile img = replyVO.getImgFile();
        System.out.println(img);

        HttpSession session = request.getSession();
        ObjectMapper objectMapper = new ObjectMapper();
        Map map = new HashMap();
        String json = null;

        User u = (User) session.getAttribute("user");

        //do not login
        if(u == null){
            map.put("msg","unlogin");

            try {
                json = objectMapper.writeValueAsString(map);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }

            return json;
        }

        Reply reply = new Reply();

        reply.setUser(u);
        reply.setContent(replyVO.getContent());
        reply.setReplyTo(replyVO.getReplyTo());
        reply.setPost(replyVO.getPost());

        //        reply.setContent(FilterUtil.filter(reply.getContent()));

        if (img!=null) {
            try {
                String imgPath = replyService.uploadImg(img, request);
                reply.setImgPath(imgPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

//        Reply r = new Reply();
//        r.setId(0);
//        reply.setReplyTo(r);

        System.out.println(reply);
        replyService.publishReply(reply);

        System.out.println("************************************************************");
        System.out.println(reply.getContent());
        System.out.println("************************************************************");


        map.put("msg","success");
        try {
            json = objectMapper.writeValueAsString(map);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return json;
    }


    @RequestMapping("post/report_reply")
    public String report_post(Model model,Integer pid, Integer rid,HttpSession session){

        User u = (User) session.getAttribute("user");

        //do not login
        if(u == null){
            model.addAttribute("error","请先登陆");
            return "error";
        }

        replyService.reportReply(rid);

        return "redirect:../post/"+pid;
    }


    @RequestMapping("post/del_reply")
    public String del_reply(Model model,HttpSession session,Integer pid,Integer rid){

        User u = (User) session.getAttribute("user");

        //do not login
        if(u == null || u.getStates()<7){
            model.addAttribute("error","无权限");
            return "error";
        }

        replyService.deleteReply(rid);

        return "redirect:../post/"+pid;
    }
}
