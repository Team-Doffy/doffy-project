package Doffy.server.community.repository;

import Doffy.server.community.entity.Board;
import Doffy.server.community.entity.BoardComment;
import Doffy.server.community.entity.Reply;
import Doffy.server.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardCommentRepository extends JpaRepository <BoardComment, Long> {
    List<BoardComment> findByUser(User user);
    List<BoardComment> findByBoard(Board board);
}

