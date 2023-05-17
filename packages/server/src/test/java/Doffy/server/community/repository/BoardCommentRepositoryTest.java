package Doffy.server.community.repository;

import Doffy.server.community.entity.Board;
import Doffy.server.community.entity.BoardComment;
import Doffy.server.user.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class BoardCommentRepositoryTest {

    @Autowired
    private BoardCommentRepository boardCommentRepository;

    @Test
    public void testFindByUser() {
        // given
        User user = new User();
        user.setUserId(1L);
        user.setUsername("TEST");

        // when
        List<BoardComment> comments = boardCommentRepository.findByUser(user);

        // then
        assertNotNull(comments);
    }

    @Test
    public void testFindByBoard() {
        // given
        Board board = new Board();
        board.setBoardId(1L);
        board.setBoardBody("TEST");

        // when
        List<BoardComment> comments = boardCommentRepository.findByBoard(board);

        // then
        assertNotNull(comments);
    }
}
