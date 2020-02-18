package com.xd.service.impl;

import com.xd.mapper.PostMapper;
import com.xd.mapper.ReplyMapper;
import com.xd.pojo.Reply;
import com.xd.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReplyServiceImpl  implements ReplyService {

    @Autowired
    private ReplyMapper replyMapper;

    @Autowired
    private PostMapper postMapper;




    @Override
    public List<Reply> getReplysByPostid(Integer id) {
        return replyMapper.getReplysByPostid(id);
    }


    @Transactional      //事务
    @Override
    public Integer publishReply(Reply reply) {
        postMapper.IncreaseReplyCount(reply.getPost().getId());
        return replyMapper.publishReply(reply);
    }

    @Override
    public Reply getReplyById(Integer id) {
        return replyMapper.getReplyById(id);
    }


}
