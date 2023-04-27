package Doffy.server.community.dto.comment;

import lombok.*;

import java.time.LocalDateTime;

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
}
