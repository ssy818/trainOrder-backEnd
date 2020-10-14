package com.ssy.trainorder.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserPassenger {
    private String user_phone;
    private String person_id;
    private String passenger_phone;

    public UserPassenger(String user_phone, String person_id, String passenger_phone) {
        this.user_phone = user_phone;
        this.person_id = person_id;
        this.passenger_phone = passenger_phone;
    }

    @JsonProperty
    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    @JsonProperty
    public String getPerson_id() {
        return person_id;
    }

    public void setPerson_id(String person_id) {
        this.person_id = person_id;
    }

    @JsonProperty
    public String getPassenger_phone() {
        return passenger_phone;
    }

    public void setPassenger_phone(String passenger_phone) {
        this.passenger_phone = passenger_phone;
    }

    @Override
    public String toString() {
        return "UserPassenger{" +
                "user_phone='" + user_phone + '\'' +
                ", person_id='" + person_id + '\'' +
                ", passenger_phone='" + passenger_phone + '\'' +
                '}';
    }
}
