package Doffy.server.like.repository;

import Doffy.server.community.entity.BoardComment;
import Doffy.server.like.entity.BoardCommentLike;
import Doffy.server.like.entity.BoardLike;
import Doffy.server.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardCommentLikeRepository extends JpaRepository<BoardCommentLike, Long> {
    BoardCommentLike findByUserAndBoardComment(User user, BoardComment boardComment);
}
