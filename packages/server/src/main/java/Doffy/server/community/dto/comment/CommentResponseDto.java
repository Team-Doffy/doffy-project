package Doffy.server.community.dto.comment;

import Doffy.server.community.dto.reply.ReplyResponseDto;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentResponseDto {
    private Long commentId;
    private Long parentId;
    private int userId;
    private String nickname;
    private String commentType;
    private String commentBody;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private List<ReplyResponseDto> replies;
}
