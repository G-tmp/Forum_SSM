package com.xd.service.impl;

import com.xd.dao.PostDao;
import com.xd.pojo.Post;
import com.xd.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private static final int ONE_DAY_IN_SECONDS = 86400;
    private static final int VOTE_SCORE = 4320;

    @Autowired 
    private PostDao postDao;
    



    
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
        post.setLastReplyTime(System.currentTimeMillis());
        post.setPublishTime(System.currentTimeMillis());

        return postDao.publishPost(post);
    }

    @Override
    public Integer IncreaseReplyCount(Integer id,Long timestamp) {
        return postDao.IncreaseReplyCount(id,timestamp);
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
