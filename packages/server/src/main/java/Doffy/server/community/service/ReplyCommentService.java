package Doffy.server.community.service;

import Doffy.server.community.dto.comment.ReplyCommentPostDto;
import Doffy.server.community.dto.comment.ReplyCommentResponseDto;
import Doffy.server.community.dto.comment.ReplyCommentUpdateDto;
import Doffy.server.community.entity.Reply;
import Doffy.server.community.entity.ReplyComment;
import Doffy.server.community.mapper.ReplyCommentMapper;
import Doffy.server.community.repository.ReplyCommentRepository;
import Doffy.server.global.exception.BusinessLogicException;
import Doffy.server.global.exception.ExceptionCode;
import Doffy.server.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReplyCommentService {
    private final ReplyCommentRepository replyCommentRepository;
    private final ReplyCommentMapper replyCommentMapper;
    private final ReplyService replyService;
    private final UserRepository userRepository;

    public ReplyComment createComment(ReplyCommentPostDto commentPostDto){
        ReplyComment replyComment = replyCommentMapper.toComment(commentPostDto);
        return replyCommentRepository.save(replyComment);
    }

    public ReplyComment updateComment(long commentId, ReplyCommentUpdateDto replyCommentUpdateDto){
        ReplyComment replyComment = findVerifiedComment(commentId);
        replyComment.setReplyCommentBody(replyCommentUpdateDto.getReplyCommentBody());
        return replyCommentRepository.save(replyComment);
    }

    public void  deleteComment(long commentId){
        ReplyComment replyComment = findVerifiedComment(commentId);
        replyCommentRepository.delete(replyComment);
    }

    public List<ReplyCommentResponseDto> findReplyComments(long replyId){
        Reply verifiedReply = replyService.findReply(replyId);
        List<ReplyComment> replyComments = replyCommentRepository.findAllByReply(verifiedReply);
        return replyComments.stream()
                .map(replyCommentMapper::toCommentResponseDto)
                .collect(Collectors.toList());
    }

    public ReplyComment findComment(long commentId){
        return findVerifiedComment(commentId);
    }

    public ReplyComment findVerifiedComment(long commentId){
        return replyCommentRepository.findById(commentId)
                .orElseThrow(()-> new BusinessLogicException(ExceptionCode.COMMENT_NOT_FOUND));
    }
}
