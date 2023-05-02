package Doffy.server.community.dto.reply;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ReplyPostDto {
    private Long boardId;
    private Long userId;
    private String replyBody;
}