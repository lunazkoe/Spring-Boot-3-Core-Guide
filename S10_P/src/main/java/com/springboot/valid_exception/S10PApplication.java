package com.springboot.valid_exception;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class S10PApplication {

    public static void main(String[] args) {
        SpringApplication.run(S10PApplication.class, args);
    }

}

// 10.3.3 스프링 부트 유효성 검사
// - 유효성 검사는 각 계층으로 데이터가 넘어오는 시점에 해당 데이터에 대한 검사를 실시
// - 보통 DTO 객체를 대상으로 수행하는 것이 일반적
