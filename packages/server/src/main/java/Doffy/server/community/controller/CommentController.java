package Doffy.server.community.controller;

import Doffy.server.community.dto.comment.CommentPostDto;
import Doffy.server.community.dto.comment.CommentResponseDto;
import Doffy.server.community.entity.Comment;
import Doffy.server.community.mapper.CommentMapper;
import Doffy.server.community.service.CommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/api/v1/community/comments")
@Slf4j
@RequiredArgsConstructor
@Api(value = "Community Comment API")
public class CommentController {
    private final CommentService commentService;
    private final CommentMapper commentMapper;

    @ApiOperation(value = "Create a new comment", response = CommentResponseDto.class)
    @PostMapping
    public ResponseEntity<CommentResponseDto> createComment(
            @ApiParam(value = "Comment information", required = true) @RequestBody CommentPostDto commentPostDto) {
        Comment comment = commentService.createComment(commentPostDto);
        CommentResponseDto response = commentMapper.toCommentResponseDto(comment);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @ApiOperation(value = "Get a comment by ID", response = CommentResponseDto.class)
    @GetMapping("/{commentId}")
    public ResponseEntity<CommentResponseDto> getComment(
            @ApiParam(value = "Comment ID", required = true) @PathVariable long commentId) {
        Comment comment = commentService.findComment(commentId);
        CommentResponseDto response = commentMapper.toCommentResponseDto(comment);
        return ResponseEntity.ok(response);
    }

    @ApiOperation(value = "Update a comment by ID", response = CommentResponseDto.class)
    @PutMapping("/{commentId}")
    public ResponseEntity<CommentResponseDto> updateComment(
            @ApiParam(value = "Comment ID", required = true) @PathVariable long commentId,
            @ApiParam(value = "Comment information", required = true) @RequestBody CommentPostDto commentPostDto) {
        Comment comment = commentService.updateComment(commentId, commentPostDto);
        CommentResponseDto response = commentMapper.toCommentResponseDto(comment);
        return ResponseEntity.ok(response);
    }

    @ApiOperation(value = "Delete a comment by ID")
    @DeleteMapping("/{commentId}")
    public ResponseEntity<Void> deleteComment(
            @ApiParam(value = "Comment ID", required = true) @PathVariable long commentId) {
        commentService.deleteComment(commentId);
        return ResponseEntity.noContent().build();
    }

//    @ApiOperation(value = "Get all comments by board ID", response = List.class)
//    @GetMapping("/board/{boardId}")
//    public ResponseEntity<List<CommentResponseDto>> getCommentsByBoard(
//            @ApiParam(value = "Board ID", required = true) @PathVariable long boardId) {
//        List<CommentResponseDto> comments = commentService.findBoardComments(boardId);
//        return ResponseEntity.ok(comments);
//    }
//
//    @ApiOperation(value = "Get all comments by reply ID", response = List.class)
//    @GetMapping("/reply/{replyId}")
//    public ResponseEntity<List<CommentResponseDto>> getCommentsByReply(
//            @ApiParam(value = "Reply ID", required = true) @PathVariable long replyId) {
//        List<CommentResponseDto> comments = commentService.findReplyComments(replyId);
//        return ResponseEntity.ok(comments);
//    }
}
