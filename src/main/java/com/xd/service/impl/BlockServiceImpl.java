package com.xd.service.impl;

import com.xd.mapper.BlockMapper;
import com.xd.pojo.Block;
import com.xd.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BlockServiceImpl implements BlockService {

    @Autowired
    private BlockMapper blockMapper;

    
    public List<Block> getAllBlock() {
        return blockMapper.getAllBlock();
    }

    public Block getBlockByEname(String ename) {
        return blockMapper.getBlockByEname(ename);
    }
}
