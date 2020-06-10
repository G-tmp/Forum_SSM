package com.xd.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class Post implements Serializable {
    private Integer id;
    private String title;
    private String content;
    private Integer hit;
    private Integer votes;
    private Integer replyCount;
    private User user;
    private Block block;
    private Integer publishTime;
    private Integer lastReplyTime;
    private Integer isBanned;

    
    public Post(){
        
    }

    public Post(String pid){
        this.id = Integer.parseInt(pid);
    }
    
    @Override
    public String toString() {
        return String.format("%s[id=%d,title=%s]",this.getClass().getName(),id,title);
    }
    
    
    
    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getHit() {
        return hit;
    }

    public void setHit(Integer hit) {
        this.hit = hit;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Block getBlock() {
        return block;
    }

    public void setBlock(Block block) {
        this.block = block;
    }

    public Integer getVotes() {
        return votes;
    }

    public void setVotes(Integer votes) {
        this.votes = votes;
    }

    public Integer getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(Integer replyCount) {
        this.replyCount = replyCount;
    }


    public Integer getIsBanned() {
        return isBanned;
    }

    public void setIsBanned(Integer isBanned) {
        this.isBanned = isBanned;
    }

    public Integer getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Integer publishTime) {
        this.publishTime = publishTime;
    }

    public Integer getLastReplyTime() {
        return lastReplyTime;
    }

    public void setLastReplyTime(Integer lastReplyTime) {
        this.lastReplyTime = lastReplyTime;
    }
}
