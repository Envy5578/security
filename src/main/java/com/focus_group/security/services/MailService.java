package com.focus_group.security.services;
import com.focus_group.security.enumType.TokenType;
import com.focus_group.security.models.MailInfo;
import com.focus_group.security.tokens.JwtCore;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;


@Service
@PropertySource("application.properties")
@RequiredArgsConstructor
@Log4j2
public class MailService{
    @Value("${spring.mail.username}")
    private String senderEmail;
    private static final Logger LOG = LoggerFactory.getLogger(MailService.class);
    public final JavaMailSender emailSender;
    public final JwtCore jwtCore;

    @Async
    public void sendPasswordResetEmail(String toAddress, String token) throws MessagingException {
        String shortUrl = "http://localhost:8080/api/v1/auth/reset-password-email?resetToken=" + token;
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(senderEmail);
        simpleMailMessage.setTo(toAddress);
        simpleMailMessage.setSubject("Password Reset Request");
        simpleMailMessage.setText("To reset your password, click on the following link: " + shortUrl);
        emailSender.send(simpleMailMessage);
    }

    public ResponseEntity<String> sendEmailToUser(String email) {
        try {
            String token = jwtCore.generateResetToken(email, TokenType.RESET_PASSWORD_EMAIL);
            sendPasswordResetEmail(email, token);
        } catch (MailException mailException) {
            //log.
            LOG.error("Error while sending out email: {}", mailException.getMessage());
            return new ResponseEntity<>("Unable to send email", HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (MessagingException e) {
            LOG.error("Error while sending out email: {}", e.getMessage());
            return new ResponseEntity<>("Unable to send email", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>("Please check your inbox", HttpStatus.OK);
    }

    public void sendVerificationEmail(String to, String verificationToken) throws MessagingException  {
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        try {
            String verificationLink = "http://localhost:8080/api/v1/auth/verify/" + verificationToken;
            helper.setFrom(senderEmail);
            helper.setTo(to);
            helper.setSubject("Account Verification");
            helper.setText("To verify your account, click the following link: " + verificationLink);

            emailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
            // Handle exception
        }
    }

    public ResponseEntity<String> sendEmailVerification(String email) {
        try {
            String token = jwtCore.generateResetToken(email, TokenType.EMAIL_VERIFICATION);
            sendVerificationEmail(email, token);
        } catch (MailException mailException) {
            LOG.error("Error while sending out email: {}", mailException.getMessage());
            return new ResponseEntity<>("Unable to send email", HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (MessagingException e) {
            LOG.error("Error while sending out email: {}", e.getMessage());
            return new ResponseEntity<>("Unable to send email", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Please check your inbox", HttpStatus.OK);
    }


}