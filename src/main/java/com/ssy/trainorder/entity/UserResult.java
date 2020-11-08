package com.ssy.trainorder.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserResult {
    private String user_phone;
    private String user_name;
    private String person_id;
    private String real_name;
    private String email;

    public UserResult(String user_phone, String user_name, String person_id, String real_name, String email) {
        this.user_phone = user_phone;
        this.user_name = user_name;
        this.person_id = person_id;
        this.real_name = real_name;
        this.email = email;
    }

    @JsonProperty("user_phone")
    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    @JsonProperty("user_name")
    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    @JsonProperty("person_id")
    public String getPerson_id() {
        return person_id;
    }

    public void setPerson_id(String person_id) {
        this.person_id = person_id;
    }

    @JsonProperty("real_name")
    public String getReal_name() {
        return real_name;
    }

    public void setReal_name(String real_name) {
        this.real_name = real_name;
    }

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
