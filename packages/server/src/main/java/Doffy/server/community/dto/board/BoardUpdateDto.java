package Doffy.server.community.dto.board;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardUpdateDto {
    private String title;
    private String boardBody;
}
