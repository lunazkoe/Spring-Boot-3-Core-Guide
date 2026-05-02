package com.springboot.valid_exception.controller;

import com.springboot.valid_exception.data.dto.ValidRequestDto;
import com.springboot.valid_exception.data.dto.ValidatedRequestDto;
import com.springboot.valid_exception.group.ValidationGroup1;
import com.springboot.valid_exception.group.ValidationGroup2;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/validation")
public class ValidationController {

    @PostMapping("/valid")
    public ResponseEntity<String> checkValidationByValid(
            @Valid @RequestBody ValidRequestDto validRequestDto
            // - @Valid를 지정해야 DTO 객체의 유효성 검사를 수행할 수 있음
    ) {
        log.info("validationRequestDto={}", validRequestDto);
        return ResponseEntity.status(HttpStatus.OK).body(validRequestDto.toString());
    }

    @PostMapping("/validated")
    public ResponseEntity<String> checkValidationByValidated(
            @Validated @RequestBody ValidatedRequestDto validatedRequestDto
            // - @Valid를 지정해야 DTO 객체의 유효성 검사를 수행할 수 있음
    ) {
        log.info("validationRequestDto={}", validatedRequestDto);
        return ResponseEntity.status(HttpStatus.OK).body(validatedRequestDto.toString());
    }

    @PostMapping("/validated/group1")
    public ResponseEntity<String> checkValidationGroup1(
            @Validated(ValidationGroup1.class) @RequestBody ValidatedRequestDto validatedRequestDto
    ) {
        log.info("validatedRequestDto={}", validatedRequestDto);
        return ResponseEntity.status(HttpStatus.OK).body(validatedRequestDto.toString());
    }

    @PostMapping("/validated/group2")
    public ResponseEntity<String> checkValidationGroup2(
            @Validated(ValidationGroup2.class) @RequestBody ValidatedRequestDto validatedRequestDto
    ) {
        log.info("validatedRequestDto={}", validatedRequestDto);
        return ResponseEntity.status(HttpStatus.OK).body(validatedRequestDto.toString());
    }

    @PostMapping("/validated/all-group")
    public ResponseEntity<String> checkValidation3(
            @Validated({ValidationGroup1.class, ValidationGroup2.class}) @RequestBody ValidatedRequestDto validatedRequestDto
    ) {
        log.info("validatedRequestDto={}", validatedRequestDto);
        return ResponseEntity.status(HttpStatus.OK).body(validatedRequestDto.toString());
    }
}

// @Validated의 Group
// - 특정 그룹을 설정하지 않은 경우에는 groups가 설정되지 않은 필드에 대해서만 유효성 검사를 수행
// - 특정 그룹을 설정한 경우에는 지정된 그룹으로 설정된 필드에 대해서만 유효성 검사를 수행
// - 주의: 제대로 설계하지 않으면 비효율저깅거나 생산적이지 못한 안티 패턴이 될 수 있음

// - 사용 예:
//      - DTO를 재사용할 때 주로 사용
//          - id는 생성 시점에서 필요 없음
//      - 주의: 그냥 따로 만드는게 더 좋을 때가 많음