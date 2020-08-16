package com.xd.controller;


import com.xd.pojo.Block;
import com.xd.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;
import java.io.File;
import java.io.IOException;


@Controller
public class BlockController {
    
    @Autowired
    private BlockService blockService;


    
    
    @RequestMapping(value = "block/{ename}",method = RequestMethod.GET)
    public String getBlockByEname(Model model,@PathVariable String ename){

        Block block = blockService.getBlockByEname(ename);
        model.addAttribute("block",block);

        return "block";
    }




}
