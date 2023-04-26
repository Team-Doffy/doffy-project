package Doffy.server.community.entity;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.*;

public class ReplyTest {
    @Test
    public void testGettersAndSetters(){
        //given
        Reply reply = new Reply();
        Comment comment = new Comment();

        comment.setCommentId(3);
        comment.setCommentBody("This is Comment");

        //when
        reply.setReplyId(1);
        reply.setReplyBody("This is Reply");
        reply.setAccepted(true);
        reply.setCreatedAt(LocalDateTime.now());

        //then
        assertThat(reply.getReplyId()).isEqualTo(1);
        assertThat(reply.getReplyBody()).isEqualTo("This is Reply");
        assertThat(reply.isAccepted()).isTrue();
        assertThat(reply.getCreatedAt()).isNotNull();
    }
}
