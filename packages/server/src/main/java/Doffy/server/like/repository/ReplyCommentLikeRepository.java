package Doffy.server.like.repository;

import Doffy.server.community.entity.ReplyComment;
import Doffy.server.like.entity.ReplyCommentLike;
import Doffy.server.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplyCommentLikeRepository extends JpaRepository<ReplyCommentLike, Long> {
    ReplyCommentLike findByUserAndReplyComment(User user, ReplyComment replyComment);
}
