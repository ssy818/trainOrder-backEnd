package com.ssy.trainorder.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Passenger {
    private String person_id;
    private String real_name;

    public Passenger(String person_id, String real_name) {
        this.person_id = person_id;
        this.real_name = real_name;
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
}
