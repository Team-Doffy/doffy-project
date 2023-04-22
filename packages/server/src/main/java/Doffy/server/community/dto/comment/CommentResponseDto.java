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
    private String commentBody;
    private Integer commentLikes;
    private LocalDateTime createdAt;
}
