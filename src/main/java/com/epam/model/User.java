package com.epam.model;

public class User {
    private String email;
    private String password;
    private Message message;

    public User(String email, String password, Message message) {
        this.email = email;
        this.password = password;
        this.message = message;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Message getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return String.format("User{email='%s', password='%s', message=%s}",
                email, password, message.toString());
    }
}
