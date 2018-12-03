package com.wizeline.testingframework.web.data;

import com.wizeline.testingframework.validation.annotation.ValidPassword;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserData {

    @NotNull
    @Size(min = 1, message = "firstName size")
    private String firstName;

    @NotNull
    @Size(min = 1, message = "lastName size")
    private String lastName;

    @NotNull
    @ValidPassword
    private String password;

    @NotNull
    private String confirmPassword;

    @NotNull
    private String email;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
