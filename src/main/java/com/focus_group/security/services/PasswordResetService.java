package com.focus_group.security.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class PasswordResetService {
//    private final UserRepository userRepository;
//    private final MailService mailService;
//
//    public void sendPasswordResetEmail(@NotNull ResetPasswordRequest request) {
//        UserEntity userEntity = userRepository.findByEmail(request.getEmail())
//                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
//        MailInfo mailInfo = MailInfo.builder()
//                .recipientEmail(userEntity.getEmail())
//                .emailType(TokenType.RESET_PASSWORD_EMAIL)
//                .build();
//        mailService.sendEmail(mailInfo);
//    }

}

