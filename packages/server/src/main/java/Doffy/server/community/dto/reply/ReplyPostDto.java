package Doffy.server.community.dto.reply;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReplyPostDto {
    private Long boardId;
    private Long userId;
    private String replyBody;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}
