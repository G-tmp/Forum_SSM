package com.xd.mapper;


import com.xd.pojo.Reply;

import java.util.List;

public interface ReplyMapper {

    
    List<Reply> getReplysByPostid(Integer id);
    
    
    Integer publishReply(Reply reply);


    Reply getReplyById(Integer id);


}
