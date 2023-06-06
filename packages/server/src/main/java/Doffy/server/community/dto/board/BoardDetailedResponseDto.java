package Doffy.server.community.dto.board;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class BoardDetailedResponseDto {

    private Long boardId;
    private Long userId;
    private String nickname;
    private String title;
    private String boardBody;
    private int likeCount;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}
