package Doffy.server.community.mapper;

import Doffy.server.community.dto.board.BoardPostDto;
import Doffy.server.community.dto.board.BoardResponseDto;
import Doffy.server.community.entity.Board;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class BoardMapperTest {

    private final BoardMapper boardMapper = new BoardMapper();

    @Test
    public void shouldMapBoardToBoardPostDto() {
        // given
        BoardPostDto boardPostDto = BoardPostDto.builder()
                .title("Test Board")
                .boardBody("Test Content")
                .build();

        Board board = boardMapper.toBoard(boardPostDto);

        // then
        assertNotNull(boardPostDto);
        assertEquals(board.getTitle(), boardPostDto.getTitle());
        assertEquals(board.getBoardBody(), boardPostDto.getBoardBody());
    }

    @Test
    public void shouldMapBoardToBoardResponseDto() {
        // given
        Board board = new Board();
        board.setBoardId(1L);
        board.setTitle("Test Board");
        board.setBoardBody("Test Content");
        board.setBoardLikes(10);
        board.setCreatedAt(LocalDateTime.now());
        board.setModifiedAt(LocalDateTime.now());

        // when
        BoardResponseDto boardResponseDto = boardMapper.toBoardResponseDto(board);

        // then
        assertNotNull(boardResponseDto);
        assertEquals(board.getBoardId(), boardResponseDto.getBoardId());
        assertEquals(board.getTitle(), boardResponseDto.getTitle());
        assertEquals(board.getBoardBody(), boardResponseDto.getBoardBody());
        assertEquals(board.getBoardLikes(), boardResponseDto.getBoardLikes());
        assertEquals(board.getCreatedAt(), boardResponseDto.getCreatedAt());
        assertEquals(board.getModifiedAt(), boardResponseDto.getModifiedAt());
    }
}