package Doffy.server.community.dto.comment;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReplyCommentResponseDto {
    private Long replyCommentId;
    private Long replyId;
    private Long userId;
    private String nickname;
    private String replyCommentBody;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}
