package com.xd.service.impl;

import com.xd.dao.PostDao;
import com.xd.pojo.Post;
import com.xd.service.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private static final int ONE_DAY_IN_SECONDS = 86400;
    private static final int VOTE_SCORE = 4320;

    @Autowired
    private PostDao postDao;

    @Autowired
    private JedisPool jedisPool;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    
    @Override
    public List<Post> getAllPostsHot() {
        return postDao.getAllPostsHot();
    }

    @Override
    public List<Post> getAllPostsNew() {
        return postDao.getAllPostsNew();
    }

    @Override
    public Post getPostById(Integer id) {
        return postDao.getPostById(id);
    }

    @Override
    public Integer publishPost(Post post) {
        String key = "block:" + post.getBlock().getEname();
        Jedis jedis = null;
        System.out.println(key);
        try{
            jedis = jedisPool.getResource();
        }catch(Exception e){
            logger.error("reids resources error",e);
        }

        if (jedis.exists(key)) {
            System.out.println("block exists");
            jedis.del(key);
        }

        return postDao.publishPost(post);
    }

    @Override
    public Integer IncreaseReplyCount(Integer id) {
        return postDao.IncreaseReplyCount(id);
    }

    @Override
    public List<Post> fuzzySearchTitle(String words) {
        return postDao.fuzzySearchTitle(words);
    }

    @Override
    public Integer getPostTotalCount() {
        return postDao.getPostTotalCount();
    }

    @Override
    public List<Post> getPostsByUserId(Integer uid) {
        return postDao.getPostsByUserId(uid);
    }

    @Override
    public Integer reportPost(Integer pid) {
        return postDao.reportPost(pid);
    }

    @Override
    public List<Post> getReportPost() {
        return postDao.getReportPost();
    }

    @Override
    public Integer deletePost(Integer pid) {
        return postDao.deletePost(pid);
    }


}
