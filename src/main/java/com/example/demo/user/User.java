package com.example.demo.user;

import helper.DataHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class User {
    private String name;
    private String email;
    private String pwd;
    private String bio;

    protected DataHelper dataHelper;

    public List<String> errors;

    public User(String name, String email, String pwd, String bio) {
        this.name = name;
        this.email = email;
        this.pwd = pwd;
        this.bio = bio;
        this.errors = new ArrayList<String>();
        this.dataHelper = new DataHelper();
    }

    public boolean validation() {
        this.isName();
        this.isEmail();
        this.isPassword();
        this.isBio();

        return errors.isEmpty();
    }

    protected boolean isEmail() {
        String regexPattern = "/^(.+)@(\\S+)$/";
        boolean res = this.dataHelper.regexValidate(this.email, regexPattern);

        if (!res)
            this.errors.add("Email not valid! Please try again.");

        return res;
    }

    protected boolean isName() {
        String regexPattern = "/^[a-z ,.'-]+$/i";
        boolean res = this.dataHelper.regexValidate(this.name, regexPattern);

        if (!res)
            this.errors.add("Name not valid! Please try again.");

        return res;
    }

    protected boolean isPassword() {
        String regexPattern = "/^.{5}$/";
        boolean res = this.dataHelper.regexValidate(this.name, regexPattern);

        if (!res)
            this.errors.add("Password not valid! Please try again.");

        return res;
    }

    protected boolean isBio() {
        String regexPattern = "/([^\\s]*)/";
        boolean res = this.dataHelper.regexValidate(this.name, regexPattern);

        if (!res)
            this.errors.add("Password not valid! Please try again.");

        return res;
    }
}