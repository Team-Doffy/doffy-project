package Doffy.server.community.dto.reply;

import Doffy.server.community.dto.comment.ReplyCommentResponseDto;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ReplyResponseDtoTest {
    @Test
    public void testReplyResponseDto() {
        //given
        Long replyId = 1L;
        Long userId = 1L;
        String nickname = "Test Nickname";
        String replyBody = "Test Body";
        Boolean isAccepted = true;
        LocalDateTime createdAt = LocalDateTime.now();
        LocalDateTime modifiedAt = LocalDateTime.now();

        //when
        ReplyResponseDto dto = ReplyResponseDto.builder()
                .replyId(replyId)
                .userId(userId)
                .nickname(nickname)
                .replyBody(replyBody)
                .isAccepted(isAccepted)
                .createdAt(createdAt)
                .modifiedAt(modifiedAt)
                .build();

        //then
        assertEquals(replyId, dto.getReplyId());
        assertEquals(userId, dto.getUserId());
        assertEquals(nickname, dto.getNickname());
        assertEquals(replyBody, dto.getReplyBody());
        assertEquals(isAccepted, dto.getIsAccepted());
        assertEquals(createdAt, dto.getCreatedAt());
        assertEquals(modifiedAt, dto.getModifiedAt());

    }

}