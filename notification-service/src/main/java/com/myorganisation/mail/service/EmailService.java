package com.myorganisation.mail.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendEmail(String mailTo, String mailSubject, String mailMessage) {
        SimpleMailMessage smm = new SimpleMailMessage();

        smm.setTo(mailTo);
        smm.setSubject(mailSubject);
        smm.setText(mailMessage);

        mailSender.send(smm);
    }
}
