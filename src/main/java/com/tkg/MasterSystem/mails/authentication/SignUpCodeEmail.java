package com.tkg.MasterSystem.mails.authentication;

import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.MailMessage;
import org.springframework.mail.SimpleMailMessage;

public class SignUpCodeEmail {
    private String recipient;

    private String code;

    public SignUpCodeEmail(String recipient, String code) {
        this.recipient = recipient;
        this.code = code;
    }

    public int send(){
        try{
            MailMessage mailMessage = new SimpleMailMessage();
//            mailMessage.setFrom();
            return  1;
        } catch (Exception exception){
            System.out.println(exception.getMessage());
            return 0;
        }
    }
}
