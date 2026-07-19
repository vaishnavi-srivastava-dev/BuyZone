package com.myorganisation.mail.controller;

import com.myorganisation.mail.dto.MailRequestDto;
import com.myorganisation.mail.service.EmailService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/mails")
public class MailController {

    private final EmailService emailService;

    public MailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping
    public String sendMail(@RequestBody MailRequestDto mailRequestDto) {
        emailService.sendEmail(mailRequestDto.getMailTo(), mailRequestDto.getMailSubject(), mailRequestDto.getMailMessage());

        return "Email sent";
    }
}
