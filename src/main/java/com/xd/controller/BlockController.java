package com.xd.controller;


import com.xd.pojo.Block;
import com.xd.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class BlockController {
    
    @Autowired
    private BlockService blockService;


    
    
    @RequestMapping(value = "b/{ename}",method = RequestMethod.GET)
    public String getBlockByEname(Model model,@PathVariable String ename){

        Block block = blockService.getBlockByEname(ename);
        model.addAttribute("block",block);

        return "block";
    }


    @RequestMapping("error")
    public String error(Model model){

        model.addAttribute("xd","xd");

        return "error";
    }

}
