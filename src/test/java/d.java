import com.xd.pojo.Block;
import com.xd.pojo.Post;
import com.xd.pojo.Reply;
import com.xd.pojo.User;
import com.xd.service.BlockService;
import com.xd.service.PostService;
import com.xd.service.ReplyService;
import com.xd.service.UserService;
import com.xd.utils.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:config/spring-mybatis.xml")
public class d {
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private BlockService blockService;
    
    @Autowired
    private ReplyService replyService;
    
    @Autowired
    private PostService postService;
    
    
    @Test
    public void asdfg(){

        Page<Reply> replyPage = replyService.getPageReplysByPostid(1,1,3);

        for (Reply e:replyPage.getList()){
            System.out.println(e);
        }

    }
    
}
