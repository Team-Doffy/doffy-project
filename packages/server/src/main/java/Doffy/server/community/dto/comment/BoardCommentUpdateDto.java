package Doffy.server.community.dto.comment;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardCommentUpdateDto {
    private String boardCommentBody;
}
