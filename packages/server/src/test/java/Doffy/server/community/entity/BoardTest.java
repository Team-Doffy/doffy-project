package Doffy.server.community.entity;

import Doffy.server.user.entity.User;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTest {

    private Board board;

    @BeforeEach
    public void setUp() {
        // Given
        User user = User.builder()
                .userId(1L)
                .username("testUser")
                .nickname("nickname")
                .password("1234")
                .score(5)
                .terms(true)
                .build();

        System.out.println(user);

        BoardComment boardComment1 = BoardComment.builder()
                .boardCommentId(1L)
                .board(board)
                .boardCommentBody("comment 1")
                .build();

        BoardComment boardComment2 = BoardComment.builder()
                .boardCommentId(2L)
                .board(board)
                .boardCommentBody("comment 2")
                .build();

        Reply reply1 = Reply.builder()
                .replyId(1L)
                .board(board)
                .replyBody("reply 1")
                .build();

        Reply reply2 = Reply.builder()
                .replyId(2L)
                .board(board)
                .replyBody("reply 2")
                .build();

        List<BoardComment> boardComments = Arrays.asList(boardComment1, boardComment2);
        System.out.println(boardComments);

        List<Reply> replies = Arrays.asList(reply1, reply2);
        System.out.println(replies);

        // When
        board = Board.builder()
                .boardId(1L)
                .user(user)
                .title("Test Title")
                .boardBody("Test Board Body")
                .createdAt(LocalDateTime.now())
                .modifiedAt(LocalDateTime.now())
                .boardComments(boardComments)
                .replies(replies)
                .build();

        System.out.println(board);
    }


    @Test
    public void testBoardAttributes() {
        // Then
        assertEquals(1L, board.getBoardId());
        assertEquals("testUser", board.getUser().getUsername());
        assertEquals("Test Title", board.getTitle());
        assertEquals("Test Board Body", board.getBoardBody());
        assertEquals(2, board.getBoardComments().size());
        assertEquals(2, board.getReplies().size());
    }
}
