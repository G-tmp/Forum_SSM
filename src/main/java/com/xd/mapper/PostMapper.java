package com.xd.mapper;

import com.xd.pojo.Post;
import org.apache.ibatis.annotations.Param;

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
    Integer IncreaseReplyCount(@Param("id") Integer id, @Param("timestrmp") Long timestrmp);

    List<Post> pagePost(Integer start,Integer size);

    List<Post> pagePostNew(Integer start,Integer size);

    List<Post> fuzzySearchTitle(String words);

    Integer getPostTotalCount();

    List<Post> getPostsByUserId(Integer uid);

    Integer reportPost(Integer pid);

    List< Post> getReportPost();

    Integer deletePost(Integer pid);
}
