package com.alpengotter.dental_service_bank.service;

import com.alpengotter.dental_service_bank.domain.dto.AdminRegisterDto;
import com.alpengotter.dental_service_bank.domain.dto.JwtRequestDto;
import com.alpengotter.dental_service_bank.domain.dto.JwtResponseDto;
import com.alpengotter.dental_service_bank.domain.entity.UserEntity;
import com.alpengotter.dental_service_bank.domain.repository.UserRepository;
import com.alpengotter.dental_service_bank.handler.ErrorType;
import com.alpengotter.dental_service_bank.handler.exception.LemonBankException;
import com.alpengotter.dental_service_bank.utils.JwtUtils;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;

    @Transactional
    public UserEntity registerNewUser(AdminRegisterDto adminRegisterDto) {
        UserEntity newUser = new UserEntity();
        newUser.setEmail(adminRegisterDto.getEmail());
        newUser.setPassword(passwordEncoder.encode(adminRegisterDto.getPassword()));
        return userRepository.save(newUser);
    }

    @Transactional
    public JwtResponseDto getNewUserTokenFromLogin(JwtRequestDto requestDto) {

        UserEntity user = userRepository.findByEmailIgnoreCase(requestDto.getEmail())
            .orElseThrow(() -> new LemonBankException(ErrorType.USER_NOT_FOUND));
        if (Objects.isNull(requestDto.getPassword()) || !requestDto.getPassword().equals(user.getPassword())) {
            throw new LemonBankException(ErrorType.INCORRECT_PASSWORD);
        }
        if (!user.getUserRole().equalsIgnoreCase("ADMIN")) {
            throw new LemonBankException(ErrorType.ACCESS_DENIED);
        }
        return JwtResponseDto.builder()
            .accessToken(jwtUtils.generateToken(user.getId()))
            .build();

    }

}
