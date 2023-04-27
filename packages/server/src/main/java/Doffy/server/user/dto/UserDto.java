package Doffy.server.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor
//@NoArgsConstructor
public class UserDto {

    //로그인
    @Getter
    @Builder
    @AllArgsConstructor
    public static class SignIn{
        String username;
        String password;
    }

    //회원가입
    @Getter
    @Builder
    @AllArgsConstructor
    public static class SignUp{
        @Email(message = "올바른 이메일이 아닙니다.")
        @NotBlank(message = "이메일은 공백이 아니여야 합니다.")
        String username;
        @NotBlank(message = "비밀번호는 공백이 아니여야 합니다.")
        String password;
        @NotBlank(message = "닉네임은 공백이 아니여야 합니다.")
        String nickname;
        boolean terms;
    }

}
