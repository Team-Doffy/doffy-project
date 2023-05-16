package Doffy.server.community.dto.board;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class BoardDetailedResponseDtoTest {
    @Test
    public void testBoardDetailedResponseDto() {
        // given
        Long boardId = 1L;
        Long userId = 1L;
        String nickname = "testUser";
        String title = "Test Title";
        String boardBody = "Test Board Body";
        LocalDateTime createdAt = LocalDateTime.now();
        LocalDateTime modifiedAt = LocalDateTime.now();

        // when
        BoardDetailedResponseDto dto = BoardDetailedResponseDto.builder()
                .boardId(boardId)
//                .userId(userId)
//                .nickname(nickname)
                .title(title)
                .boardBody(boardBody)
                .createdAt(createdAt)
                .modifiedAt(modifiedAt)
                .build();

        // then
        assertEquals(boardId, dto.getBoardId());
//        assertEquals(userId, dto.getUserId());
//        assertEquals(nickname, dto.getNickname());
        assertEquals(title, dto.getTitle());
        assertEquals(boardBody, dto.getBoardBody());
        assertEquals(createdAt, dto.getCreatedAt());
        assertEquals(modifiedAt, dto.getModifiedAt());
    }
}

