package com.springboot.valid_exception.common.exception;

import com.springboot.valid_exception.common.Constants;
import org.springframework.http.HttpStatus;

// CustomException에는 어떤 클래스의 예외가 발생했는지 Enum
// httpStatus를 넣어서 보통 구성함

public class CustomException extends Exception {

    private Constants.ExceptionClass exceptionClass;
    private HttpStatus httpStatus;

    public CustomException(Constants.ExceptionClass exceptionClass, HttpStatus httpStatus, String message) {
        super(exceptionClass.toString() + message);
        this.exceptionClass = exceptionClass;
        this.httpStatus = httpStatus;
    }

    public Constants.ExceptionClass getExceptionClass() {
        return exceptionClass;
    }

    public int getHttpStatusCode() {
        return httpStatus.value();
    }

    public String getHttpStatusType() {
        return httpStatus.getReasonPhrase();
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
