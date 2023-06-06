package Doffy.server.community.service;

import Doffy.server.community.dto.board.BoardPostDto;
import Doffy.server.community.dto.board.BoardResponseDto;
import Doffy.server.community.dto.board.BoardUpdateDto;
import Doffy.server.community.entity.Board;
import Doffy.server.community.mapper.BoardMapper;
import Doffy.server.community.repository.BoardRepository;
import Doffy.server.global.exception.BusinessLogicException;
import Doffy.server.global.exception.ExceptionCode;
import Doffy.server.user.entity.User;
import Doffy.server.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    private final BoardMapper boardMapper;

    public Board createBoard(BoardPostDto boardPostDto) {
        Board board = boardMapper.toBoard(boardPostDto);
        return boardRepository.save(board);
    }

    @Transactional
    public Board updateBoard(long boardId, BoardUpdateDto boardUpdateDto) {
        Board existingBoard = findVerifiedBoard(boardId);
        existingBoard.setTitle(boardUpdateDto.getTitle());
        existingBoard.setBoardBody(boardUpdateDto.getBoardBody());
        existingBoard.setModifiedAt(LocalDateTime.now());
        return boardRepository.save(existingBoard);
    }

    public void deleteBoard(long boardId) {
        Board board = findVerifiedBoard(boardId);
        boardRepository.delete(board);
    }

    public List<BoardResponseDto> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return boardRepository.findAll(pageable)
                .stream()
                .map(boardMapper::toBoardResponseDto)
                .collect(Collectors.toList());
    }

    public List<BoardResponseDto> findBoardsByUser(User user) {
        List<Board> boards = boardRepository.findByUser(user);
        List<BoardResponseDto> responseDtos = boards.stream()
                .map(board -> boardMapper.toBoardResponseDto(board))
                .collect(Collectors.toList());
        return responseDtos;
    }

//    public Board findBoard(long boardId){
//        return findVerifiedBoard(boardId);
//    }

    public Board findVerifiedBoard(long boardId){
        return boardRepository.findById(boardId)
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.BOARD_NOT_FOUND));
    }
}
