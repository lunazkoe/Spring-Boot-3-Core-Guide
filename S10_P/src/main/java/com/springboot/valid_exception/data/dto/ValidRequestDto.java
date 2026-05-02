package com.springboot.valid_exception.data.dto;

import com.springboot.valid_exception.group.ValidationGroup1;
import com.springboot.valid_exception.group.ValidationGroup2;
import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ValidRequestDto {

    @NotBlank
    String name;

    @Email
    String email;

    @Pattern(regexp = "01(?:0|1|[6-9])[.-]?(\\d{3}|\\d{4})[.-]?(\\d{4})$")
    String phoneNumber;

    @Min(value = 20)
    @Max(value = 40)
    int age;

    @Size(min = 0, max = 40)
    String description;

    @Positive
    int count;

    @AssertTrue
    boolean booleanCheck;
}

// 문자열 검증
// - @Null: null만 허용
// - @NotNull: null을 허용하지 않음 / "", " "은 허용
// - @NotEmpty: null, ""을 허용하지 않음 / " "은 허용
// - @NotBlank: null, "", " "을 허용하지 않음

// Boolean 검증
// - @AssertTrue: true인지 검증 / null은 체크하지 않음
// - @AssertFalse: false인지 검증 / null은 체크하지 않음
