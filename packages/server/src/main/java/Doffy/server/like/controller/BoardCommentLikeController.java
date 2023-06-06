package Doffy.server.like.controller;

import Doffy.server.community.entity.BoardComment;
import Doffy.server.community.service.BoardCommentService;
import Doffy.server.like.dto.comment.LikeBoardCommentDto;
import Doffy.server.like.dto.comment.UnlikeBoardCommentDto;
import Doffy.server.like.service.BoardCommentLikeService;
import Doffy.server.user.entity.User;
import Doffy.server.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/board-comments/{commentId}/likes")
public class BoardCommentLikeController {
    private final BoardCommentLikeService commentLikeService;
    private final UserRepository userRepository;
    private final BoardCommentService commentService;


    @PostMapping
    public ResponseEntity<Void> likeBoardComment(@PathVariable long boardCommentId, @RequestBody LikeBoardCommentDto likeBoardCommentDto) {
        User user = userRepository.findByUserId(likeBoardCommentDto.getUserId());
        BoardComment comment = commentService.findVerifiedComment(boardCommentId);
        commentLikeService.likeBoardComment(user, comment, likeBoardCommentDto.isCommentLiked());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<Void> unlikeBoardComment(@PathVariable long boardCommentId, @RequestBody UnlikeBoardCommentDto unlikeBoardCommentDto){
        User user = userRepository.findByUserId(unlikeBoardCommentDto.getUserId());
        BoardComment comment = commentService.findVerifiedComment(boardCommentId);
        commentLikeService.removeLike(user, comment);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
