package com.myorganisation.mail.dto;

import lombok.Data;

@Data
public class MailRequestDto {
    private String mailTo;
    private String mailSubject;
    private String mailMessage;
}
