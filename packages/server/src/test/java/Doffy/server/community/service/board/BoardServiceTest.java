package Doffy.server.community.service.board;

import static org.junit.jupiter.api.Assertions.*;

import Doffy.server.community.entity.Board;
import Doffy.server.community.repository.BoardRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.server.ResponseStatusException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BoardServiceTest {

    @Mock
    private BoardRepository boardRepository;

    @Test
    public void testCreateBoard() {

        //given
        Board board = new Board();
        board.setTitle("Test Board");
        board.setBoardBody("Test Content");

        //when
        when(boardRepository.save(board)).thenReturn(board);

        BoardService boardService = new BoardService(boardRepository);
        Board savedBoard = boardService.createBoard(board);

        //then
        assertEquals(board.getTitle(), savedBoard.getTitle());
        assertEquals(board.getBoardBody(), savedBoard.getBoardBody());
    }

    @Test
    public void testFindBoard() {

        //given
        Board board = new Board();
        board.setBoardId(1L);
        board.setTitle("Test Board");
        board.setBoardBody("Test Content");

        //when
        when(boardRepository.findById(1L)).thenReturn(java.util.Optional.of(board));

        BoardService boardService = new BoardService(boardRepository);
        Board foundBoard = boardService.findBoard(1L);

        //then
        assertEquals(board.getBoardId(), foundBoard.getBoardId());
        assertEquals(board.getTitle(), foundBoard.getTitle());
        assertEquals(board.getBoardBody(), foundBoard.getBoardBody());
    }

    @Test
    public void testFindVerifiedBoardNotFound() {

        //given
        BoardService boardService = new BoardService(boardRepository);

        //when
        when(boardRepository.findById(1L)).thenReturn(java.util.Optional.empty());

        //then
        assertThrows(ResponseStatusException.class, () -> {
            boardService.findVerifiedBoard(1L);
        });
    }
}
