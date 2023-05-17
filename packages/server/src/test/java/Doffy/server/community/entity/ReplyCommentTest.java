package Doffy.server.community.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReplyCommentTest {
    private Reply reply;
    private ReplyComment replyComment1;
    private ReplyComment replyComment2;


    @BeforeEach
    public void setUp() {
        //given
        reply = Reply.builder()
                .replyId(1L)
                .replyBody("body")
                .isAccepted(true)
                .createdAt(LocalDateTime.now())
                .build();

        //when
        replyComment1 = ReplyComment.builder()
                .replyCommentId(1L)
                .replyCommentBody("test 1")
                .reply(reply)
                .build();

        replyComment2 = ReplyComment.builder()
                .replyCommentId(2L)
                .replyCommentBody("test 2")
                .reply(reply)
                .build();

        List<ReplyComment> comments = Arrays.asList(replyComment1,replyComment2);
        System.out.println(comments);

        reply.setReplyComments(comments);
        System.out.println(reply);
    }
    @Test
    public void testCommentAttributes(){
        //then
        assertEquals(1L, replyComment1.getReplyCommentId());
        assertEquals(2L, replyComment2.getReplyCommentId());
        assertEquals(2, reply.getReplyComments().size());
        assertEquals("test 1", replyComment1.getReplyCommentBody());
        assertEquals(reply, replyComment1.getReply());

    }

}