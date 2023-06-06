package Doffy.server.like.dto.board;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LikeBoardDto {
    private long userId;
    private boolean liked;
}
