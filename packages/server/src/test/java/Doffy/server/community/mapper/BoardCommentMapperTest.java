//package Doffy.server.community.mapper;
//
//import Doffy.server.community.dto.comment.BoardCommentPostDto;
//import Doffy.server.community.dto.comment.BoardCommentResponseDto;
//import Doffy.server.community.entity.Board;
//import Doffy.server.community.entity.BoardComment;
//import Doffy.server.user.entity.User;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.time.LocalDateTime;
//
//@SpringBootTest
//public class BoardCommentMapperTest {
//
//    @Autowired
//    private BoardCommentMapper boardCommentMapper;
//
//    @Test
//    public void testToComment() {
//        // given
//        BoardCommentPostDto commentPostDto = BoardCommentPostDto.builder()
//                .boardId(1L)
//                .boardCommentBody("This is a test comment.")
//                .build();
//
//        Board board = Board.builder()
//                .boardId(1L)
//                .title("Test Board")
//                .boardBody("This is a test board.")
//                .createdAt(LocalDateTime.now())
//                .modifiedAt(LocalDateTime.now())
//                .build();
//
//        // when
//        BoardComment comment = boardCommentMapper.toComment(commentPostDto, board);
//        comment.setBoard(board);
//
//        // then
//        Assertions.assertNotNull(comment);
//        Assertions.assertEquals(commentPostDto.getBoardCommentBody(), comment.getBoardCommentBody());
//        Assertions.assertEquals(board, comment.getBoard());
//    }
//
//    @Test
//    public void testToCommentResponseDto() {
//        // given
//        BoardComment comment = BoardComment.builder()
//                .boardCommentId(1L)
//                .boardCommentBody("This is a test comment.")
//                .createdAt(LocalDateTime.now())
//                .modifiedAt(LocalDateTime.now())
//                .build();
//
//        Board board = Board.builder()
//                .boardId(1L)
//                .title("Test Board")
//                .boardBody("This is a test board.")
//                .createdAt(LocalDateTime.now())
//                .modifiedAt(LocalDateTime.now())
//                .build();
//
//        User user = User.builder()
//                .userId(1L)
//                .nickname("Test User")
//                .build();
//
//        comment.setBoard(board);
//        comment.setUser(user);
//
//        // when
//        BoardCommentResponseDto responseDto = boardCommentMapper.toCommentResponseDto(comment);
//
//        // then
//        Assertions.assertNotNull(responseDto);
//        Assertions.assertEquals(comment.getBoardCommentId(), responseDto.getBoardCommentId());
//        Assertions.assertEquals(board.getBoardId(), responseDto.getBoardId());
//        Assertions.assertEquals(comment.getBoardCommentBody(), responseDto.getBoardCommentBody());
//        Assertions.assertEquals(comment.getCreatedAt(), responseDto.getCreatedAt());
//        Assertions.assertEquals(comment.getModifiedAt(), responseDto.getModifiedAt());
//    }
//}
