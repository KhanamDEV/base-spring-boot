package com.tkg.MasterSystem.services.impl;

import com.tkg.MasterSystem.services.MailServiceInterface;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class MailService implements MailServiceInterface {

    @Autowired
    Environment environment;
    @Autowired
    private JavaMailSender emailSender;

    @Override
    public boolean send(String subject, String body, String recipient) {
        try {
            MimeMessage message = this.emailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
            message.setContent(body, "text/html");
            helper.setTo(recipient);
            helper.setFrom(Objects.requireNonNull(environment.getProperty("spring.mail.from")), Objects.requireNonNull(environment.getProperty("spring.mail.personal")));
            helper.setSubject(subject);
            this.emailSender.send(message);
            return true;
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return false;
        }
    }
}
