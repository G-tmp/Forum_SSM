package com.xd.pojo;

import java.io.Serializable;
import java.util.List;

public class Block implements Serializable {
    private Integer id;
    private String name;
    private String ename;
    private String description;
    private List<Post> posts;


    public Block(){
        
    }

    //发布帖子时调用
    public Block(String bid){
        this.id=Integer.parseInt(bid);
    }
    
    @Override
    public String toString() {
        return String.format("%s[id=%d,name=%s]",this.getClass().getName(),id,name);
    }
    
    
    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
