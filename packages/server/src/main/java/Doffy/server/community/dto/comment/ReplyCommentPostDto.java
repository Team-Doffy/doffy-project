package Doffy.server.community.dto.comment;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReplyCommentPostDto implements Serializable {
    private Long boardId;
    private Long replyId;
    private Long userId;
    private String replyCommentBody;
}
