package Doffy.server.community.dto.comment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CommentPostDto {

    private Long userId;

    private String commentBody;
}
