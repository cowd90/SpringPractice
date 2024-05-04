package com.cowd.identityservice.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;

import com.cowd.identityservice.dto.request.UserCreationRequest;
import com.cowd.identityservice.dto.response.UserResponse;
import com.cowd.identityservice.entity.User;
import com.cowd.identityservice.exception.AppException;
import com.cowd.identityservice.repository.UserRepository;

@SpringBootTest
@TestPropertySource("/test.properties")
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    private UserCreationRequest request;
    private UserResponse response;
    private User user;
    private LocalDate dob;

    @BeforeEach
    void initData() {
        dob = LocalDate.of(2003, 4, 26);

        request = UserCreationRequest.builder()
                .username("scottd980")
                .firstName("Scott")
                .lastName("Nguyen")
                .password("123456123456")
                .dob(dob)
                .build();

        response = UserResponse.builder()
                .id("sdjkzghzg")
                .username("scottd980")
                .firstName("Scott")
                .lastName("Nguyen")
                .dob(dob)
                .build();

        user = User.builder()
                .id("sdjkzghzg")
                .username("scottd980")
                .firstName("Scott")
                .lastName("Nguyen")
                .dob(dob)
                .build();
    }

    @Test
    void createUser_validRequest_success() {
        // GIVEN
        when(userRepository.existsByUsername(anyString())).thenReturn(false);
        when(userRepository.save(any())).thenReturn(user);

        // WHEN
        var response = userService.createUser(request);

        // THEN
        Assertions.assertThat(response.getId()).isEqualTo("sdjkzghzg");
        Assertions.assertThat(response.getUsername()).isEqualTo("scottd980");
    }

    @Test
    void createUser_userExisted_fail() {
        // GIVEN
        when(userRepository.existsByUsername(anyString())).thenReturn(true);

        // WHEN
        var exception = assertThrows(AppException.class, () -> userService.createUser(request));

        Assertions.assertThat(exception.getErrorCode().getCode()).isEqualTo(1002);
    }
}
