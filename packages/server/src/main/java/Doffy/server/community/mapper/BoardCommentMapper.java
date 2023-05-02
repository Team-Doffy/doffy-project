package Doffy.server.community.mapper;

import Doffy.server.community.dto.comment.BoardCommentPostDto;
import Doffy.server.community.dto.comment.BoardCommentResponseDto;
import Doffy.server.community.entity.Board;
import Doffy.server.community.entity.BoardComment;
import Doffy.server.user.entity.User;
import org.springframework.stereotype.Component;

@Component
public class BoardCommentMapper {
    Board board = new Board();
    User user = new User();
    public BoardComment toComment(BoardCommentPostDto commentPostDto){
        return BoardComment.builder()
                .boardCommentId(commentPostDto.getBoardId())
                .boardCommentBody(commentPostDto.getBoardCommentBody())
                .board(board)
                .build();
    }
    public BoardCommentResponseDto toCommentResponseDto(BoardComment boardComment){

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
