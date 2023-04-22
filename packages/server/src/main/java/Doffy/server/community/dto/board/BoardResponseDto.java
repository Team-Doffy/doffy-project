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
public class BoardResponseDto {
    private Long boardId;
    private String title;
    private String boardBody;
    private Integer boardLikes;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    private List<CommentResponseDto> comments;
    private List<ReplyResponseDto> replies;
}
