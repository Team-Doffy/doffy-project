package Doffy.server.community.repository;

import Doffy.server.community.entity.Comment;
import Doffy.server.user.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository <Comment, Long> {
    List<Comment> findByUser(User user);
//    List<Comment> findByBoardIdAndCommentType(long parentId, Comment.CommentType commentType);
//
//    List<Comment> findByReplyIdAndCommentType(long parentId, Comment.CommentType commentType);
}

