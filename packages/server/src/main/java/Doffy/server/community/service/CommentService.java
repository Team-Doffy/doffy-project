package Doffy.server.community.service;

import Doffy.server.community.dto.comment.CommentPostDto;
import Doffy.server.community.dto.comment.CommentResponseDto;
import Doffy.server.community.entity.Comment;
import Doffy.server.community.mapper.CommentMapper;
import Doffy.server.community.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import Doffy.server.global.exception.BusinessLogicException;
import Doffy.server.global.exception.ExceptionCode;


import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;

    public Comment createComment(CommentPostDto commentPostDto) {
        Comment comment = commentMapper.toComment(commentPostDto);
        return commentRepository.save(comment);
    }

    public Comment updateComment(long commentId, CommentPostDto commentPostDto) {
        Comment comment = findVerifiedComment(commentId);
        comment.setCommentBody(commentPostDto.getCommentBody());
        return commentRepository.save(comment);
    }

    public void deleteComment(long commentId) {
        Comment comment = findVerifiedComment(commentId);
        commentRepository.delete(comment);
    }

//    public List<CommentResponseDto> findBoardComments(long boardId) {
//        List<Comment> comments = commentRepository.findByBoardIdAndCommentType(boardId, Comment.CommentType.BOARD);
//        List<CommentResponseDto> responseDtos = comments.stream()
//                .map(commentMapper::toCommentResponseDto)
//                .collect(Collectors.toList());
//        return responseDtos;
//    }
//
//    public List<CommentResponseDto> findReplyComments(long replyId) {
//        List<Comment> comments = commentRepository.findByBoardIdAndCommentType(replyId, Comment.CommentType.REPLY);
//        List<CommentResponseDto> responseDtos = comments.stream()
//                .map(commentMapper::toCommentResponseDto)
//                .collect(Collectors.toList());
//        return responseDtos;
//    }

    public Comment findComment(long commentId) {
        return findVerifiedComment(commentId);
    }

    public Comment findVerifiedComment(long commentId) {
        return commentRepository.findById(commentId)
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.COMMENT_NOT_FOUND));
    }
}


