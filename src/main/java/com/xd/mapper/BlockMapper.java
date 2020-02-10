package com.xd.mapper;

import com.xd.pojo.Block;

import java.util.List;

public interface BlockMapper {

    // list all block
    List<Block> getAllBlock();
    
    //find block via ename
    Block getBlockByEname(String ename);
    
}
