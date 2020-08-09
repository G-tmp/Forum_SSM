import com.xd.dao.PostDao;
import com.xd.dao.ReplyDao;
import com.xd.pojo.Block;
import com.xd.service.BlockService;
import com.xd.service.PostService;
import com.xd.service.ReplyService;
import com.xd.service.UserService;
import com.xd.utils.SerializeUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;
import java.util.Set;

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

    @Autowired
    private PostDao postDao;

    @Autowired
    private ReplyDao replyDao;

    @Autowired
    private JedisPool jedisPool;



    @Test
    public void asdfg(){
//
//        Page<Reply> replyPage = replyService.getPageReplysByPostid(1,1,3);
//
//        for (Reply e:replyPage.getList()){
//            System.out.println(e);
//        }

//        List<Post> posts = postMapper.getPostsByUserId(1);
//
//        for (Post e:posts)
//            System.out.println(e);

//        List<Reply> replies = replyService.getReplysByPostid(1);
//        for (Reply e:replies)
//            System.out.println(e);


        System.out.println(System.currentTimeMillis());
    }


    @Test
    public void xd(){
        Jedis jedis = jedisPool.getResource();
        String key = "blocks:";

        List<Block> allBlock = blockService.getAllBlock();
        for (Block e:allBlock)
            jedis.sadd(key,SerializeUtil.obj2String(e));


        if (jedis.exists(key)){
            Set<String> smembers = jedis.smembers(key);
            for (String s:smembers){
                Block b = SerializeUtil.string2Obj(s,Block.class);
                System.out.println(b);
            }
        }

    }


    @Test
    public void xfghdx(){
        Jedis jedis = jedisPool.getResource();
        Block block = blockService.getBlockByEname("xd");

        System.out.println(block);
    }

}
