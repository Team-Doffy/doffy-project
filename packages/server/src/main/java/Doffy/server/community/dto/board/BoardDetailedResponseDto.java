package Doffy.server.community.dto.board;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardDetailedResponseDto {

    private Long boardId;
    private Long userId;
    private String nickname;
    private String title;
    private String boardBody;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

//    private List<CommentResponseDto> comments;
//    private List<ReplyResponseDto> replies;
}
