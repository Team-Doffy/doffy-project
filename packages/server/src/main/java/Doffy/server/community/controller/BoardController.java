package Doffy.server.community.controller;

import Doffy.server.community.dto.board.BoardDetailedResponseDto;
import Doffy.server.community.dto.board.BoardPostDto;
import Doffy.server.community.dto.board.BoardResponseDto;
import Doffy.server.community.entity.Board;
import Doffy.server.community.entity.Reply;
import Doffy.server.community.mapper.BoardMapper;
import Doffy.server.community.mapper.CommentMapper;
import Doffy.server.community.mapper.ReplyMapper;
import Doffy.server.community.service.BoardService;
import Doffy.server.user.entity.User;
import Doffy.server.user.service.UserService;
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
@RequestMapping("/api/v1/community/boards")
@Slf4j
@RequiredArgsConstructor
@Api(value = "Community Board API")
public class BoardController {
    private final BoardService boardService;
    private final BoardMapper boardMapper;
    private final CommentMapper commentMapper;
    private final ReplyMapper replyMapper;
    private final User user;
    private final UserService userService;

    @ApiOperation(value = "Create a new board", response = BoardResponseDto.class)
    @PostMapping
    public ResponseEntity<BoardResponseDto> createBoard(
            @ApiParam(value = "Board information", required = true) @RequestBody BoardPostDto boardPostDto) {
        Board board = boardService.createBoard(boardPostDto);
        BoardResponseDto response = boardMapper.toBoardResponseDto(board);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @ApiOperation(value = "Get all boards with pagination", response = List.class)
    @GetMapping
    public ResponseEntity<List<BoardResponseDto>> getAllBoards(
            @ApiParam(value = "Page number (0-based)", defaultValue = "0") @RequestParam(required = false, defaultValue = "0") int page,
            @ApiParam(value = "Number of items per page", defaultValue = "20") @RequestParam(required = false, defaultValue = "20") int size) {
        List<BoardResponseDto> boards = boardService.findAll(page, size);
        return ResponseEntity.ok(boards);
    }

    @ApiOperation(value = "Get a board by ID", response = BoardResponseDto.class)
    @GetMapping("/{boardId}")
    public ResponseEntity<BoardResponseDto> getBoard(
            @ApiParam(value = "Board ID", required = true) @PathVariable long boardId) {
        Board board = boardService.findBoard(boardId);
        BoardResponseDto response = boardMapper.toBoardResponseDto(board);
        return ResponseEntity.ok(response);
    }

    @ApiOperation(value = "Get a board with comments, replies, and reply comments by ID", response = BoardDetailedResponseDto.class)
    @GetMapping("/{boardId}/detailed")
    public ResponseEntity<BoardDetailedResponseDto> getBoardWithCommentsAndReplies(
            @ApiParam(value = "Board ID", required = true) @PathVariable long boardId) {
        Board board = boardService.findBoardWithCommentsAndReplies(boardId);
        BoardDetailedResponseDto response = boardMapper.toBoardDetailedResponseDtoWithCommentsAndReplies(board, commentMapper, replyMapper);
        return ResponseEntity.ok(response);
    }

//    @ApiOperation(value = "Get all boards by user ID or nickname", response = List.class)
//    @GetMapping("/user")
//    public ResponseEntity<List<BoardResponseDto>> getAllBoardsByUser(
//            @ApiParam(value = "User ID") @RequestParam(required = false) Long userId,
//            @ApiParam(value = "User nickname") @RequestParam(required = false) String nickname) {
//        List<BoardResponseDto> boards;
//        if (userId != null) {
//            User user = userService.findUser(userId);
//            boards = boardService.findBoardsByUser(user);
//        } else if (nickname != null) {
//            boards = boardService.findBoardsByUserNickname(nickname);
//        } else {
//            throw new IllegalArgumentException("Either user ID or nickname must be provided");
//        }
//        return ResponseEntity.ok(boards);
//    }

    @ApiOperation(value = "Update a board by ID", response = BoardResponseDto.class)
    @PutMapping("/{boardId}")
    public ResponseEntity<BoardResponseDto> updateBoard(
            @ApiParam(value = "Board ID", required = true) @PathVariable long boardId,
            @ApiParam(value = "Board information", required = true) @RequestBody BoardPostDto boardPostDto) {
        Board board = boardService.updateBoard(boardId, boardPostDto);
        BoardResponseDto response = boardMapper.toBoardResponseDto(board);
        return ResponseEntity.ok(response);
    }

    @ApiOperation(value = "Delete a board by ID")
    @DeleteMapping("/{boardId}")
    public ResponseEntity<Void> deleteBoard(
            @ApiParam(value = "Board ID", required = true) @PathVariable long boardId) {
        boardService.deleteBoard(boardId);
        return ResponseEntity.noContent().build();
    }
}
