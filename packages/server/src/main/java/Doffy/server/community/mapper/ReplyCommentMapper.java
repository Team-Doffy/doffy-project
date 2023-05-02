package Doffy.server.community.mapper;

import Doffy.server.community.dto.comment.ReplyCommentPostDto;
import Doffy.server.community.dto.comment.ReplyCommentResponseDto;
import Doffy.server.community.entity.Reply;
import Doffy.server.community.entity.ReplyComment;
import Doffy.server.user.entity.User;
import org.springframework.stereotype.Component;

@Component
public class ReplyCommentMapper {
    Reply reply = new Reply();
    User user = new User();

    public ReplyComment toComment(ReplyCommentPostDto commentPostDto){
        return ReplyComment.builder()
                .replyCommentId(commentPostDto.getReplyId())
                .replyCommentBody(commentPostDto.getReplyCommentBody())
                .reply(reply)
                .build();
    }

    public ReplyCommentResponseDto toCommentResponseDto(ReplyComment replyComment){
        ReplyCommentResponseDto response = ReplyCommentResponseDto.builder()
                .replyCommentId(replyComment.getReplyCommentId())
                .userId(user.getUserId())
                .nickname(user.getNickname())
                .replyId(reply.getReplyId())
                .replyCommentBody(replyComment.getReplyCommentBody())
                .createdAt(replyComment.getCreatedAt())
                .modifiedAt(replyComment.getModifiedAt())
                .build();
        return response;
    }
}
