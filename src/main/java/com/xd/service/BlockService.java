package com.xd.service;

import com.xd.pojo.Block;

import java.util.List;

public interface BlockService {

    //find all block
    List<Block> getAllBlock();

    //find block via ename
    Block getBlockByEname(String ename);


    Integer addBlock(Block block);


    Integer updateBlock(Block block);
}
