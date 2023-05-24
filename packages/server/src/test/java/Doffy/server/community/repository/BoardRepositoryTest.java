//package Doffy.server.community.repository;
//
//import Doffy.server.community.entity.Board;
//import Doffy.server.user.entity.User;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//@DataJpaTest
//public class BoardRepositoryTest {
//
//    @Autowired
//    private BoardRepository boardRepository;
//
//    @Test
//    public void testFindByUser() {
//        // given
//        User user = new User();
//        user.setUserId(1L);
//        user.setUsername("UserName");
//
//        // when
//        List<Board> boards = boardRepository.findByUser(user);
//
//        // then
//        assertNotNull(boards);
//    }
//
//    @Test
//    public void testFindAll() {
//        // given
//        Pageable pageable = PageRequest.of(0, 10);
//
//        // when
//        Page<Board> boards = boardRepository.findAll(pageable);
//
//        // then
//        assertNotNull(boards);
//    }
//}
