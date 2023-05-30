//package Doffy.server.community.mapper;
//
//import Doffy.server.community.dto.comment.ReplyCommentPostDto;
//import Doffy.server.community.dto.comment.ReplyCommentResponseDto;
//import Doffy.server.community.entity.Reply;
//import Doffy.server.community.entity.ReplyComment;
//import Doffy.server.community.service.ReplyService;
//import Doffy.server.user.entity.User;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.time.LocalDateTime;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.mockito.Mockito.*;
//
//@SpringBootTest
//public class ReplyCommentMapperTest {
//
//    @Autowired
//    private ReplyCommentMapper replyCommentMapper;
//
//    @Mock
//    private ReplyService replyService;
//
//    @BeforeEach
//    public void setup() {
//        MockitoAnnotations.initMocks(this);
//        replyCommentMapper = new ReplyCommentMapper(replyService);
//    }
//
//    @Test
//    public void testToComment() {
//        // given
//        long replyId = 1L;
//        Reply reply = Reply.builder()
//                .replyId(replyId)
//                .createdAt(LocalDateTime.now())
//                .modifiedAt(LocalDateTime.now())
//                .build();
//
//        ReplyCommentPostDto commentPostDto = ReplyCommentPostDto.builder()
//                .replyId(replyId)
//                .replyCommentBody("This is a test comment.")
//                .build();
//
//        when(replyService.findReply(replyId)).thenReturn(reply);
//
//        // when
//        ReplyComment comment = replyCommentMapper.toComment(commentPostDto);
//
//        // then
//        assertNotNull(comment);
//        assertEquals(commentPostDto.getReplyCommentBody(), comment.getReplyCommentBody());
//        assertEquals(reply, comment.getReply());
//
//        verify(replyService, times(1)).findReply(replyId);
//    }
//
//    @Test
//    public void testToCommentResponseDto() {
//        // given
//        User user = User.builder()
//                .userId(1L)
//                .username("TEST")
//                .build();
//
//        ReplyComment comment = ReplyComment.builder()
//                .replyCommentId(1L)
//                .replyCommentBody("This is a test comment.")
//                .user(user)
//                .createdAt(LocalDateTime.now())
//                .modifiedAt(LocalDateTime.now())
//                .build();
//
//        Reply reply = Reply.builder()
//                .replyId(1L)
//                .createdAt(LocalDateTime.now())
//                .modifiedAt(LocalDateTime.now())
//                .build();
//
//        comment.setReply(reply);
//
//        // when
//        ReplyCommentResponseDto responseDto = replyCommentMapper.toCommentResponseDto(comment);
//
//        // then
//        assertNotNull(responseDto);
//        assertEquals(comment.getReplyCommentId(), responseDto.getReplyCommentId());
//        assertEquals(reply.getReplyId(), responseDto.getReplyId());
//        assertEquals(comment.getReplyCommentBody(), responseDto.getReplyCommentBody());
//        assertEquals(comment.getCreatedAt(), responseDto.getCreatedAt());
//        assertEquals(comment.getModifiedAt(), responseDto.getModifiedAt());
//    }
//}
