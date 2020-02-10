package com.xd.mapper;

import com.xd.pojo.Post;

import java.util.List;

public interface PostMapper {
    
    //get all
    List<Post> getAllPosts();
    
    //get all sort by time
    List<Post> getAllPostsNew();
    
    //get one
    Post getPostById(Integer id);
    
    //add one 
    Integer publishPost(Post post);
    
    
}
