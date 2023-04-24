package Doffy.server.community.repository;

import Doffy.server.community.entity.Board;
import Doffy.server.community.entity.Comment;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class CommentRepositoryTest {

    @Autowired
    private CommentRepository commentRepository;

    @Test
    public void testFindById() {

        //given
        Comment newComment = new Comment();

        //when
        Comment savedComment = commentRepository.save(newComment);

        Optional<Comment> foundComment = commentRepository.findById(savedComment.getCommentId());

        //then
        assertThat(foundComment).isNotEmpty();
        System.out.println(foundComment);

        assertThat(foundComment.get()).isEqualTo(savedComment);
        System.out.println(foundComment.get() + " = " +savedComment);
    }
}