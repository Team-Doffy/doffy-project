package Doffy.server.community.dto.board;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardResponseDto implements Serializable {
    private Long boardId;
    private Long userId;
    private String nickname;
    private String title;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private int likeCount;
    private int replyCount;

}
