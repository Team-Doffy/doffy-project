//package Doffy.server.community.repository;
//
//import Doffy.server.community.entity.Board;
//import Doffy.server.community.entity.Reply;
//import Doffy.server.user.entity.User;
//import Doffy.server.user.repository.UserRepository;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@DataJpaTest
//public class ReplyRepositoryTest {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private BoardRepository boardRepository;
//
//    @Autowired
//    private ReplyRepository replyRepository;
//
//    @Test
//    public void testFindByUser() {
//        // given
//        User user = new User();
//        userRepository.save(user);
//
//        // when
//        List<Reply> replies = replyRepository.findByUser(user);
//
//        // then
//        assertNotNull(replies);
//    }
//
//    @Test
//    public void testFindAll() {
//        // given
//        Pageable pageable = PageRequest.of(0, 10);
//
//        // when
//        Page<Reply> replies = replyRepository.findAll(pageable);
//
//        // then
//        assertNotNull(replies);
//    }
//
//    @Test
//    public void testFindByBoard() {
//        // given
//        Board board = new Board();
//        boardRepository.save(board);
//
//        // when
//        List<Reply> replies = replyRepository.findByBoard(board);
//
//        // then
//        assertNotNull(replies);
//    }
//}