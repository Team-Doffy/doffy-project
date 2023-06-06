package Doffy.server.like.repository;

import Doffy.server.community.entity.Reply;
import Doffy.server.like.entity.ReplyLike;
import Doffy.server.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplyLikeRepository extends JpaRepository<ReplyLike, Long> {
    ReplyLike findByUserAndReply(User user, Reply reply);
}
