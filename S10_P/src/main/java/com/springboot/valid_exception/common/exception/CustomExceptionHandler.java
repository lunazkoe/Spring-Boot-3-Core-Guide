package com.springboot.valid_exception.common.exception;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@Slf4j
//@RestControllerAdvice
@RestControllerAdvice(basePackages = "com.springboot.valid_exception")
// - 특정 패키지에서 발생하는 예외만 처리하도록 할 수 있음
public class CustomExceptionHandler {

    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<Map<String, String>> handlerException(RuntimeException e, HttpServletRequest request) {
        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.setContentType(MediaType.APPLICATION_JSON);
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        log.error("Advice 내 handlerException 호출 {}, {}",request.getRequestURI(), e.getMessage());

        Map<String, String> map = new HashMap<>();
        map.put("error type", httpStatus.getReasonPhrase());
        map.put("code", "400");
        map.put("message", e.getMessage());

        return new ResponseEntity<>(map, responseHeader, httpStatus);
        // - body, header, status
    }

    @ExceptionHandler(value = CustomException.class)
    public ResponseEntity<Map<String, String>> handlerException(CustomException e, HttpServletRequest request) {
        HttpHeaders responseHeader = new HttpHeaders();
        log.error("Advice 내 handlerException 호출 {}, {}",request.getRequestURI(), e.getMessage());

        Map<String, String> map = new HashMap<>();
        map.put("error type", e.getHttpStatusType());
        map.put("code", Integer.toString(e.getHttpStatusCode()));
        map.put("message", e.getMessage());

        return new ResponseEntity<>(map, responseHeader, e.getHttpStatus());
    }
}
