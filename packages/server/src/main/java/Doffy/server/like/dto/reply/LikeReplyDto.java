package Doffy.server.like.dto.reply;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LikeReplyDto {
    private long userId;
    private boolean liked;
}
