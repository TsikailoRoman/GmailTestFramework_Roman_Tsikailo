package com.epam.model;

public class Message {
    private String recipient;
    private String subject;

    public Message(String recipient, String subject) {
        this.recipient = recipient;
        this.subject = subject + " " + Math.round(Math.random() * 1000);
    }

    public String getRecipient() {
        return recipient;
    }

    public String getSubject() {
        return subject;
    }

    @Override
    public String toString() {
        return String.format("Message{recipient='%s', subject='%s'}", recipient, subject);
    }
}
