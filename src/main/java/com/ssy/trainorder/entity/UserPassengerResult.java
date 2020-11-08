package com.ssy.trainorder.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserPassengerResult {
    private String person_id;
    private String real_name;
    private String passenger_phone;

    public UserPassengerResult(String person_id, String real_name, String passenger_phone) {
        this.person_id = person_id;
        this.real_name = real_name;
        this.passenger_phone = passenger_phone;
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

    @JsonProperty("passenger_phone")
    public String getPassenger_phone() {
        return passenger_phone;
    }

    public void setPassenger_phone(String passenger_phone) {
        this.passenger_phone = passenger_phone;
    }
}
