package Doffy.server.like.dto.comment;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LikeBoardCommentDto {
    private long userId;
    private boolean commentLiked;
}
