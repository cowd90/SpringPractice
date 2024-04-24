package com.cowd.identifyservice.service;

import com.cowd.identifyservice.dto.request.AuthenticationRequest;
import com.cowd.identifyservice.exception.AppException;
import com.cowd.identifyservice.exception.ErrorCode;
import com.cowd.identifyservice.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationService {

    UserRepository userRepository;

    public boolean authenticate(AuthenticationRequest request) {
        var user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTS));
        PasswordEncoder encoder = new BCryptPasswordEncoder(10);
        return encoder.matches(request.getPassword(), user.getPassword());
    }
}
