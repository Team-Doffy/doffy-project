package Doffy.server.community.dto.board;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardPostDto {

    private long userId;

//    private Long boardId;

    private String title;

    private String boardBody;

}
