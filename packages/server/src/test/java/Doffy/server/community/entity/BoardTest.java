package Doffy.server.community.entity;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BoardTest {

    @Test
    public void testGettersAndSetters() {
        // given
        Board board = new Board();
        int boardId = 1;
        String title = "Test Title";
        String boardBody = "Test Body";
        int boardLikes = 100;

        // when
        board.setBoardId(boardId);
        board.setTitle(title);
        board.setBoardBody(boardBody);

        // then
        assertThat(board.getBoardId()).isEqualTo(boardId);
        assertThat(board.getTitle()).isEqualTo(title);
        assertThat(board.getBoardBody()).isEqualTo(boardBody);
    }

}

