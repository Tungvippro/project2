package org.example.models;

public class User {
    private int id;
    private String emailOrPhone;
    private String password;

    public User(int id, String emailOrPhone, String password) {
        this.id = id;
        this.emailOrPhone = emailOrPhone;
        this.password = password;
    }
    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmailOrPhone() {
        return emailOrPhone;
    }

    public void setEmailOrPhone(String emailOrPhone) {
        this.emailOrPhone = emailOrPhone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", emailOrPhone='" + emailOrPhone + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
