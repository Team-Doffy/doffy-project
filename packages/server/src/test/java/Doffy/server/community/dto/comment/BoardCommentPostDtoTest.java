package Doffy.server.community.dto.comment;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class BoardCommentPostDtoTest {
    @Test
    public void testBoardCommentPostDto(){
        //given
        Long boardId = 1L;
        Long userId = 1L;
        String boardCommentBody = "Test Body";
        LocalDateTime createdAt = LocalDateTime.now();
        LocalDateTime modifiedAt = LocalDateTime.now();

        //when
        BoardCommentPostDto dto = BoardCommentPostDto.builder()
                .boardId(boardId)
                .userId(userId)
                .boardCommentBody(boardCommentBody)
                .createdAt(createdAt)
                .modifiedAt(modifiedAt)
                .build();

        //then
        assertEquals(boardId, dto.getBoardId());
        assertEquals(userId, dto.getUserId());
        assertEquals(boardCommentBody, dto.getBoardCommentBody());
        assertEquals(createdAt, dto.getCreatedAt());
        assertEquals(modifiedAt, dto.getModifiedAt());
    }

}