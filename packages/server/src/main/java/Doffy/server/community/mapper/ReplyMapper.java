package Doffy.server.community.mapper;

import Doffy.server.community.dto.comment.CommentPostDto;
import Doffy.server.community.dto.comment.CommentResponseDto;
import Doffy.server.community.dto.reply.ReplyPostDto;
import Doffy.server.community.dto.reply.ReplyResponseDto;
import Doffy.server.community.entity.Board;
import Doffy.server.community.entity.Comment;
import Doffy.server.community.entity.Reply;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ReplyMapper {
    public Reply toReply(ReplyPostDto replyPostDto, Board board){
        return Reply.builder()
                .board(board)
                .replyBody(replyPostDto.getReplyBody())
                .build();
    }
    public ReplyResponseDto toReplyResponseDto(Reply reply, List<CommentResponseDto> comments){
        ReplyResponseDto response = ReplyResponseDto.builder()
                .replyId(reply.getReplyId())
                .userId(reply.getUser().getUserId())
                .nickname(reply.getUser().getNickname())
                .replyBody(reply.getReplyBody())
                .isAccepted(reply.isAccepted())
                .createdAt(reply.getCreatedAt())
                .modifiedAt(reply.getModifiedAt())
                .replyComments(comments)
                .build();
        return response;
    }
}
