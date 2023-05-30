package Doffy.server.global.exception;


import lombok.Getter;

public enum ExceptionCode {

    //이미 존재하는 게시판
    BOARD_EXISTS(409, "Board already exists"),

    //존재 하지 않는 게시판
    BOARD_NOT_FOUND(404, "Board not found"),

    //이미 존재하는 답글
    REPLY_EXISTS(409, "Reply already exists"),

    //이미 존재하는 답글
    REPLY_NOT_FOUND(404, "Reply not found"),

    //이미 존재하는 덧글
    COMMENT_EXISTS(409, "Comment already exists"),

    //이미 존재하는 덧글
    COMMENT_NOT_FOUND(404, "Comment not found"),

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
