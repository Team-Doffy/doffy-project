package Doffy.server.community.dto.comment;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardCommentPostDto implements Serializable {
    private long boardId;
    private Long userId;
    private String boardCommentBody;
    LocalDateTime createdAt;
    LocalDateTime modifiedAt;
}
