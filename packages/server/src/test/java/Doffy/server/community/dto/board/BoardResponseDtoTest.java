package Doffy.server.community.dto.board;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class BoardResponseDtoTest {
    @Test
    public void testBoardResponseDto(){
        //given
        Long userId = 1L;
        String nickName = "test Nickname";
        Long boardId = 1L;
        String title = "test Title";
        LocalDateTime createdAt = LocalDateTime.now();
        LocalDateTime modifiedAt = LocalDateTime.now();
        int likeCount = 10;
        int replyCount = 5;

        //when
        BoardResponseDto dto = BoardResponseDto.builder()
//                .userId(userId)
//                .nickname(nickName)
                .boardId(boardId)
                .title(title)
                .createdAt(createdAt)
                .modifiedAt(modifiedAt)
                .likeCount(likeCount)
                .replyCount(replyCount)
                .build();

        //then
        assertEquals(boardId, dto.getBoardId());
//        assertEquals(userId, dto.getUserId());
//        assertEquals(nickName, dto.getNickname());
        assertEquals(title, dto.getTitle());
        assertEquals(createdAt, dto.getCreatedAt());
        assertEquals(modifiedAt, dto.getModifiedAt());
        assertEquals(likeCount, dto.getLikeCount());
        assertEquals(replyCount, dto.getReplyCount());
    }

}