package com.xd.service.impl;

import com.xd.mapper.PostMapper;
import com.xd.pojo.Post;
import com.xd.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    
    @Autowired 
    private PostMapper postMapper;
    
    
    
    @Override
    public List<Post> getAllPosts() {
        return postMapper.getAllPosts();
    }

    @Override
    public List<Post> getAllPostsNew() {
        return postMapper.getAllPostsNew();
    }

    @Override
    public Post getPostById(Integer id) {
        return postMapper.getPostById(id);
    }

    @Override
    public Integer publishPost(Post post) {
        post.setLastReplyTime(System.currentTimeMillis());
        post.setPublishTime(System.currentTimeMillis());

        return postMapper.publishPost(post);
    }

    @Override
    public Integer IncreaseReplyCount(Integer id,Long timestamp) {
        return postMapper.IncreaseReplyCount(id,timestamp);
    }

    @Override
    public List<Post> fuzzySearchTitle(String words) {
        return postMapper.fuzzySearchTitle(words);
    }

    @Override
    public Integer getPostTotalCount() {
        return postMapper.getPostTotalCount();
    }

    @Override
    public List<Post> getPostsByUserId(Integer uid) {
        return postMapper.getPostsByUserId(uid);
    }

    @Override
    public Integer reportPost(Integer pid) {
        return postMapper.reportPost(pid);
    }

    @Override
    public List<Post> getReportPost() {
        return postMapper.getReportPost();
    }

    @Override
    public Integer deletePost(Integer pid) {
        return postMapper.deletePost(pid);
    }


}
