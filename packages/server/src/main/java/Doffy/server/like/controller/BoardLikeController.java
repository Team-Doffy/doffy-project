package Doffy.server.like.controller;

import Doffy.server.community.entity.Board;
import Doffy.server.community.service.BoardService;
import Doffy.server.like.dto.board.LikeBoardDto;
import Doffy.server.like.dto.board.UnlikeBoardDto;
import Doffy.server.like.service.BoardLikeService;
import Doffy.server.user.entity.User;
import Doffy.server.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/boards/{boardId}/likes")
public class BoardLikeController {
    private final BoardLikeService boardLikeService;
    private final UserRepository userRepository;
    private final BoardService boardService;


    @PostMapping
    public ResponseEntity<Void> likeBoard(@PathVariable long boardId, @RequestBody LikeBoardDto likeBoardDto) {
        User user = userRepository.findByUserId(likeBoardDto.getUserId());
        Board board = boardService.findVerifiedBoard(boardId);
        boardLikeService.likeBoard(user, board, likeBoardDto.isLiked());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<Void> unlikeBoard(@PathVariable long boardId, @RequestBody UnlikeBoardDto unlikeBoardDto){
        User user = userRepository.findByUserId(unlikeBoardDto.getUserId());
        Board board = boardService.findVerifiedBoard(boardId);
        boardLikeService.removeLike(user, board);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}


