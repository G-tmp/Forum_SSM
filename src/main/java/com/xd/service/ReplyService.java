package com.xd.service;

import com.xd.pojo.Reply;
import com.xd.utils.Page;

import java.util.List;

public interface ReplyService {
    
    
    List<Reply> getReplysByPostid(Integer id);


    Integer publishReply(Reply reply);


    Reply getReplyById(Integer id);


    Integer getReplyTotalCount(Integer id);


    Page<Reply> getPageReplysByPostid(Integer id, Integer cur, Integer size);
}
