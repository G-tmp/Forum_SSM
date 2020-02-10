package com.xd.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class Reply  implements Serializable {
    private Integer id;
    private String content;
    private User user;
    private Post post;
    private Reply replyTo;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    private Date publishTime;
    private Integer isBanned;

    
    public Reply(){}

    public Reply(String rid){
        this.id = Integer.parseInt(rid);
    }


    @Override
    public String toString() {
        return String.format("%s[id=%d,content=%s]",this.getClass().getName(),id,content);
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

    public Reply getReplyTo() {
        return replyTo;
    }

    public void setReplyTo(Reply replyTo) {
        this.replyTo = replyTo;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public Integer getIsBanned() {
        return isBanned;
    }

    public void setIsBanned(Integer isBanned) {
        this.isBanned = isBanned;
    }
}