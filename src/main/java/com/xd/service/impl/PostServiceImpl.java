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
        return postMapper.publishPost(post);
    }

    @Override
    public void IncreaseReplyCount(Integer id) {
        postMapper.IncreaseReplyCount(id);
    }
}
