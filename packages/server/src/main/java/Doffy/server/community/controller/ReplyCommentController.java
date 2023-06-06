package Doffy.server.community.controller;

import Doffy.server.community.dto.comment.*;
import Doffy.server.community.entity.BoardComment;
import Doffy.server.community.entity.ReplyComment;
import Doffy.server.community.mapper.ReplyCommentMapper;
import Doffy.server.community.service.ReplyCommentService;
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
@RequestMapping("/api/v1/community/reply-comments")
@Slf4j
@RequiredArgsConstructor
@Api(value = "Community Comment API")
public class ReplyCommentController {
    private final ReplyCommentService commentService;
    private final ReplyCommentMapper replyCommentMapper;

    @ApiOperation(value = "Create a new comment", response = BoardCommentResponseDto.class)
    @PostMapping
    public ResponseEntity<ReplyCommentResponseDto> createComment(
            @ApiParam(value = "Comment information", required = true) @RequestBody ReplyCommentPostDto commentPostDto) {
        ReplyComment replyComment = commentService.createComment(commentPostDto);
        ReplyCommentResponseDto response = replyCommentMapper.toCommentResponseDto(replyComment);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @ApiOperation(value = "Get a comment by ID", response = ReplyCommentResponseDto.class)
    @GetMapping("/{commentId}")
    public ResponseEntity<ReplyCommentResponseDto> getComment(
            @ApiParam(value = "Comment ID", required = true) @PathVariable long commentId) {
        ReplyComment replyComment = commentService.findComment(commentId);
        ReplyCommentResponseDto response = replyCommentMapper.toCommentResponseDto(replyComment);
        return ResponseEntity.ok(response);
    }

    @ApiOperation(value = "Update a comment by ID", response = ReplyCommentResponseDto.class)
    @PutMapping("/{commentId}")
    public ResponseEntity<ReplyCommentResponseDto> updateComment(
            @ApiParam(value = "Comment ID", required = true) @PathVariable long commentId,
            @ApiParam(value = "Comment information", required = true) @RequestBody ReplyCommentUpdateDto commentUpdateDto) {
        ReplyComment replyComment = commentService.updateComment(commentId, commentUpdateDto);
        ReplyCommentResponseDto response = replyCommentMapper.toCommentResponseDto(replyComment);
        return ResponseEntity.ok(response);
    }

    @ApiOperation(value = "Delete a comment by ID")
    @DeleteMapping("/{commentId}")
    public ResponseEntity<Void> deleteComment(
            @ApiParam(value = "Comment ID", required = true) @PathVariable long commentId) {
        commentService.deleteComment(commentId);
        return ResponseEntity.noContent().build();
    }

    @ApiOperation(value = "Get all comments by reply ID", response = List.class)
    @GetMapping("/reply/{replyId}")
    public ResponseEntity<List<ReplyCommentResponseDto>> getComments(@PathVariable long replyId) {
        List<ReplyCommentResponseDto> comments = commentService.findReplyComments(replyId);
        return ResponseEntity.ok(comments);
    }
}

