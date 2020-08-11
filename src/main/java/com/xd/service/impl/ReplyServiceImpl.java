package com.xd.service.impl;

import com.xd.dao.PostDao;
import com.xd.dao.ReplyDao;
import com.xd.pojo.Reply;
import com.xd.service.ReplyService;
import com.xd.utils.Page;
import com.xd.utils.UploadImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Service
public class ReplyServiceImpl  implements ReplyService {

    @Autowired
    private ReplyDao replyDao;

    @Autowired
    private PostDao postDao;




    @Override
    public List<Reply> getReplysByPostid(Integer id) {
        return replyDao.getReplysByPostid(id);
    }


    @Transactional      //事务
    @Override
    public Integer publishReply(Reply reply) {
        long now = System.currentTimeMillis();
        reply.setPublishTime(now);

        return postDao.IncreaseReplyCount(reply.getPost().getId(),now)   &  replyDao.publishReply(reply);
    }

    @Override
    public Reply getReplyById(Integer id) {
        return replyDao.getReplyById(id);
    }

    @Override
    public Integer getReplyTotalCount(Integer id) {
        return replyDao.getReplyTotalCount(id);
    }

    @Override
    public Page<Reply> getPageReplysByPostid(Integer id, Integer cur, Integer size) {
        Page<Reply> replyPage = new Page<>();

        replyPage.setProperties(size,cur, replyDao.getReplyTotalCount(id));
        replyPage.setList(replyDao.getPageReplysByPostid(id,(replyPage.getCur()-1)*size,size));

        return replyPage;
    }

    @Override
    public List<Reply> getRepliesByUserId(Integer uid) {
        return replyDao.getRepliesByUserId(uid);
    }

    @Override
    public Integer reportReply(Integer rid) {
        return replyDao.reportReply(rid);
    }

    @Override
    public List<Reply> getReportReply() {
        return replyDao.getReportReply();
    }

    @Override
    public Integer deleteReply(Integer rid) {
        return replyDao.deleteReply(rid);
    }

    @Override
    public String uploadImg(Reply reply, MultipartFile img, String savePath, HttpSession session) throws IOException {
        String path = session.getServletContext().getRealPath(savePath);
        String imgName = null;


        imgName = UploadImageUtil.upload(img,path);

        // upload faild
        if (imgName == null){
            return null;
        }

        // upload success
        return imgName;
    }


}
