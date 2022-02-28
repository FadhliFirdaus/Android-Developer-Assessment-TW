package com.example.interviewtesttrinitywizards;

public class ContactsObject {

    private String firstName, lastName, email, phonenNumber;
    private String id;

    public ContactsObject(String firstName, String lastName, String email, String phonenNumber, String id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phonenNumber = phonenNumber;
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenNumber() {
        return phonenNumber;
    }

    public void setPhonenNumber(String phonenNumber) {
        this.phonenNumber = phonenNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
