package Doffy.server.community.mapper;

import Doffy.server.community.dto.comment.BoardCommentResponseDto;
import Doffy.server.community.dto.reply.ReplyPostDto;
import Doffy.server.community.dto.reply.ReplyResponseDto;
import Doffy.server.community.entity.Board;
import Doffy.server.community.entity.Reply;
import Doffy.server.user.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ReplyMapper {
    public Reply toReply(ReplyPostDto replyPostDto, Board board, User user){
        return Reply.builder()
                .user(user)
                .board(board)
                .replyBody(replyPostDto.getReplyBody())
                .isAccepted(false)
                .build();
    }

    public ReplyResponseDto toReplyResponseDto(Reply reply){
        Long userId = reply.getUser() != null ? reply.getUser().getUserId() : null;
        String nickname = reply.getUser() != null ? reply.getUser().getNickname() : null;

        ReplyResponseDto response = ReplyResponseDto.builder()
                .replyId(reply.getReplyId())
                .userId(userId)
                .nickname(nickname)
                .replyBody(reply.getReplyBody())
                .isAccepted(reply.isAccepted())
                .createdAt(reply.getCreatedAt())
                .modifiedAt(reply.getModifiedAt())
                .build();
        return response;
    }
}
