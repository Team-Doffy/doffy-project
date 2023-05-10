package Doffy.server.community.dto.comment;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ReplyCommentResponseDtoTest {
    @Test
    public void testReplyCommentResponseDto() {
        //given
        Long replyCommentId = 1L;
        Long replyId = 1L;
        Long userId = 1L;
        String nickname = "Test Nickname";
        String replyCommentBody = "Test Body";
        LocalDateTime createdAt = LocalDateTime.now();
        LocalDateTime modifiedAt = LocalDateTime.now();

        //when
        ReplyCommentResponseDto dto = ReplyCommentResponseDto.builder()
                .replyCommentId(replyCommentId)
                .replyId(replyId)
                .userId(userId)
                .nickname(nickname)
                .replyCommentBody(replyCommentBody)
                .createdAt(createdAt)
                .modifiedAt(modifiedAt)
                .build();

        //then
        assertEquals(replyCommentId, dto.getReplyCommentId());
        assertEquals(replyId, dto.getReplyId());
        assertEquals(userId, dto.getUserId());
        assertEquals(nickname, dto.getNickname());
        assertEquals(replyCommentBody, dto.getReplyCommentBody());
        assertEquals(createdAt, dto.getCreatedAt());

    }
}