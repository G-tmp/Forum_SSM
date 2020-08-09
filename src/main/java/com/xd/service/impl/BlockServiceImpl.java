package com.xd.service.impl;

import com.xd.dao.BlockDao;
import com.xd.pojo.Block;
import com.xd.service.BlockService;
import com.xd.utils.SerializeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class BlockServiceImpl implements BlockService {

    @Autowired
    private BlockDao blockDao;

    @Autowired
    private JedisPool jedisPool;

    Logger logger = LoggerFactory.getLogger(this.getClass());



    public List<Block> getAllBlock() {      //TODO
        String key = "blocks:";

        Jedis jedis = jedisPool.getResource();

        // cache hit
        if (jedis.exists(key)){
            List<Block> blockCache = new ArrayList<>();
            Set<String> smembers = jedis.smembers(key);

            for (String s:smembers){
                Block b = SerializeUtil.string2Obj(s,Block.class);
                blockCache.add(b);
            }

            logger.info("get blocks from redis");

            return blockCache;
        }

        // cache miss
        List<Block> blocks = blockDao.getAllBlock();
        if (blocks != null) {
            for (Block e : blocks) {
                jedis.sadd(key, SerializeUtil.obj2String(e));
            }
        }

        logger.info("get blocks from database");

        return blocks;
    }



    @Override
    public Block getBlockByEname(String ename) {
        Jedis jedis = jedisPool.getResource();
        String key = "block:"+ename;

        // cache hit
        if (jedis.exists(key)){
            String s = jedis.get(key);
            Block block = SerializeUtil.string2Obj(s,Block.class);
            logger.info("get {} from cache",block);
            return block;
        }


        // cache miss
        Block block = blockDao.getBlockByEname(ename);
        if (block != null){
            jedis.set(key,SerializeUtil.obj2String(block));
        }

        logger.info("get {} from database",block);
        return block;
    }


    @Override
    public Integer addBlock(Block block) {
        String key = "blocks:";

        // clear cache
        try (Jedis jedis = jedisPool.getResource()){
            jedis.del(key);
        }

        return blockDao.addBlock(block);
    }


    @Override
    public Integer updateBlock(Block block) {
        String key = "blocks:";

        // clear cache
        try (Jedis jedis = jedisPool.getResource()){
            jedis.del(key);
            jedis.del("block:"+block.getEname());
        }

        return blockDao.updateBlock(block);
    }

}
