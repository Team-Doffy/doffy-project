package Doffy.server.community.dto.comment;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class BoardCommentResponseDtoTest {
    @Test
    public void testBoardCommentResponseDto(){
        //given
        Long boardCommentId = 1L;
        Long boardId = 1L;
        Long userId = 1L;
        String nickname = "Test Nickname";
        String boardCommentBody = "Test Body";
        LocalDateTime createdAt = LocalDateTime.now();
        LocalDateTime modifiedAt = LocalDateTime.now();

        //when
        BoardCommentResponseDto dto = BoardCommentResponseDto.builder()
                .boardCommentId(boardCommentId)
                .boardId(boardId)
                .boardCommentBody(boardCommentBody)
                .nickname(nickname)
                .userId(userId)
                .createdAt(createdAt)
                .modifiedAt(modifiedAt)
                .build();

        //then
        assertEquals(boardCommentId, dto.getBoardCommentId());
        assertEquals(boardId, dto.getBoardId());
        assertEquals(userId, dto.getUserId());
        assertEquals(nickname, dto.getNickname());
        assertEquals(boardCommentBody, dto.getBoardCommentBody());
        assertEquals(createdAt, dto.getCreatedAt());
        assertEquals(modifiedAt, dto.getModifiedAt());
    }

}