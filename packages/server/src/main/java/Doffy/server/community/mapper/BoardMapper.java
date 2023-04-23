package Doffy.server.community.mapper;

import Doffy.server.community.dto.board.BoardPostDto;
import Doffy.server.community.dto.board.BoardResponseDto;
import Doffy.server.community.entity.Board;
import Doffy.server.community.entity.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BoardMapper {
    public Board toBoard(BoardPostDto boardPostDto){
        return Board.builder()
                //.userId(board.getUserId())
//                .boardId(boardPostDto.getBoardId())
                .title(boardPostDto.getTitle())
                .boardBody(boardPostDto.getBoardBody())
                .build();
    }

    public BoardResponseDto toBoardResponseDto(Board board){
        BoardResponseDto response = BoardResponseDto.builder()
                .boardId(board.getBoardId())
                .title(board.getTitle())
                .boardBody(board.getBoardBody())
                .boardLikes(board.getBoardLikes())
                .createdAt(board.getCreatedAt())
                .modifiedAt(board.getModifiedAt())
//                .comments(List<CommentResponseDto>)
//                .replies(List<ReplyResponseDto>)
                .build();
        return response;
    }

}
