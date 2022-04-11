package com.company.model;

public class Email {
    private String email;
    private String emailType;

    public Email(String email) {
        this.email = email;
    }

    public Email(String email, String emailType) {
        this.email = email;
        this.emailType = emailType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailType() {
        return emailType;
    }

    public void setEmailType(String emailType) {
        this.emailType = emailType;
    }

    @Override
    public String toString() {
        return "Email{" +
               "email='" + email + '\'' +
               ", emailType='" + emailType + '\'' +
               '}';
    }
}
