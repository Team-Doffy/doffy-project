package Doffy.server.community.dto.board;

import Doffy.server.community.dto.comment.CommentResponseDto;
import Doffy.server.community.dto.reply.ReplyResponseDto;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardDetailedResponseDto {

    private Long boardId;
    private int userId;
    private String nickname;
    private String title;
    private String boardBody;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    private List<CommentResponseDto> comments;
    private List<ReplyResponseDto> replies;
}
