package com.company.model;

import java.util.ArrayList;
import java.util.Objects;

public class User {
    private String name;
    private ArrayList<PhoneNumber> phoneNumbers;
    private String company;
    private ArrayList<Email> emails;

    public User(String name, ArrayList<PhoneNumber> phoneNumbers, String company, ArrayList<Email> emails) {
        this.name = name;
        this.phoneNumbers = phoneNumbers;
        this.company = company;
        this.emails = emails;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(ArrayList<PhoneNumber> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public ArrayList<Email> getEmails() {
        return emails;
    }

    public void setEmails(ArrayList<Email> emails) {
        this.emails = emails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) &&
                Objects.equals(phoneNumbers, user.phoneNumbers) &&
                Objects.equals(company, user.company) &&
                Objects.equals(emails, user.emails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phoneNumbers, company, emails);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", phoneNumbers=" + phoneNumbers +
                ", company='" + company + '\'' +
                ", emails=" + emails +
                '}';
    }
}
