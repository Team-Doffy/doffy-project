package Doffy.server.community.dto.board;

import Doffy.server.community.dto.comment.CommentResponseDto;
import Doffy.server.community.dto.reply.ReplyResponseDto;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardResponseDto implements Serializable {
    private Long boardId;
    private int userId;
    private String nickname;
    private String title;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private int likeCount;
    private int replyCount;

}
