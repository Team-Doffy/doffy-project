package Doffy.server.community.mapper;

import Doffy.server.community.dto.comment.CommentPostDto;
import Doffy.server.community.dto.comment.CommentResponseDto;
import Doffy.server.community.entity.Comment;
import org.springframework.stereotype.Component;

@Component
public class CommentMapper {
    public Comment toComment(CommentPostDto commentPostDto){
        return Comment.builder()
                .parentId(commentPostDto.getParentId())
                .commentType(Comment.getCommentTypeFromString(commentPostDto.getCommentType()))
                .commentBody(commentPostDto.getCommentBody())
                .build();
    }
    public CommentResponseDto toCommentResponseDto(Comment comment){
        CommentResponseDto response = CommentResponseDto.builder()
                .commentId(comment.getCommentId())
                .parentId(comment.getParentId())
                .commentType(comment.getCommentType().toString())
                .commentBody(comment.getCommentBody())
                .createdAt(comment.getCreatedAt())
                .build();
        return response;
    }
}
