package Doffy.server.community.entity;

import Doffy.server.user.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BoardCommentTest {
    private Board board;
    private BoardComment boardComment1;
    private BoardComment boardComment2;

    //given
    @BeforeEach
    public void setUp() {
        User user = User.builder()
                .userId(1L)
                .nickname("nickname")
                .name("name")
                .build();

        board = Board.builder()
                .boardId(1L)
                .title("title")
                .boardBody("body")
                .user(user)
                .build();


        //when
        boardComment1 = BoardComment.builder()
                .boardCommentId(1L)
                .board(board)
                .boardCommentBody("test 1")
                .createdAt(LocalDateTime.now())
                .modifiedAt(LocalDateTime.now())
                .build();

        boardComment2 = BoardComment.builder()
                .boardCommentId(2L)
                .board(board)
                .boardCommentBody("test 2")
                .createdAt(LocalDateTime.now())
                .modifiedAt(LocalDateTime.now())
                .build();

        List<BoardComment> comments = Arrays.asList(boardComment1, boardComment2);
        System.out.println(comments);

        board.setBoardComments(comments);
        System.out.println(board);
    }

    @Test
    public void testCommentAttributes(){
        //then
        assertEquals(1L, boardComment1.getBoardCommentId());
        assertEquals(2L, boardComment2.getBoardCommentId());
        assertEquals(2, board.getBoardComments().size());
        assertEquals("test 1", boardComment1.getBoardCommentBody());
        assertEquals(board, boardComment1.getBoard());
    }
}