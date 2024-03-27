package com.focus_group.security.controllers;

import com.focus_group.security.services.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/email")
public class EmailController {

    private final MailService emailService;

    @GetMapping(value = "/simple-email/{user-email}")
    public @ResponseBody // возвращаемое значение должно быть сериализовано непосредственно в тело HTTP ответа.
    ResponseEntity<String> sendSimpleEmail(@PathVariable("user-email") String email) {
        return emailService.sendEmail(email);
    }
}
