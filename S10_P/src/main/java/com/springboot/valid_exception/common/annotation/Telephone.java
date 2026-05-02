package com.springboot.valid_exception.common.annotation;

import jakarta.validation.Constraint;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = TelephoneValidator.class)
public @interface Telephone {
    String message() default "전화번호 형식이 일치하지 않습니다.";
    Class[] groups() default {};
    Class[] payload() default {};
}

// @Target
// - 이 어노테이션을 어디서 선언할 수 있는지 정의하는데 사용
// - FIELD: 필드에 선언 가능

// @Retention
// - 실제로 적용되고 유지되는 범위
// - RUNTIME: 컴파일 이후에도 JVM에 의해 계속 참조
// - CLASS: 클래스를 참조할 때까지 유지됨
// - SOURCE: 컴파일 전까지만 유지됨. 컴파일 이후 사라짐

// @Constraint
// - TelephoneValidator랑 매핑
// - message(): 유효성 검사가 실패할 경우 반환되는 메시지를 의미
// - groups(): 유효성 검사를 사용하는 그룹으로 설정
// - payload(): 사용자가 추가 정보를 위해 전달하는 값
