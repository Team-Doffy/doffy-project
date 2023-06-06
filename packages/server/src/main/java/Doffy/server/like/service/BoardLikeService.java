package Doffy.server.like.service;

import Doffy.server.community.entity.Board;
import Doffy.server.community.repository.BoardRepository;
import Doffy.server.like.entity.BoardLike;
import Doffy.server.like.repository.BoardLikeRepository;
import Doffy.server.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BoardLikeService {
    @Autowired
    private BoardLikeRepository boardLikeRepository;

    @Autowired
    private BoardRepository boardRepository;

    @Transactional
    public void likeBoard(User user, Board board, boolean liked) {
        BoardLike boardLike = boardLikeRepository.findByUserAndBoard(user, board);
        if (boardLike != null) {
            // if the like state changes, update the likeCount
            if (boardLike.isLiked() != liked) {
                boardLike.setLiked(liked);
                board.setLikeCount(board.getLikeCount() + (liked ? 1 : -1));
            }
        } else {
            // if this is a new like, increment the likeCount
            boardLike = new BoardLike();
            boardLike.setUser(user);
            boardLike.setBoard(board);
            boardLike.setLiked(liked);
            board.setLikeCount(board.getLikeCount() + 1);
        }
        boardLikeRepository.save(boardLike);
        boardRepository.save(board);
    }

    @Transactional
    public void removeLike(User user, Board board) {
        BoardLike boardLike = boardLikeRepository.findByUserAndBoard(user, board);
        if (boardLike != null) {
            // decrement the likeCount if this like is removed
            board.setLikeCount(board.getLikeCount() - 1);
            boardLikeRepository.delete(boardLike);
            boardRepository.save(board);
        }
    }
}
