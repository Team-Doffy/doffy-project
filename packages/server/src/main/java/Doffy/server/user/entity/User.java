package Doffy.server.user.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column
    @Email(message = "올바른 이메일이 아닙니다.")
    @NotBlank(message = "이메일은 공백이 아니여야 합니다.")
    private String username;

    @Column
    private String password;

    @Column
    private String nickname;

    @Column
    private boolean terms;

    @Column
    private int score;
}
