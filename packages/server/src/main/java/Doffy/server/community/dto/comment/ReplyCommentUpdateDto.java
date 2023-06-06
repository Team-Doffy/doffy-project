package Doffy.server.community.dto.comment;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReplyCommentUpdateDto {
    private String replyCommentBody;
}
