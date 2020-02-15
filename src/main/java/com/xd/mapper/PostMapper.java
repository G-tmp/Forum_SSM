package com.xd.mapper;

import com.xd.pojo.Post;

import java.util.List;

public interface PostMapper {
    
    //get all posts
    List<Post> getAllPosts();
    
    //get all posts sort by publish time
    List<Post> getAllPostsNew();
    
    //get a post
    Post getPostById(Integer id);
    
    //add a post
    Integer publishPost(Post post);

    // increase one
    Integer IncreaseReplyCount(Integer id);

    List<Post> pagePost(Integer start,Integer size);

    List<Post> pagePostNew(Integer start,Integer size);

}
