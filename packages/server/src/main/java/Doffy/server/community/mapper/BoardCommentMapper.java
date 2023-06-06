package Doffy.server.community.mapper;

import Doffy.server.community.dto.board.BoardUpdateDto;
import Doffy.server.community.dto.comment.BoardCommentPostDto;
import Doffy.server.community.dto.comment.BoardCommentResponseDto;
import Doffy.server.community.dto.comment.BoardCommentUpdateDto;
import Doffy.server.community.entity.Board;
import Doffy.server.community.entity.BoardComment;
import Doffy.server.user.entity.User;
import Doffy.server.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor

public class BoardCommentMapper {

    public BoardComment toComment(BoardCommentPostDto commentPostDto, Board board, User user){
        return BoardComment.builder()
                .user(user)
                .boardCommentBody(commentPostDto.getBoardCommentBody())
                .board(board)
                .build();
    }

    public BoardComment toCommentUpdateDto(BoardCommentUpdateDto updateDto){
        return BoardComment.builder()
                .boardCommentBody(updateDto.getBoardCommentBody())
                .build();
    }

    public BoardCommentResponseDto toCommentResponseDto(BoardComment boardComment){
        Board board = boardComment.getBoard();
        User user = boardComment.getUser();

        BoardCommentResponseDto response = BoardCommentResponseDto.builder()
                .boardCommentId(boardComment.getBoardCommentId())
                .userId(user.getUserId())
                .nickname(user.getNickname())
                .boardId(board.getBoardId())
                .boardCommentBody(boardComment.getBoardCommentBody())
                .createdAt(boardComment.getCreatedAt())
                .modifiedAt(boardComment.getModifiedAt())
                .build();
        return response;
    }
}
