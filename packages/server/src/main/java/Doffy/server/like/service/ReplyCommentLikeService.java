package Doffy.server.like.service;

import Doffy.server.community.entity.ReplyComment;
import Doffy.server.community.repository.ReplyCommentRepository;
import Doffy.server.like.entity.ReplyCommentLike;
import Doffy.server.like.repository.ReplyCommentLikeRepository;
import Doffy.server.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReplyCommentLikeService {
    @Autowired
    private ReplyCommentLikeRepository commentLikeRepository;
    @Autowired
    private ReplyCommentRepository commentRepository;

    @Transactional
    public void likeReplyComment(User user, ReplyComment comment, boolean liked) {
        ReplyCommentLike commentLike = commentLikeRepository.findByUserAndReplyComment(user, comment);
        if (commentLike != null) {
            if (commentLike.isCommentLiked() != liked) {
                commentLike.setCommentLiked(liked);
                comment.setLikeCount(comment.getLikeCount() + (liked ? 1 : -1));
            }
        } else {
            commentLike = new ReplyCommentLike();
            commentLike.setUser(user);
            commentLike.setReplyComment(comment);
            commentLike.setCommentLiked(liked);
            comment.setLikeCount(comment.getLikeCount() + 1);
        }
        commentLikeRepository.save(commentLike);
        commentRepository.save(comment);
    }

    @Transactional
    public void removeLike(User user, ReplyComment comment) {
        ReplyCommentLike commentLike = commentLikeRepository.findByUserAndReplyComment(user, comment);
        if (commentLike != null) {
            comment.setLikeCount(comment.getLikeCount() - 1);
            commentLikeRepository.delete(commentLike);
            commentRepository.save(comment);
        }
    }
}
