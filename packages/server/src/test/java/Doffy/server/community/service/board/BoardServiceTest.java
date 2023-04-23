package Doffy.server.community.service.board;

import static org.junit.jupiter.api.Assertions.*;

import Doffy.server.community.dto.board.BoardPostDto;
import Doffy.server.community.entity.Board;
import Doffy.server.community.mapper.BoardMapper;
import Doffy.server.community.repository.BoardRepository;
import Doffy.server.community.service.BoardService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BoardServiceTest {

    @Mock
    private BoardRepository boardRepository;
    @Mock
    private BoardMapper boardMapper;

    @Test
    public void testCreateBoard() {
        // given
        BoardPostDto boardPostDto = BoardPostDto.builder()
                .title("Test Board")
                .boardBody("Test Content")
                .build();

        Board board = Board.builder()
                .boardId(1L)
                .title("Test Board")
                .boardBody("Test Content")
                .build();

        BoardService boardService = new BoardService(boardRepository, boardMapper);

        when(boardMapper.toBoard(boardPostDto)).thenReturn(board);
        when(boardRepository.save(board)).thenReturn(board);

        // when
        Board createdBoard = boardService.createBoard(boardPostDto);

        // then
        assertEquals(board, createdBoard);
        verify(boardMapper).toBoard(boardPostDto);
        verify(boardRepository).save(board);
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

        BoardService boardService = new BoardService(boardRepository, boardMapper);
        Board foundBoard = boardService.findBoard(1L);

        //then
        assertEquals(board.getBoardId(), foundBoard.getBoardId());
        assertEquals(board.getTitle(), foundBoard.getTitle());
        assertEquals(board.getBoardBody(), foundBoard.getBoardBody());
    }

    @Test
    public void testFindVerifiedBoardNotFound() {

        //given
        BoardService boardService = new BoardService(boardRepository, boardMapper);

        //when
        when(boardRepository.findById(1L)).thenReturn(java.util.Optional.empty());

        //then
        assertThrows(ResponseStatusException.class, () -> {
            boardService.findVerifiedBoard(1L);
        });
    }
}
