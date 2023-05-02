package Doffy.server.community.dto.reply;

import Doffy.server.community.dto.comment.BoardCommentResponseDto;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReplyResponseDto {
    private Long replyId;
    private Long userId;
    private String nickname;
    private String replyBody;
    private Boolean isAccepted;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}
