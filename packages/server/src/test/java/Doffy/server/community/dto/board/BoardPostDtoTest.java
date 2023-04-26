package Doffy.server.community.dto.board;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BoardPostDtoTest {
    @Test
    public void testBoardPostDtoSettings() {
        // Given
        BoardPostDto boardPostDto = new BoardPostDto();

        String title = "Test Title";
        boardPostDto.setTitle(title);
        assertThat(boardPostDto.getTitle()).isEqualTo(title);

        String boardBody = "Test Body";
        boardPostDto.setBoardBody(boardBody);
        assertThat(boardPostDto.getBoardBody()).isEqualTo(boardBody);
    }

}