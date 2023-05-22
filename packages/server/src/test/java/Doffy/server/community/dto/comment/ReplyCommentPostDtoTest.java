package Doffy.server.community.dto.comment;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReplyCommentPostDtoTest {
    @Test
    public  void testReplyCommentPostDto(){
        //given
        Long replyId = 1L;
        Long userId = 1L;
        String replyCommentBody = "Test Body";

        //when
        ReplyCommentPostDto dto = ReplyCommentPostDto.builder()
                .replyId(replyId)
                .userId(userId)
                .replyCommentBody(replyCommentBody)
                .build();

        //then
        assertEquals(replyId, dto.getReplyId());
        assertEquals(userId, dto.getUserId());
        assertEquals(replyCommentBody, dto.getReplyCommentBody());
    }

}