package um.uamserver.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    RESOURCE_NOT_FOUND(-1000, "해당 리소스를 찾을 수 없습니다.", HttpStatus.NOT_FOUND),
    BAD_REQUEST(-1002, "잘못된 접근입니다.", HttpStatus.BAD_REQUEST),
    INTERNAL_SERVER_ERROR(-9999, "서버 에러입니다.", HttpStatus.INTERNAL_SERVER_ERROR);


    final int code;
    final String message;
    final HttpStatus statusCode;
}
