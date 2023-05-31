package Doffy.server.user.entity;

import Doffy.server.community.entity.Board;
import Doffy.server.community.entity.BoardComment;
import Doffy.server.community.entity.Reply;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Data
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column
    @Email(message = "올바른 이메일이 아닙니다.")
    @NotBlank(message = "이메일은 공백이 아니여야 합니다.")
    private String username;
    @Column
    private String password;
    @Column
    private String name;
    @Column
    private String nickname;

    @Column
    private boolean terms;

    @Column
    private int score;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roles = new ArrayList<String>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Board> boards;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<BoardComment> boardComments;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Reply> replies;

    public User(String username, String name, String nickname){
        this.username = username;
        this.name = name;
        this.nickname = nickname;
    }
    public User(String username, String password, String name, String nickname) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.nickname = nickname;
    }
}
