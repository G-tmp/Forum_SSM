package com.xd.service.impl;

import com.xd.mapper.PostMapper;
import com.xd.mapper.ReplyMapper;
import com.xd.pojo.Reply;
import com.xd.service.ReplyService;
import com.xd.utils.Page;
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
        return postMapper.IncreaseReplyCount(reply.getPost().getId())  &  replyMapper.publishReply(reply);
    }

    @Override
    public Reply getReplyById(Integer id) {
        return replyMapper.getReplyById(id);
    }

    @Override
    public Integer getReplyTotalCount(Integer id) {
        return replyMapper.getReplyTotalCount(id);
    }

    @Override
    public Page<Reply> getPageReplysByPostid(Integer id, Integer cur, Integer size) {
        Page<Reply> replyPage = new Page<>();

        if (cur == null)
            cur = 1;
        else if (cur <= 0)
            throw new RuntimeException("cnm");

        replyPage.setProperties(size,cur,replyMapper.getReplyTotalCount(id));
        replyPage.setList(replyMapper.getPageReplysByPostid(id,(replyPage.getCur()-1)*size,size));

        return replyPage;
    }


}
