package com.xd.service.impl;

import com.xd.mapper.ReplyMapper;
import com.xd.pojo.Reply;
import com.xd.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyServiceImpl  implements ReplyService {

    @Autowired
    private ReplyMapper replyMapper;



    @Override
    public List<Reply> getReplysByPostid(Integer id) {
        return replyMapper.getReplysByPostid(id);
    }



    @Override
    public Integer publishReply(Reply reply) {
        return replyMapper.publishReply(reply);
    }

    @Override
    public Reply getReplyById(Integer id) {
        return replyMapper.getReplyById(id);
    }


}
