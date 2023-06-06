package Doffy.server.community.service;

import Doffy.server.community.dto.comment.BoardCommentPostDto;
import Doffy.server.community.dto.comment.BoardCommentResponseDto;
import Doffy.server.community.dto.comment.BoardCommentUpdateDto;
import Doffy.server.community.entity.Board;
import Doffy.server.community.entity.BoardComment;
import Doffy.server.community.mapper.BoardCommentMapper;
import Doffy.server.community.repository.BoardCommentRepository;
import Doffy.server.user.entity.User;
import Doffy.server.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import Doffy.server.global.exception.BusinessLogicException;
import Doffy.server.global.exception.ExceptionCode;


import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardCommentService {
    private final BoardCommentRepository boardCommentRepository;
    private final BoardCommentMapper boardCommentMapper;
    private final BoardService boardService;
    private final UserRepository userRepository;

    public BoardComment createComment(BoardCommentPostDto commentPostDto, Board board, User user) {
        BoardComment boardComment = boardCommentMapper.toComment(commentPostDto, board, user);
        return boardCommentRepository.save(boardComment);
    }

    public BoardComment updateComment(long commentId, BoardCommentUpdateDto updateDto) {
        BoardComment boardComment = findVerifiedComment(commentId);
        boardComment.setBoardCommentBody(updateDto.getBoardCommentBody());
        return boardCommentRepository.save(boardComment);
    }

    public void deleteComment(long commentId) {
        BoardComment boardComment = findVerifiedComment(commentId);
        boardCommentRepository.delete(boardComment);
    }

    public List<BoardCommentResponseDto> findBoardComments(long boardId) {
        Board getBoard = boardService.findVerifiedBoard(boardId);
        List<BoardComment> boardComments = boardCommentRepository.findByBoard(getBoard);
        List<BoardCommentResponseDto> responseDtos = boardComments.stream()
                .map(boardCommentMapper::toCommentResponseDto)
                .collect(Collectors.toList());
        return responseDtos;
    }

    public BoardComment findComment(long commentId) {
        return findVerifiedComment(commentId);
    }

    public BoardComment findVerifiedComment(long commentId) {
        return boardCommentRepository.findById(commentId)
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.COMMENT_NOT_FOUND));
    }
}


