package com.cowd.identityservice.dto.response;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.ElementCollection;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponse {
    String id;
    String username;
    String password;
    String firstName;
    String lastName;
    LocalDate dob;

    @ElementCollection
    Set<RoleResponse> roles;
}
