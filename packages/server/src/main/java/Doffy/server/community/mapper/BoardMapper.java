package Doffy.server.community.mapper;

import Doffy.server.community.dto.board.BoardDetailedResponseDto;
import Doffy.server.community.dto.board.BoardPostDto;
import Doffy.server.community.dto.board.BoardResponseDto;
import Doffy.server.community.dto.board.BoardUpdateDto;
import Doffy.server.community.entity.Board;
import Doffy.server.user.entity.User;
import Doffy.server.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class BoardMapper {
    private final UserRepository userRepository;
    public Board toBoard(BoardPostDto boardPostDto){
        User user = userRepository.findByUserId(boardPostDto.getUserId());
        return Board.builder()
                .user(user)
                .likeCount(0)
                .title(boardPostDto.getTitle())
                .boardBody(boardPostDto.getBoardBody())
                .build();
    }

    public Board boardUpdateDtoToBoard(BoardUpdateDto boardUpdateDto){
        return Board.builder()
                .title(boardUpdateDto.getTitle())
                .boardBody(boardUpdateDto.getBoardBody())
                .build();
    }

    public BoardResponseDto toBoardResponseDto(Board board){
        BoardResponseDto response = BoardResponseDto.builder()
                .boardId(board.getBoardId())
                .userId(board.getUser().getUserId())
                .nickname(board.getUser().getNickname())
                .title(board.getTitle())
                .likeCount(board.getLikeCount())
//                .replyCount(board.getReplies().size())
                .createdAt(board.getCreatedAt())
                .modifiedAt(board.getModifiedAt())
                .build();
        return response;
    }

    public BoardDetailedResponseDto toBoardDetailedResponseDto(Board board){
        BoardDetailedResponseDto response = BoardDetailedResponseDto.builder()
                .boardId(board.getBoardId())
                .userId(board.getUser().getUserId())
                .nickname(board.getUser().getNickname())
                .title(board.getTitle())
                .boardBody(board.getBoardBody())
                .likeCount(board.getLikeCount())
                .createdAt(board.getCreatedAt())
                .modifiedAt(board.getModifiedAt())
                .build();
        return response;
    }
}
