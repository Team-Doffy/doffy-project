package Doffy.server.community.mapper;

import Doffy.server.community.dto.comment.ReplyCommentPostDto;
import Doffy.server.community.dto.comment.ReplyCommentResponseDto;
import Doffy.server.community.entity.ReplyComment;
import Doffy.server.community.repository.BoardRepository;
import Doffy.server.community.service.BoardService;
import Doffy.server.community.service.ReplyService;
import Doffy.server.user.entity.User;
import Doffy.server.user.repository.UserRepository;
import Doffy.server.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ReplyCommentMapper {

    private final UserRepository userRepository;
    private final ReplyService replyService;

    public ReplyComment toComment(ReplyCommentPostDto commentPostDto){
        User user = userRepository.findByUserId(commentPostDto.getUserId());
        return ReplyComment.builder()
                .user(user)
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
