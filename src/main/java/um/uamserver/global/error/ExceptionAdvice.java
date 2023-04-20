package um.uamserver.global.error;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import um.uamserver.global.error.exception.CBadRequestException;
import um.uamserver.global.error.exception.CResourceNotFoundException;

@Slf4j
@RequiredArgsConstructor
@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ErrorResponseDto> handle(Exception e) {
        ErrorCode errorCode = ErrorCode.INTERNAL_SERVER_ERROR;
        e.printStackTrace();
        return new ResponseEntity<>(new ErrorResponseDto(errorCode), errorCode.getStatusCode());
    }

    @ExceptionHandler(CResourceNotFoundException.class)
    protected ResponseEntity<ErrorResponseDto> handle(CResourceNotFoundException e) {
        ErrorCode errorCode = e.getErrorCode();
        e.printStackTrace();
        return new ResponseEntity<>(new ErrorResponseDto(errorCode), errorCode.getStatusCode());
    }

    @ExceptionHandler(CBadRequestException.class)
    protected ResponseEntity<ErrorResponseDto> handle(CBadRequestException e) {
        ErrorCode errorCode = e.getErrorCode();
        String message = e.getMessage();
        e.printStackTrace();
        return new ResponseEntity<>(new ErrorResponseDto(errorCode, message), errorCode.getStatusCode());
    }
}
