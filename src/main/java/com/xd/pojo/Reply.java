package com.xd.pojo;

import com.xd.utils.Page;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class Reply implements Serializable {
    private Integer id;
    private String content;
    private User user;
    private Post post;
    private Integer floor;
    private Integer replyTo;
    private Integer publishTime;
    private Integer isBanned;




    public Reply(){}

    public Reply(String rid){
        this.id = Integer.parseInt(rid);
    }


    @Override
    public String toString() {
        return String.format("%s[id=%d,content=%s,reply_to=%d]",this.getClass().getName(),id,content,replyTo);
    }




    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Integer getReplyTo() {
        return replyTo;
    }

    public void setReplyTo(Integer replyTo) {
        this.replyTo = replyTo;
    }

    public Integer getIsBanned() {
        return isBanned;
    }

    public void setIsBanned(Integer isBanned) {
        this.isBanned = isBanned;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Integer getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Integer publishTime) {
        this.publishTime = publishTime;
    }
}