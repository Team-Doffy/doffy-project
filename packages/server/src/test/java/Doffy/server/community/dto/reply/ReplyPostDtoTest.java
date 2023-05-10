package Doffy.server.community.dto.reply;

import Doffy.server.community.dto.comment.ReplyCommentResponseDto;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ReplyPostDtoTest {
    @Test
    public void testReplyPostDto() {
        //given
        Long boardId = 1L;
        Long userId = 1L;
        String replyBody = "Test Body";
        LocalDateTime createdAt = LocalDateTime.now();
        LocalDateTime modifiedAt = LocalDateTime.now();

        //when
        ReplyPostDto dto = ReplyPostDto.builder()
                .boardId(boardId)
                .userId(userId)
                .replyBody(replyBody)
                .createdAt(createdAt)
                .modifiedAt(modifiedAt)
                .build();

        //then
        assertEquals(boardId, dto.getBoardId());
        assertEquals(userId, dto.getUserId());
        assertEquals(replyBody, dto.getReplyBody());
        assertEquals(createdAt, dto.getCreatedAt());
        assertEquals(modifiedAt, dto.getModifiedAt());

    }

}