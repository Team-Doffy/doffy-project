package Doffy.server.community.dto.comment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class ReplyCommentPostDto implements Serializable {
    private Long replyId;
    private Long userId;
    private String replyCommentBody;
}
