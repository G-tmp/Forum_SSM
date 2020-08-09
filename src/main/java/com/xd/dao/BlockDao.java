package com.xd.dao;

import com.xd.pojo.Block;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BlockDao {

    // list all block
    List<Block> getAllBlock();
    
    //find block via ename
    Block getBlockByEname(String ename);


    Integer addBlock(Block block);


    Integer updateBlock(Block block);
}
