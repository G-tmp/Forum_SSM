package com.xd.controller;


import com.xd.pojo.Block;
import com.xd.pojo.Post;
import com.xd.service.BlockService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



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


//    @Before("execution(* com.xd.controller.*.*(..)) && args(model,..)")
//    public void getAllBlock(Model model) {
//        model.addAttribute("blocks",blockService.getAllBlock());
//        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXX");
//    }
}
