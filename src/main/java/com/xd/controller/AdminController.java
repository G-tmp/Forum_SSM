package com.xd.controller;


import com.xd.pojo.Block;
import com.xd.pojo.Post;
import com.xd.pojo.Reply;
import com.xd.pojo.User;
import com.xd.service.BlockService;
import com.xd.service.PostService;
import com.xd.service.ReplyService;
import com.xd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private BlockService blockService;

    @Autowired
    private UserService userService;

    @Autowired
    private ReplyService replyService;

    @Autowired
    private PostService postService;



    @RequestMapping("")
    public String admin(Model model, HttpSession session){

        User user = (User) session.getAttribute("user");

//        //not admin
//        if (user==null || user.getIsAdmin()==0){
//            model.addAttribute("error","无权限🙏🙏");
//            return  "error";
//        }


        return "/admin/home";
    }


    @RequestMapping("blocks")
    public String blockAdmin(Model model){
        List<Block> blocks = blockService.getAllBlock();

        model.addAttribute("blocks",blocks);

        return "admin/blocks";
    }


    @RequestMapping("users")
    public String userAdmin(Model model){

        List<User> users = userService.getAllUsers();
        model.addAttribute("users",users);

        return "/admin/users";
    }


    @RequestMapping("reports")
    public String reportAdmin(Model model){

        List<Reply> replies = replyService.getReportReply();
        model.addAttribute("replies",replies);

        List<Post> posts = postService.getReportPost();
        model.addAttribute("posts",posts);

        return "/admin/reports";
    }


    @RequestMapping(value = "addBlock",method = RequestMethod.GET)
    public String addBlock(Model model){

        return "/admin/block_add";
    }


    @RequestMapping(value = "addBlock",method = RequestMethod.POST)
    public String addBlock(Model model,Block block){

        blockService.addBlock(block);

        return "redirect:blocks";
    }

    @RequestMapping(value = "modifyBlock/{ename}",method = RequestMethod.GET)
    public String modifyBlock(Model model, @PathVariable String ename){

        Block block = blockService.getBlockByEname(ename);

        model.addAttribute("block",block);

        return "/admin/block_modify";
    }


    @RequestMapping(value = "modifyBlock",method = RequestMethod.POST)
    public String modifyBlock(Block block){

        System.out.println("##########################");


        blockService.updateBlock(block);

        return "redirect:blocks";
    }


}