package com.myorganisation.mail.service;

import com.myorganisation.mail.dto.UserCreatedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MailConsumer {

    @Autowired
    private EmailService emailService;

    @KafkaListener(
            topics = "mail-topic",
            groupId = "mail-group")
    public void consume(UserCreatedEvent event){

        emailService.sendEmail(
                event.getEmail(),
                "Welcome",
                "Welcome " + event.getName());
    }
}