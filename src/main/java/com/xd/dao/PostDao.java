package com.xd.dao;

import com.xd.pojo.Post;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PostDao {
    
    //get all posts
    List<Post> getAllPostsHot();
    
    //get all posts sort by publish time
    List<Post> getAllPostsNew();
    
    //get a post
    Post getPostById(Integer id);
    
    //add a post
    Integer publishPost(Post post);

    // increase one
    Integer IncreaseReplyCount(@Param("id") Integer id);

    List<Post> pagePost(Integer start,Integer size);

    List<Post> pagePostNew(Integer start,Integer size);

    List<Post> fuzzySearchTitle(String words);

    Integer getPostTotalCount();

    List<Post> getPostsByUserId(Integer uid);

    Integer reportPost(Integer pid);

    List< Post> getReportPost();

    Integer deletePost(Integer pid);
}
