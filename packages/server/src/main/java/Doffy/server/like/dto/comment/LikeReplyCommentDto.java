package Doffy.server.like.dto.comment;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LikeReplyCommentDto {
    private long userId;
    private boolean commentLiked;
}
