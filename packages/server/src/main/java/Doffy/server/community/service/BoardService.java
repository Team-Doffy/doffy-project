package Doffy.server.community.service;

import Doffy.server.community.entity.Board;
import Doffy.server.community.repository.BoardRepository;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import reactor.util.annotation.Nullable;

import java.util.Optional;

@Service
public class BoardService {
    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public Board createBoard(Board board){
        Board savedBoard = boardRepository.save(board);

        return savedBoard;
    }

    public Board findBoard(long boardId){
        return findVerifiedBoard(boardId);
    }

    public Board findVerifiedBoard(long boardId){
        return boardRepository.findById(boardId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Board not found with ID " + boardId));
    }
}
