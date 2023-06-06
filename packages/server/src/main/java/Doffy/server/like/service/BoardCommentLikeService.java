package Doffy.server.like.service;

import Doffy.server.community.entity.Board;
import Doffy.server.community.entity.BoardComment;
import Doffy.server.community.repository.BoardCommentRepository;
import Doffy.server.community.repository.BoardRepository;
import Doffy.server.like.entity.BoardCommentLike;
import Doffy.server.like.entity.BoardLike;
import Doffy.server.like.repository.BoardCommentLikeRepository;
import Doffy.server.like.repository.BoardLikeRepository;
import Doffy.server.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BoardCommentLikeService {
    @Autowired
    private BoardCommentLikeRepository commentLikeRepository;

    @Autowired
    private BoardCommentRepository commentRepository;

    @Transactional
    public void likeBoardComment(User user, BoardComment comment, boolean liked) {
        BoardCommentLike commentLike = commentLikeRepository.findByUserAndBoardComment(user, comment);
        if (commentLike != null) {
            // if the like state changes, update the likeCount
            if (commentLike.isCommentLiked() != liked) {
                commentLike.setCommentLiked(liked);
                comment.setLikeCount(comment.getLikeCount() + (liked ? 1 : -1));
            }
        } else {
            // if this is a new like, increment the likeCount
            commentLike = new BoardCommentLike();
            commentLike.setUser(user);
            commentLike.setBoardComment(comment);
            commentLike.setCommentLiked(liked);
            comment.setLikeCount(comment.getLikeCount() + 1);
        }
        commentLikeRepository.save(commentLike);
        commentRepository.save(comment);
    }

    @Transactional
    public void removeLike(User user, BoardComment comment) {
        BoardCommentLike commentLike = commentLikeRepository.findByUserAndBoardComment(user, comment);
        if (commentLike != null) {
            comment.setLikeCount(comment.getLikeCount() - 1);
            commentLikeRepository.delete(commentLike);
            commentRepository.save(comment);
        }
    }
}
