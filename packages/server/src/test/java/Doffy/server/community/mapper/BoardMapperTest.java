package Doffy.server.community.mapper;

import Doffy.server.community.dto.board.BoardDetailedResponseDto;
import Doffy.server.community.entity.Board;
import Doffy.server.community.entity.Comment;
import Doffy.server.community.entity.Reply;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class BoardMapperTest {

    @Autowired
    private BoardMapper boardMapper;

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private ReplyMapper replyMapper;

    @Test
    public void toBoardDetailedResponseDtoTest() {
        // Given
        Board board = Board.builder()
                .boardId(1L)
                .title("Test title")
                .boardBody("Test board body")
                .createdAt(LocalDateTime.now())
                .modifiedAt(LocalDateTime.now())
                .build();

        List<Comment> comments = new ArrayList<>();
        comments.add(Comment.builder().commentId(1L).commentBody("Test comment 1").createdAt(LocalDateTime.now()).build());
        comments.add(Comment.builder().commentId(2L).commentBody("Test comment 2").createdAt(LocalDateTime.now()).build());
        board.setComments(comments);

        List<Reply> replies = new ArrayList<>();
        Reply reply = Reply.builder().replyId(1L).replyBody("Test reply").createdAt(LocalDateTime.now()).build();
        reply.setComments(comments);
        replies.add(reply);
        board.setReplies(replies);

        // When
        BoardDetailedResponseDto response = boardMapper.toBoardDetailedResponseDtoWithCommentsAndReplies(board, commentMapper, replyMapper);

        // Then
        assertEquals(board.getBoardId(), response.getBoardId());
        assertEquals(board.getTitle(), response.getTitle());
        assertEquals(board.getBoardBody(), response.getBoardBody());
        assertEquals(board.getCreatedAt(), response.getCreatedAt());
        assertEquals(board.getModifiedAt(), response.getModifiedAt());
        assertEquals(comments.size(), response.getComments().size());
        assertEquals(replies.size(), response.getReplies().size());
    }
}
