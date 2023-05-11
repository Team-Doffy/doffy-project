package Doffy.server.community.mapper;

import Doffy.server.community.dto.comment.ReplyCommentPostDto;
import Doffy.server.community.dto.comment.ReplyCommentResponseDto;
import Doffy.server.community.entity.Reply;
import Doffy.server.community.entity.ReplyComment;
import Doffy.server.user.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ReplyCommentMapperTest {

    @Autowired
    private ReplyCommentMapper replyCommentMapper;

    @Test
    public void testToComment() {
        // given
        ReplyCommentPostDto commentPostDto = ReplyCommentPostDto.builder()
                .replyId(1L)
                .replyCommentBody("This is a test comment.")
                .build();

        Reply reply = Reply.builder()
                .replyId(1L)
                .createdAt(LocalDateTime.now())
                .modifiedAt(LocalDateTime.now())
                .build();

        // when
        ReplyComment comment = replyCommentMapper.toComment(commentPostDto);
        comment.setReply(reply);

        // then
        assertNotNull(comment);
        assertEquals(commentPostDto.getReplyCommentBody(), comment.getReplyCommentBody());
        assertEquals(reply, comment.getReply());
    }

    @Test
    public void testToCommentResponseDto() {
        // given
        ReplyComment comment = ReplyComment.builder()
                .replyCommentId(1L)
                .replyCommentBody("This is a test comment.")
                .createdAt(LocalDateTime.now())
                .modifiedAt(LocalDateTime.now())
                .build();

        Reply reply = Reply.builder()
                .replyId(1L)
                .createdAt(LocalDateTime.now())
                .modifiedAt(LocalDateTime.now())
                .build();

        comment.setReply(reply);

        // when
        ReplyCommentResponseDto responseDto = replyCommentMapper.toCommentResponseDto(comment);

        // then
        assertNotNull(responseDto);
        assertEquals(comment.getReplyCommentId(), responseDto.getReplyCommentId());
        assertEquals(reply.getReplyId(), responseDto.getReplyId());
        assertEquals(comment.getReplyCommentBody(), responseDto.getReplyCommentBody());
        assertEquals(comment.getCreatedAt(), responseDto.getCreatedAt());
        assertEquals(comment.getModifiedAt(), responseDto.getModifiedAt());
    }
}
