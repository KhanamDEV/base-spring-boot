package com.tkg.MasterSystem.services;

public interface MailServiceInterface {
    public boolean send(String subject, String body, String recipient);
}
