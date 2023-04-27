package Doffy.server.community.dto.board;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardPostDto implements Serializable {

    private int userId;

    private String title;

    private String boardBody;

}
