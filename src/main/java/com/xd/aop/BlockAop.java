package com.xd.aop;


import com.xd.service.BlockService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.ui.Model;


@Aspect
public class BlockAop {

    @Autowired
    private BlockService blockService;



    @Before("execution(* com.xd.controller.*.*(..)) && args(model,..)")
    public void getAllBlocks(Model model){
        System.out.println("**********************************");
//        model.addAttribute("blocks",blockService.getAllBlock());
    }

}
