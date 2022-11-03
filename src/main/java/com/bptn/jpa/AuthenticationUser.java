package com.bptn.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "\"AuthenticationUser\"")
public class AuthenticationUser {

    @Id
    @Column(name = "\"usernameKey\"")
    String usernameKey;

    @Column(name = "\"phoneNumber\"")
    String phoneNumber;

    @Column(name = "\"userPassword\"")
    String userPassword;

    @Column(name = "\"securityQuestion1\"")
    String securityQuestion1;

    @Column(name = "\"securityQuestion2\"")
    String securityQuestion2;

    @Column(name = "\"securityQuestion3\"")
    String securityQuestion3;

    @Column(name = "\"securityAnswer1\"")
    String securityAnswer1;

    @Column(name = "\"securityAnswer2\"")
    String securityAnswer2;

    @Column(name = "\"securityAnswer3\"")
    String securityAnswer3;

    public AuthenticationUser() {
        super();
    }

    public AuthenticationUser(String usernameKey, String phoneNumber, String userPassword, String securityQuestion1,
            String securityQuestion2, String securityQuestion3, String securityAnswer1, String securityAnswer2,
            String securityAnswer3) {
        this.usernameKey = usernameKey;
        this.phoneNumber = phoneNumber;
        this.userPassword = userPassword;
        this.securityQuestion1 = securityQuestion1;
        this.securityQuestion2 = securityQuestion2;
        this.securityQuestion3 = securityQuestion3;
        this.securityAnswer1 = securityAnswer1;
        this.securityAnswer2 = securityAnswer2;
        this.securityAnswer3 = securityAnswer3;
    }

    public String getUsernameKey() {
        return usernameKey;
    }

    public void setUsernameKey(String usernameKey) {
        this.usernameKey = usernameKey;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getSecurityQuestion1() {
        return securityQuestion1;
    }

    public void setSecurityQuestion1(String securityQuestion1) {
        this.securityQuestion1 = securityQuestion1;
    }

    public String getSecurityQuestion2() {
        return securityQuestion2;
    }

    public void setSecurityQuestion2(String securityQuestion2) {
        this.securityQuestion2 = securityQuestion2;
    }

    public String getSecurityQuestion3() {
        return securityQuestion3;
    }

    public void setSecurityQuestion3(String securityQuestion3) {
        this.securityQuestion3 = securityQuestion3;
    }

    public String getSecurityAnswer1() {
        return securityAnswer1;
    }

    public void setSecurityAnswer1(String securityAnswer1) {
        this.securityAnswer1 = securityAnswer1;
    }

    public String getSecurityAnswer2() {
        return securityAnswer2;
    }

    public void setSecurityAnswer2(String securityAnswer2) {
        this.securityAnswer2 = securityAnswer2;
    }

    public String getSecurityAnswer3() {
        return securityAnswer3;
    }

    public void setSecurityAnswer3(String securityAnswer3) {
        this.securityAnswer3 = securityAnswer3;
    }

    @Override
    public String toString() {
        return "AuthenticationUser [usernameKey=" + usernameKey + ", phoneNumber=" + phoneNumber + ", userPassword="
                + userPassword + ", securityQuestion1=" + securityQuestion1 + ", securityQuestion2=" + securityQuestion2
                + ", securityQuestion3=" + securityQuestion3 + ", securityAnswer1=" + securityAnswer1
                + ", securityAnswer2=" + securityAnswer2 + ", securityAnswer3=" + securityAnswer3 + "]";
    }

}
