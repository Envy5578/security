package com.focus_group.security.services;

import com.focus_group.security.repository.EmailRepository;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;


@Service
@PropertySource("application.properties")
public class MailService implements EmailRepository {

    @Autowired
    public JavaMailSender emailSender;

    @Override
    public void sendSimpleEmail(String toAddress, String subject, String message) {

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(toAddress);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(message);
        emailSender.send(simpleMailMessage);
    }

    @Override
    public void sendEmailWithAttachment(String toAddress, String subject, String message, String attachment) throws MessagingException, FileNotFoundException {

        MimeMessage mimeMessage = emailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);
        messageHelper.setTo(toAddress);
        messageHelper.setSubject(subject);
        messageHelper.setText(message);
        FileSystemResource file= new FileSystemResource(ResourceUtils.getFile(attachment));
        messageHelper.addAttachment("Purchase Order", file);
        emailSender.send(mimeMessage);
    }

//    @Autowired
//    private JavaMailSender javaMailSender;
//
//    public void sendEmail(String toEmail, String subject, String body) {
//
////        try {
////            SimpleMailMessage message = new SimpleMailMessage();
////            message.setFrom("arjungautam8877@gmail.com");
////            message.setTo(mailInfo.getRecipientEmail());
////            message.setSubject(mailInfo.getEmailType().name());
////            message.setText(mailInfo.getContext().toString());
////            javaMailSender.send(message);
////            System.out.println("Email Sent Successfully...");
////        } catch (MailException e) {
////            e.printStackTrace();
////        }
//        try {
//            SimpleMailMessage message = new SimpleMailMessage();
//            message.setTo(toEmail);
//            message.setSubject(subject);
//            message.setText(body);
//            javaMailSender.send(message);
//            System.out.println("Email Sent Successfully...");
//        } catch (MailException e) {
//            e.printStackTrace();
//        }
//    }

}