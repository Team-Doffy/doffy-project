package Doffy.server.community.mapper;

import Doffy.server.community.dto.board.BoardPostDto;
import Doffy.server.community.dto.board.BoardResponseDto;
import Doffy.server.community.entity.Board;
import org.springframework.stereotype.Component;

@Component
public class BoardMapper {
    public Board toBoard(BoardPostDto boardPostDto){
        return Board.builder()
                .title(boardPostDto.getTitle())
                .boardBody(boardPostDto.getBoardBody())
                .build();
    }

    public BoardResponseDto toBoardResponseDto(Board board){
        BoardResponseDto response = BoardResponseDto.builder()
                .boardId(board.getBoardId())
                .userId(board.getUser().getUserId())
                .nickname(board.getUser().getNickname())
                .title(board.getTitle())
                .createdAt(board.getCreatedAt())
                .modifiedAt(board.getModifiedAt())
                .build();
        return response;
    }
}