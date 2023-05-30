//package Doffy.server.community.mapper;
//
//import Doffy.server.community.dto.comment.BoardCommentResponseDto;
//import Doffy.server.community.dto.reply.ReplyPostDto;
//import Doffy.server.community.dto.reply.ReplyResponseDto;
//import Doffy.server.community.entity.Board;
//import Doffy.server.community.entity.Reply;
//import Doffy.server.user.entity.User;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.time.LocalDateTime;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//@SpringBootTest
//public class ReplyMapperTest {
//
//    @Autowired
//    private ReplyMapper replyMapper;
//
//    @Test
//    public void testToReply() {
//        // given
//        Board board = Board.builder()
//                .boardId(1L)
//                .title("Test Board")
//                .boardBody("This is a test board.")
//                .createdAt(LocalDateTime.now())
//                .modifiedAt(LocalDateTime.now())
//                .build();
//        ReplyPostDto replyPostDto = ReplyPostDto.builder()
//                .replyBody("This is a test reply.")
//                .build();
//
//        // when
//        Reply reply = replyMapper.toReply(replyPostDto, board);
//
//        // then
//        assertNotNull(reply);
//        assertEquals(board, reply.getBoard());
//        assertEquals(replyPostDto.getReplyBody(), reply.getReplyBody());
//    }
//
//    @Test
//    public void testToReplyResponseDto() {
//        // given
//        User user = User.builder()
//                .userId(1L)
//                .username("testName")
//                .build();
//
//        Reply reply = Reply.builder()
//                .replyId(1L)
//                .replyBody("This is a test reply.")
//                .user(user)
//                .isAccepted(false)
//                .createdAt(LocalDateTime.now())
//                .modifiedAt(LocalDateTime.now())
//                .build();
//
//        // when
//        ReplyResponseDto replyResponseDto = replyMapper.toReplyResponseDto(reply);
//
//        // then
//        assertNotNull(replyResponseDto);
//        assertEquals(reply.getReplyId(), replyResponseDto.getReplyId());
//        assertEquals(reply.getUser().getUserId(), replyResponseDto.getUserId());
//        assertEquals(reply.getUser().getNickname(), replyResponseDto.getNickname());
//        assertEquals(reply.getReplyBody(), replyResponseDto.getReplyBody());
//        assertEquals(reply.isAccepted(), replyResponseDto.isAccepted());
//        assertEquals(reply.getCreatedAt(), replyResponseDto.getCreatedAt());
//        assertEquals(reply.getModifiedAt(), replyResponseDto.getModifiedAt());
//    }
//}
