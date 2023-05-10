package Doffy.server.community.mapper;

import Doffy.server.community.dto.board.BoardPostDto;
import Doffy.server.community.dto.board.BoardResponseDto;
import Doffy.server.community.entity.Board;
import Doffy.server.user.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class BoardMapperTest {

    @Autowired
    private BoardMapper boardMapper;

    @Test
    public void testToBoard() {
        // given
        BoardPostDto boardPostDto = BoardPostDto.builder()
                .title("Test Board")
                .boardBody("This is a test board.")
                .build();

        // when
        Board board = boardMapper.toBoard(boardPostDto);

        // then
        assertNotNull(board);
        assertEquals(boardPostDto.getTitle(), board.getTitle());
        assertEquals(boardPostDto.getBoardBody(), board.getBoardBody());
    }

    @Test
    public void testToBoardResponseDto() {
        // given

        User user = User.builder()
                .userId(1L)
                .name("testName")
                .nickname("testNick")
                .username("s@gmail.com")
                .build();

        Board board = Board.builder()
                .boardId(1L)
                .user(user)
                .title("Test Board")
                .boardBody("This is a test board.")
                .createdAt(LocalDateTime.now())
                .modifiedAt(LocalDateTime.now())
                .build();

        // when
        BoardResponseDto boardResponseDto = boardMapper.toBoardResponseDto(board);

        // then
        assertNotNull(boardResponseDto);
        assertEquals(board.getBoardId(), boardResponseDto.getBoardId());
        assertEquals(board.getUser().getUserId(), boardResponseDto.getUserId());
        assertEquals(board.getUser().getNickname(), boardResponseDto.getNickname());
        assertEquals(board.getTitle(), boardResponseDto.getTitle());
        assertEquals(board.getCreatedAt(), boardResponseDto.getCreatedAt());
        assertEquals(board.getModifiedAt(), boardResponseDto.getModifiedAt());
    }
}
