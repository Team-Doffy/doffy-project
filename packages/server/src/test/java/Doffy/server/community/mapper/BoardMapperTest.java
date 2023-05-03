package Doffy.server.community.mapper;

import Doffy.server.community.dto.board.BoardPostDto;
import Doffy.server.community.dto.board.BoardResponseDto;
import Doffy.server.community.entity.Board;
import Doffy.server.user.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class BoardMapperTest {

    @Autowired
    private BoardMapper boardMapper;

    @MockBean
    private User user;

    private BoardPostDto boardPostDto;
    private Board board;

    @BeforeEach
    public void setUp() {
        // given
        String title = "Test Title";
        String boardBody = "Test Board Body";
        LocalDateTime createdAt = LocalDateTime.now();
        LocalDateTime modifiedAt = LocalDateTime.now();

        boardPostDto = BoardPostDto.builder()
                .title(title)
                .boardBody(boardBody)
                .build();

        when(user.getUserId()).thenReturn(1L);
        when(user.getNickname()).thenReturn("testUser");

        board = Board.builder()
                .boardId(1L)
                .user(user)
                .title(title)
                .boardBody(boardBody)
                .createdAt(createdAt)
                .modifiedAt(modifiedAt)
                .build();
    }

    @Test
    public void testToBoard() {
        // when
        Board result = boardMapper.toBoard(boardPostDto);
        System.out.println(result);

        // then
        assertEquals(boardPostDto.getTitle(), result.getTitle());
        assertEquals(boardPostDto.getBoardBody(), result.getBoardBody());
    }

    @Test
    public void testToBoardResponseDto() {
        // when
        BoardResponseDto result = boardMapper.toBoardResponseDto(board);
        System.out.println(result);

        // then
        assertEquals(board.getBoardId(), result.getBoardId());
        assertEquals(board.getUser().getUserId(), result.getUserId());
        assertEquals(board.getUser().getNickname(), result.getNickname());
        assertEquals(board.getTitle(), result.getTitle());
        assertEquals(board.getCreatedAt(), result.getCreatedAt());
        assertEquals(board.getModifiedAt(), result.getModifiedAt());
    }
}
