package com.xd.service;

import com.xd.pojo.Reply;

import java.util.List;

public interface ReplyService {
    
    
    List<Reply> getReplysByPostid(Integer id);


    Integer publishReply(Reply reply);
}
