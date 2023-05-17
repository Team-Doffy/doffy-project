package Doffy.server.community.mapper;

import Doffy.server.community.dto.comment.ReplyCommentPostDto;
import Doffy.server.community.dto.comment.ReplyCommentResponseDto;
import Doffy.server.community.entity.ReplyComment;
import Doffy.server.community.service.ReplyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ReplyCommentMapper {

    private final ReplyService replyService;

    public ReplyComment toComment(ReplyCommentPostDto commentPostDto){
        return ReplyComment.builder()
                .replyCommentBody(commentPostDto.getReplyCommentBody())
                .reply(replyService.findReply(commentPostDto.getReplyId()))
                .build();
    }

    public ReplyCommentResponseDto toCommentResponseDto(ReplyComment replyComment){
        ReplyCommentResponseDto response = ReplyCommentResponseDto.builder()
                .replyCommentId(replyComment.getReplyCommentId())
                .userId(replyComment.getUser().getUserId())
                .nickname(replyComment.getUser().getNickname())
                .replyId(replyComment.getReply().getReplyId())
                .replyCommentBody(replyComment.getReplyCommentBody())
                .createdAt(replyComment.getCreatedAt())
                .modifiedAt(replyComment.getModifiedAt())
                .build();
        return response;
    }
}
