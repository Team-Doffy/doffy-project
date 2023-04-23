package Doffy.server.community.controller;

import Doffy.server.community.dto.board.BoardPostDto;
import Doffy.server.community.dto.board.BoardResponseDto;
import Doffy.server.community.entity.Board;
import Doffy.server.community.mapper.BoardMapper;
import Doffy.server.community.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("/api/v1/community")
@Slf4j
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;
    private final BoardMapper boardMapper;

    @PostMapping
    public ResponseEntity<BoardResponseDto> createBoard(@RequestBody BoardPostDto boardPostDto) {
        Board board = boardService.createBoard(boardPostDto);
        BoardResponseDto response = boardMapper.toBoardResponseDto(board);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
