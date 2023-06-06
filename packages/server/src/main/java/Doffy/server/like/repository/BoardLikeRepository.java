package Doffy.server.like.repository;

import Doffy.server.community.entity.Board;
import Doffy.server.like.entity.BoardLike;
import Doffy.server.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardLikeRepository extends JpaRepository<BoardLike, Long> {
    BoardLike findByUserAndBoard(User user, Board board);
}
