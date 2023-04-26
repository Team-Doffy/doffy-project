package Doffy.server.community.mapper;

import Doffy.server.community.dto.board.BoardDetailedResponseDto;
import Doffy.server.community.dto.board.BoardPostDto;
import Doffy.server.community.dto.board.BoardResponseDto;
import Doffy.server.community.dto.comment.CommentResponseDto;
import Doffy.server.community.dto.reply.ReplyResponseDto;
import Doffy.server.community.entity.Board;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

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
                .title(board.getTitle())
                .createdAt(board.getCreatedAt())
                .modifiedAt(board.getModifiedAt())
                .build();
        return response;
    }

    public BoardDetailedResponseDto toBoardDetailedResponseDto(Board board, CommentMapper commentMapper, ReplyMapper replyMapper){
        List<CommentResponseDto> comments = board.getComments().stream()
                .map(commentMapper::toCommentResponseDto)
                .collect(Collectors.toList());

        List<ReplyResponseDto> replies = board.getReplies().stream()
                .map(reply -> {
                    List<CommentResponseDto> replyComments = reply.getComments().stream()
                            .map(commentMapper::toCommentResponseDto)
                            .collect(Collectors.toList());
                    return replyMapper.toReplyResponseDto(reply, replyComments);
                })
                .collect(Collectors.toList());

        BoardDetailedResponseDto response = BoardDetailedResponseDto.builder()
                .boardId(board.getBoardId())
                .title(board.getTitle())
                .boardBody(board.getBoardBody())
                .createdAt(board.getCreatedAt())
                .modifiedAt(board.getModifiedAt())
                .comments(comments)
                .replies(replies)
                .build();

        return response;
    }

}
