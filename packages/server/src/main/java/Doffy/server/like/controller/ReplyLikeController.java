package Doffy.server.like.controller;

import Doffy.server.community.entity.Board;
import Doffy.server.community.entity.Reply;
import Doffy.server.community.service.ReplyService;
import Doffy.server.like.dto.board.UnlikeBoardDto;
import Doffy.server.like.dto.reply.LikeReplyDto;
import Doffy.server.like.dto.reply.UnlikeReplyDto;
import Doffy.server.like.service.ReplyLikeService;
import Doffy.server.user.entity.User;
import Doffy.server.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/replies/{replyId}/likes")
public class ReplyLikeController {
    private final ReplyLikeService replyLikeService;
    private final UserRepository userRepository;
    private final ReplyService replyService;


    @PostMapping
    public ResponseEntity<Void> likeReply(@PathVariable long replyId, @RequestBody LikeReplyDto likeReplyDto) {
        User user = userRepository.findByUserId(likeReplyDto.getUserId());
        Reply reply = replyService.findVerifiedReply(replyId);
        replyLikeService.likeReply(user, reply, likeReplyDto.isLiked());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<Void> unlikeBoard(@PathVariable long replyId, @RequestBody UnlikeReplyDto unlikeReplyDto){
        User user = userRepository.findByUserId(unlikeReplyDto.getUserId());
        Reply reply = replyService.findVerifiedReply(replyId);
        replyLikeService.removeLike(user, reply);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
