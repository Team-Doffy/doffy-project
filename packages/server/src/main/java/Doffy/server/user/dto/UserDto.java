package Doffy.server.user.dto;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@AllArgsConstructor
//@NoArgsConstructor
public class UserDto {

    //로그인
    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class SignIn{
        String username;
        String password;
    }

    //회원가입
    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class SignUp{
        @Email(message = "올바른 이메일이 아닙니다.")
        @NotBlank(message = "이메일은 공백이 아니여야 합니다.")
        String username;
        @NotBlank
        @Pattern(regexp = "^[a-zA-Z0-9!@#$%^&*()]*$", message = "비밀번호는 영문 대소문자와 키패드 1~0까지의 특수문자만 가능합니다.")
        @Size(min = 8, max = 20, message = "비밀번호는 8~20자 사이여야 합니다.")
        String password;
        @NotBlank(message = "이름은 공백이 아니여야 합니다.")
        String name;
        @NotBlank(message = "닉네임은 공백이 아니여야 합니다.")
        String nickname;
//        boolean terms;

//         public SignUp(String username, String password, String name, String nickname){
//             this.username = username;
//             this.password = password;
//             this.name = name;
//             this.nickname = nickname;
//         }
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class PatchNickname{

        String username;

        @NotBlank
        @Pattern(regexp = "^[a-zA-Z0-9!@#$%^&*()]*$", message = "비밀번호는 영문 대소문자와 키패드 1~0까지의 특수문자만 가능합니다.")
        @Size(min = 8, max = 20, message = "비밀번호는 8~20자 사이여야 합니다.")
        String password;


        @NotBlank(message = "닉네임은 공백이 아니여야 합니다.")
        String nickname;

        public void setUsername(String username) {
            this.username = username;
        }
    }


    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class DuplicationCheckUsername{
        @Email(message = "올바른 이메일이 아닙니다.")
        @NotBlank(message = "이메일은 공백이 아니여야 합니다.")
        String username;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class DuplicationCheckNickname{
        @NotBlank(message = "닉네임은 공백이 아니여야 합니다.")
        String nickname;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    public static class DuplicationCheckUsernameResponse{
        @Setter
        boolean usernameCheck;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class DuplicationCheckNicknameResponse{
        @Setter
        boolean nicknameCheck;

    }

    @Getter
    @Builder
    @AllArgsConstructor
    public static class GetUserResponse{
        String username;
        String name;
        String nickname;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CheckPassword{
        String password;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CheckPasswordResponse{
        @Setter
        boolean checkPassword;
    }
}
