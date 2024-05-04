package com.cowd.identityservice.dto.request;

import java.time.LocalDate;

import jakarta.validation.constraints.Size;

import com.cowd.identityservice.validator.DobConstraint;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserCreationRequest {
    @Size(min = 8, message = "USERNAME_INVALID")
    String username;

    @Size(min = 12, message = "INVALID_PASSWORD")
    String password;

    String firstName;

    String lastName;

    @DobConstraint(min = 16, message = "INVALID_DOB")
    LocalDate dob;
}
