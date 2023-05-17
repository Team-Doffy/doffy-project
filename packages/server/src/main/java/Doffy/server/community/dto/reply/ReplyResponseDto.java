package Doffy.server.community.dto.reply;

import lombok.*;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReplyResponseDto {
    private Long replyId;
    private Long userId;
    private Long boardId;
    private String nickname;
    private String replyBody;
    private Boolean isAccepted;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public boolean isAccepted() {
        return isAccepted;
    }
}
