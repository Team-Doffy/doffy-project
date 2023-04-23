package Doffy.server.community.dto.board;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BoardPostDtoTest {
    @Test
    public void testBoardPostDtoSettings() {
        // Given
        BoardPostDto boardPostDto = new BoardPostDto();

        long userId = 1L;
        boardPostDto.setUserId(userId);
        assertThat(boardPostDto.getUserId()).isEqualTo(userId);

        Long boardId = 2L;
        boardPostDto.setBoardId(boardId);
        assertThat(boardPostDto.getBoardId()).isEqualTo(boardId);

        String title = "Test Title";
        boardPostDto.setTitle(title);
        assertThat(boardPostDto.getTitle()).isEqualTo(title);

        String boardBody = "Test Body";
        boardPostDto.setBoardBody(boardBody);
        assertThat(boardPostDto.getBoardBody()).isEqualTo(boardBody);
    }

}