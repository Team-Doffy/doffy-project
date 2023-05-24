//package Doffy.server.community.repository;
//
//import Doffy.server.community.entity.Reply;
//import Doffy.server.community.entity.ReplyComment;
//import Doffy.server.user.entity.User;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@DataJpaTest
//public class ReplyCommentRepositoryTest {
//
//    @Autowired
//    private ReplyCommentRepository replyCommentRepository;
//
//    @Test
//    public void testFindByUser() {
//        // given
//        User user = new User();
//        user.setUserId(1L);
//        user.setUsername("TEST");
//
//        // when
//        List<ReplyComment> replyComments = replyCommentRepository.findByUser(user);
//
//        // then
//        assertNotNull(replyComments);
//    }
//
//    @Test
//    public void testFindByReply() {
//        // given
//        Reply reply = new Reply();
//        reply.setReplyId(1L);
//        reply.setReplyBody("TEST");
//
//        // when
//        List<ReplyComment> replyComments = replyCommentRepository.findAllByReply(reply);
//
//        // then
//        assertNotNull(replyComments);
//    }
//}