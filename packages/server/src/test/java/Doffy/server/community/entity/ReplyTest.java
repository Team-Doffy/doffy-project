package Doffy.server.community.entity;

import Doffy.server.user.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReplyTest {
    private Reply reply;

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

        Board board = Board.builder()
                .boardId(23L)
                .user(user)
                .title("title")
                .boardBody("body")
                .build();

        ReplyComment replyComment1 = ReplyComment.builder()
                .replyCommentId(1L)
                .reply(reply)
                .replyCommentBody("comment 1")
                .build();

        ReplyComment replyComment2 = ReplyComment.builder()
                .replyCommentId(2L)
                .reply(reply)
                .replyCommentBody("comment 2")
                .build();

        reply = Reply.builder()
                .replyId(1L)
                .board(board)
                .replyBody("reply")
                .build();

        Reply reply2 = Reply.builder()
                .replyId(2L)
                .board(board)
                .replyBody("reply 2")
                .build();

        List<ReplyComment> replyComments = Arrays.asList(replyComment1, replyComment2);
        System.out.println(replyComments);

        List<Reply> replies = Arrays.asList(reply, reply2);
        System.out.println(replies);

        // When
        board.setReplies(replies);
        reply.setReplyComments(replyComments);

        System.out.println(board);
        System.out.println(reply);
    }


    @Test
    public void testReplyAttributes() {
        // Then
        assertEquals(1L, reply.getReplyId());
        assertEquals(2, reply.getReplyComments().size());
        assertEquals(23L, reply.getBoard().getBoardId());
        assertEquals(1L, reply.getBoard().getUser().getUserId());
    }

}