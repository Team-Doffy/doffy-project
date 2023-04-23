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
    public BoardPostDto boardPostDto(Board board){
        BoardPostDto request = BoardPostDto.builder()
//                .userId(board.getUserId)
                .boardId(board.getBoardId())
                .title(board.getTitle())
                .boardBody(board.getBoardBody())
                .build();
        return request;
    }

    public BoardResponseDto boardResponseDto(Board board){
        BoardResponseDto response = BoardResponseDto.builder()
                .boardId(board.getBoardId())
                .title(board.getTitle())
                .boardBody(board.getBoardBody())
                .boardLikes(board.getBoardLikes())
                .createdAt(board.getCreatedAt())
                .modifiedAt(board.getModifiedAt())
//                .comments(List<commentResponseDto>)
//                .replies(List<replyResponseDto>)
                .build();
        return response;
    }

}
