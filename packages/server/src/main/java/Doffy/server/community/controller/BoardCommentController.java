package Doffy.server.community.controller;

import Doffy.server.community.dto.comment.BoardCommentPostDto;
import Doffy.server.community.dto.comment.BoardCommentResponseDto;
import Doffy.server.community.entity.Board;
import Doffy.server.community.entity.BoardComment;
import Doffy.server.community.mapper.BoardCommentMapper;
import Doffy.server.community.service.BoardCommentService;
import Doffy.server.community.service.BoardService;
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
@RequestMapping("/api/v1/community/board-comments")
@Slf4j
@RequiredArgsConstructor
@Api(value = "Community Comment API")
public class BoardCommentController {
    private final BoardCommentService commentService;
    private final BoardCommentMapper boardCommentMapper;

    private final BoardService boardService;

    @ApiOperation(value = "Create a new comment", response = BoardCommentResponseDto.class)
    @PostMapping
    public ResponseEntity<BoardCommentResponseDto> createComment(
            @ApiParam(value = "Comment information", required = true) @RequestBody BoardCommentPostDto commentPostDto, Long boardId) {
        Board board = boardService.findBoard(boardId);
        BoardComment boardComment = commentService.createComment(commentPostDto, board);
        BoardCommentResponseDto response = boardCommentMapper.toCommentResponseDto(boardComment);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @ApiOperation(value = "Get a comment by ID", response = BoardCommentResponseDto.class)
    @GetMapping("/{commentId}")
    public ResponseEntity<BoardCommentResponseDto> getComment(
            @ApiParam(value = "Comment ID", required = true) @PathVariable long commentId) {
        BoardComment boardComment = commentService.findComment(commentId);
        BoardCommentResponseDto response = boardCommentMapper.toCommentResponseDto(boardComment);
        return ResponseEntity.ok(response);
    }

    @ApiOperation(value = "Update a comment by ID", response = BoardCommentResponseDto.class)
    @PutMapping("/{commentId}")
    public ResponseEntity<BoardCommentResponseDto> updateComment(
            @ApiParam(value = "Comment ID", required = true) @PathVariable long commentId,
            @ApiParam(value = "Comment information", required = true) @RequestBody BoardCommentPostDto commentPostDto) {
        BoardComment boardComment = commentService.updateComment(commentId, commentPostDto);
        BoardCommentResponseDto response = boardCommentMapper.toCommentResponseDto(boardComment);
        return ResponseEntity.ok(response);
    }

    @ApiOperation(value = "Delete a comment by ID")
    @DeleteMapping("/{commentId}")
    public ResponseEntity<Void> deleteComment(
            @ApiParam(value = "Comment ID", required = true) @PathVariable long commentId) {
        commentService.deleteComment(commentId);
        return ResponseEntity.noContent().build();
    }

    @ApiOperation(value = "Get all comments by board ID", response = List.class)
    @GetMapping("/board/{boardId}")
    public ResponseEntity<List<BoardCommentResponseDto>> getCommentsByBoard(
            @ApiParam(value = "Board ID", required = true) @PathVariable long boardId) {
        List<BoardCommentResponseDto> comments = commentService.findBoardComments(boardId);
        return ResponseEntity.ok(comments);
    }
}
