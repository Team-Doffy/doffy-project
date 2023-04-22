package Doffy.server.community.repository;

import Doffy.server.community.entity.Board;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class BoardRepositoryTest {

    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void testFindById() {
        Board newBoard = new Board();

        Board savedBoard = boardRepository.save(newBoard);

        Optional<Board> foundBoard = boardRepository.findById(savedBoard.getBoardId());

        assertThat(foundBoard).isNotEmpty();
        assertThat(foundBoard.get()).isEqualTo(savedBoard);
    }
}