package Doffy.server.global.exception;


import lombok.Getter;

public enum ExceptionCode {

    //이미 존재하는 아이디(이메일)
    USERNAME_EXISTS(400, "Username already exists"),

    //존재하지 않는 아이디
    USER_NOT_FOUND(404, "User not found"),

    //이미 존재하는 닉네임
    NICKNAME_EXISTS(400, "Nick already exists"),

    // 패스워드 불일치
    PASSWORD_MISMATCH(403, "Password Mismatch");

    @Getter
    private final int status;
    @Getter
    private final String message;

    ExceptionCode(int status, String message){
        this.status = status;
        this.message = message;
    }
}
