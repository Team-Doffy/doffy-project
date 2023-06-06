package Doffy.server.like.controller;

import Doffy.server.community.entity.ReplyComment;
import Doffy.server.community.service.ReplyCommentService;
import Doffy.server.like.dto.comment.LikeReplyCommentDto;
import Doffy.server.like.dto.comment.UnlikeReplyCommentDto;
import Doffy.server.like.service.ReplyCommentLikeService;
import Doffy.server.user.entity.User;
import Doffy.server.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/reply-comments/{commentId}/likes")
public class ReplyCommentLikeController {
    private final ReplyCommentLikeService commentLikeService;
    private final UserRepository userRepository;
    private final ReplyCommentService commentService;


    @PostMapping
    public ResponseEntity<Void> likeReply(@PathVariable long replyCommentId, @RequestBody LikeReplyCommentDto likeReplyCommentDto) {
        User user = userRepository.findByUserId(likeReplyCommentDto.getUserId());
        ReplyComment comment = commentService.findVerifiedComment(replyCommentId);
        commentLikeService.likeReplyComment(user, comment, likeReplyCommentDto.isCommentLiked());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<Void> unlikeBoard(@PathVariable long replyCommentId, @RequestBody UnlikeReplyCommentDto unlikeReplyCommentDto){
        User user = userRepository.findByUserId(unlikeReplyCommentDto.getUserId());
        ReplyComment comment = commentService.findVerifiedComment(replyCommentId);
        commentLikeService.removeLike(user, comment);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
