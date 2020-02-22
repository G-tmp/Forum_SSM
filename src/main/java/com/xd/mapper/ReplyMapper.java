package com.xd.mapper;


import com.xd.pojo.Reply;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReplyMapper {

    
    List<Reply> getReplysByPostid(Integer id);
    
    
    Integer publishReply(Reply reply);


    Reply getReplyById(Integer id);


    Integer getReplyTotalCount(Integer id);


    List<Reply> getPageReplysByPostid(@Param("id") Integer id,@Param("start") Integer start,@Param("size") Integer size);
}