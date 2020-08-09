package com.xd.aop;


import com.xd.pojo.Block;
import com.xd.service.BlockService;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import java.util.List;


@Component
@Aspect
public class BlockAop {

    @Autowired
    private BlockService blockService;


    @Before("execution(* com.xd.controller.*.*(..)) && args(model,..)")
    public void getAllBlocks(Model model){
        List<Block> allBlock = blockService.getAllBlock();

        System.out.println("AOP-AOP-AOP-AOP-AOP-AOP-AOP-AOP-AOP-AOP-AOP-AOP-AOP");
        model.addAttribute("blocks",allBlock);
    }

}
