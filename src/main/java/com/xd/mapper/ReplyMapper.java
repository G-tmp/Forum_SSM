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

    List<Reply> getRepliesByUserId(@Param("uid")Integer uid);

    Integer reportReply(Integer rid);

    List<Reply > getReportReply();

     Integer deleteReply(Integer rid);
}