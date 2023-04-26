package Doffy.server.community.dto.comment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class CommentPostDto implements Serializable {
    private long parentId;
    private String  commentType;
    private String commentBody;
}
