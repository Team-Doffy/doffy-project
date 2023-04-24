package Doffy.server.community.repository;

import Doffy.server.community.entity.Comment;
import Doffy.server.community.entity.Reply;
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
class ReplyRepositoryTest {

    @Autowired
    private ReplyRepository replyRepository;

    @Test
    public void testFindById() {

        //given
        Reply newReply = new Reply();

        //when
        Reply savedReply = replyRepository.save(newReply);

        Optional<Reply> foundReply = replyRepository.findById(savedReply.getReplyId());

        //then
        assertThat(foundReply).isNotEmpty();
        System.out.println(foundReply);

        assertThat(foundReply.get()).isEqualTo(savedReply);
        System.out.println(foundReply.get() + " = " + savedReply);
    }

}