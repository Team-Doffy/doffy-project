package Doffy.server.community.dto.board;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardPostDtoTest {
    @Test
    public void testBoardPostDto(){
        //given
        Long userId = 1L;
        String title = "test Title";
        String boardBody = "test Body";

        //when
        BoardPostDto boardPostDto = BoardPostDto.builder()
                .userId(userId)
                .title(title)
                .boardBody(boardBody)
                .build();

        //then
        assertEquals(1L, boardPostDto.getUserId());
        assertEquals("test Title", boardPostDto.getTitle());
        assertEquals("test Body", boardPostDto.getBoardBody());
    }
}