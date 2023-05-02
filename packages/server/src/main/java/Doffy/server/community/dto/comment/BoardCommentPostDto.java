package Doffy.server.community.dto.comment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class BoardCommentPostDto implements Serializable {
    private long boardId;
    private Long userId;
    private String boardCommentBody;
}
