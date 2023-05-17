package Doffy.server.community.repository;

import Doffy.server.community.entity.BoardComment;
import Doffy.server.community.entity.Reply;
import Doffy.server.community.entity.ReplyComment;
import Doffy.server.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReplyCommentRepository extends JpaRepository<ReplyComment , Long> {
    List<ReplyComment> findByUser(User user);
    List<ReplyComment> findAllByReply(Reply reply);
}
