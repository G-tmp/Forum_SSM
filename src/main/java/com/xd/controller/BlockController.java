package com.xd.controller;


import com.xd.pojo.Block;
import com.xd.pojo.Post;
import com.xd.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class BlockController {
    
    @Autowired
    private BlockService blockService;
    
    
    
    @RequestMapping(value = "block/{ename}",method = RequestMethod.GET)
    public String getBlockByEname(Model model,@PathVariable String ename){
        
        List<Post> posts = blockService.getBlockByEname(ename).getPosts();
        model.addAttribute("posts",posts);
        
        return "home";
    }
    
}
