package Doffy.server.community.service;

import Doffy.server.community.dto.board.BoardPostDto;
import Doffy.server.community.entity.Board;
import Doffy.server.community.mapper.BoardMapper;
import Doffy.server.community.repository.BoardRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;

@Service
public class BoardService {
    private final BoardRepository boardRepository;
    private final BoardMapper boardMapper;

    public BoardService(BoardRepository boardRepository, BoardMapper boardMapper) {
        this.boardRepository = boardRepository;
        this.boardMapper = boardMapper;
    }

    public Board createBoard(BoardPostDto boardPostDto) {
        Board board = boardMapper.toBoard(boardPostDto);
        return boardRepository.save(board);
    }

    public Board findBoard(long boardId){
        return findVerifiedBoard(boardId);
    }

    public Board findVerifiedBoard(long boardId){
        return boardRepository.findById(boardId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Board not found with ID " + boardId));
    }
}
