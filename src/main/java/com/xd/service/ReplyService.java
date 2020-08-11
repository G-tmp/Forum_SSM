package com.xd.service;

import com.xd.pojo.Reply;
import com.xd.pojo.User;
import com.xd.utils.Page;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public interface ReplyService {
    
    
    List<Reply> getReplysByPostid(Integer id);


    Integer publishReply(Reply reply);


    Reply getReplyById(Integer id);


    Integer getReplyTotalCount(Integer id);


    Page<Reply> getPageReplysByPostid(Integer id, Integer cur, Integer size);


    List<Reply> getRepliesByUserId(Integer uid);

    Integer reportReply(Integer rid);

    List<Reply > getReportReply();

    Integer deleteReply(Integer rid);

    String uploadImg(Reply reply, MultipartFile img, String savePath, HttpSession session) throws IOException;

}
