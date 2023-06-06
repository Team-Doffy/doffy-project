package Doffy.server.like.service;

import Doffy.server.community.entity.Reply;
import Doffy.server.community.repository.ReplyRepository;
import Doffy.server.like.entity.ReplyLike;
import Doffy.server.like.repository.ReplyLikeRepository;
import Doffy.server.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReplyLikeService {
    @Autowired
    private ReplyLikeRepository replyLikeRepository;
    @Autowired
    private ReplyRepository replyRepository;

    @Transactional
    public void likeReply(User user, Reply reply, boolean liked) {
        ReplyLike replyLike = replyLikeRepository.findByUserAndReply(user, reply);
        if (replyLike != null) {
            // if the like state changes, update the likeCount
            if (replyLike.isLiked() != liked) {
                replyLike.setLiked(liked);
                reply.setLikeCount(reply.getLikeCount() + (liked ? 1 : -1));
            }
        } else {
            // if this is a new like, increment the likeCount
            replyLike = new ReplyLike();
            replyLike.setUser(user);
            replyLike.setReply(reply);
            replyLike.setLiked(liked);
            reply.setLikeCount(reply.getLikeCount() + 1);
        }
        replyLikeRepository.save(replyLike);
        replyRepository.save(reply);
    }

    @Transactional
    public void removeLike(User user, Reply reply) {
        ReplyLike replyLike = replyLikeRepository.findByUserAndReply(user, reply);
        if (replyLike != null) {
            // decrement the likeCount if this like is removed
            reply.setLikeCount(reply.getLikeCount() - 1);
            replyLikeRepository.delete(replyLike);
            replyRepository.save(reply);
        }
    }
}
