package Doffy.server.community.dto.comment;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardCommentResponseDto {
    private Long boardCommentId;
    private Long boardId;
    private Long userId;
    private String nickname;
    private String boardCommentBody;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}
