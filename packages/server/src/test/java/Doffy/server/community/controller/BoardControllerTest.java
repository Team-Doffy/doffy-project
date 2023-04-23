package Doffy.server.community.controller;

import Doffy.server.community.dto.board.BoardPostDto;
import Doffy.server.community.dto.board.BoardResponseDto;
import Doffy.server.community.entity.Board;
import Doffy.server.community.mapper.BoardMapper;
import Doffy.server.community.service.BoardService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BoardControllerTest {

    @InjectMocks
    private BoardController boardController;

    @Mock
    private BoardService boardService;

    @Mock
    private BoardMapper boardMapper;

    private BoardPostDto boardPostDto;
    private Board board;
    private BoardResponseDto boardResponseDto;

    @BeforeEach
    public void setUp() {
        boardPostDto = BoardPostDto.builder()
                .title("Test Board")
                .boardBody("Test Content")
                .build();

        board = Board.builder()
                .boardId(1L)
                .title("Test Board")
                .boardBody("Test Content")
                .build();

        boardResponseDto = BoardResponseDto.builder()
                .boardId(1L)
                .title("Test Board")
                .boardBody("Test Content")
                .build();
    }

    @Test
    public void testCreateBoard() {
        // given
        when(boardService.createBoard(boardPostDto)).thenReturn(board);
        when(boardMapper.toBoardResponseDto(board)).thenReturn(boardResponseDto);

        // when
        ResponseEntity<BoardResponseDto> responseEntity = boardController.createBoard(boardPostDto);

        // then
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(boardResponseDto, responseEntity.getBody());
    }
}