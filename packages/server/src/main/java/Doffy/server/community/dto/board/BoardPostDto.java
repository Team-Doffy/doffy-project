package Doffy.server.community.dto.board;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BoardPostDto {

    private long userId;

    private Long boardId;

    private Long commentId;

    private String title;

    private String boardBody;

}
