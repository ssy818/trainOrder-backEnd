package com.ssy.trainorder.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DirectTicketDetail {
    private String start_date;
    private String train_no;
    private String start_station_name;
    private String end_station_name;
    private String start_time;
    private String end_time;
    private String last_time;
    private String premier_seat_remaining;
    private String first_seat_remaining;
    private String second_seat_remaining;
    private String soft_sleeper_remaining;
    private String hard_sleeper_remaining;
    private String hard_seat_remaining;
    private String premier_seat_price;
    private String first_seat_price;
    private String second_seat_price;
    private String soft_sleeper_price;
    private String hard_sleeper_price;
    private String hard_seat_price;

    public DirectTicketDetail(String start_date, String train_no, String start_station_name, String end_station_name, String start_time, String end_time, String last_time, String premier_seat_remaining, String first_seat_remaining, String second_seat_remaining, String soft_sleeper_remaining, String hard_sleeper_remaining, String hard_seat_remaining, String premier_seat_price, String first_seat_price, String second_seat_price, String soft_sleeper_price, String hard_sleeper_price, String hard_seat_price) {
        this.start_date = start_date;
        this.train_no = train_no;
        this.start_station_name = start_station_name;
        this.end_station_name = end_station_name;
        this.start_time = start_time;
        this.end_time = end_time;
        this.last_time = last_time;
        this.premier_seat_remaining = premier_seat_remaining;
        this.first_seat_remaining = first_seat_remaining;
        this.second_seat_remaining = second_seat_remaining;
        this.soft_sleeper_remaining = soft_sleeper_remaining;
        this.hard_sleeper_remaining = hard_sleeper_remaining;
        this.hard_seat_remaining = hard_seat_remaining;
        this.premier_seat_price = premier_seat_price;
        this.first_seat_price = first_seat_price;
        this.second_seat_price = second_seat_price;
        this.soft_sleeper_price = soft_sleeper_price;
        this.hard_sleeper_price = hard_sleeper_price;
        this.hard_seat_price = hard_seat_price;
    }

    @JsonProperty("start_date")
    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    @JsonProperty("train_no")
    public String getTrain_no() {
        return train_no;
    }

    public void setTrain_no(String train_no) {
        this.train_no = train_no;
    }

    @JsonProperty("start_station_name")
    public String getStart_station_name() {
        return start_station_name;
    }

    public void setStart_station_name(String start_station_name) {
        this.start_station_name = start_station_name;
    }

    @JsonProperty("end_station_name")
    public String getEnd_station_name() {
        return end_station_name;
    }

    public void setEnd_station_name(String end_station_name) {
        this.end_station_name = end_station_name;
    }

    @JsonProperty("start_time")
    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    @JsonProperty("end_time")
    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    @JsonProperty("last_time")
    public String getLast_time() {
        return last_time;
    }

    public void setLast_time(String last_time) {
        this.last_time = last_time;
    }

    @JsonProperty("premier_seat_remaining")
    public String getPremier_seat_remaining() {
        return premier_seat_remaining;
    }

    public void setPremier_seat_remaining(String premier_seat_remaining) {
        this.premier_seat_remaining = premier_seat_remaining;
    }

    @JsonProperty("first_seat_remaining")
    public String getFirst_seat_remaining() {
        return first_seat_remaining;
    }

    public void setFirst_seat_remaining(String first_seat_remaining) {
        this.first_seat_remaining = first_seat_remaining;
    }

    @JsonProperty("second_seat_remaining")
    public String getSecond_seat_remaining() {
        return second_seat_remaining;
    }

    public void setSecond_seat_remaining(String second_seat_remaining) {
        this.second_seat_remaining = second_seat_remaining;
    }

    @JsonProperty("soft_sleeper_remaining")
    public String getSoft_sleeper_remaining() {
        return soft_sleeper_remaining;
    }

    public void setSoft_sleeper_remaining(String soft_sleeper_remaining) {
        this.soft_sleeper_remaining = soft_sleeper_remaining;
    }

    @JsonProperty("hard_sleeper_remaining")
    public String getHard_sleeper_remaining() {
        return hard_sleeper_remaining;
    }

    public void setHard_sleeper_remaining(String hard_sleeper_remaining) {
        this.hard_sleeper_remaining = hard_sleeper_remaining;
    }

    @JsonProperty("hard_seat_remaining")
    public String getHard_seat_remaining() {
        return hard_seat_remaining;
    }

    public void setHard_seat_remaining(String hard_seat_remaining) {
        this.hard_seat_remaining = hard_seat_remaining;
    }

    @JsonProperty("premier_seat_price")
    public String getPremier_seat_price() {
        return premier_seat_price;
    }

    public void setPremier_seat_price(String premier_seat_price) {
        this.premier_seat_price = premier_seat_price;
    }

    @JsonProperty("first_seat_price")
    public String getFirst_seat_price() {
        return first_seat_price;
    }

    public void setFirst_seat_price(String first_seat_price) {
        this.first_seat_price = first_seat_price;
    }

    @JsonProperty("second_seat_price")
    public String getSecond_seat_price() {
        return second_seat_price;
    }

    public void setSecond_seat_price(String second_seat_price) {
        this.second_seat_price = second_seat_price;
    }

    @JsonProperty("soft_sleeper_price")
    public String getSoft_sleeper_price() {
        return soft_sleeper_price;
    }

    public void setSoft_sleeper_price(String soft_sleeper_price) {
        this.soft_sleeper_price = soft_sleeper_price;
    }

    @JsonProperty("hard_sleeper_price")
    public String getHard_sleeper_price() {
        return hard_sleeper_price;
    }

    public void setHard_sleeper_price(String hard_sleeper_price) {
        this.hard_sleeper_price = hard_sleeper_price;
    }

    @JsonProperty("hard_seat_price")
    public String getHard_seat_price() {
        return hard_seat_price;
    }

    public void setHard_seat_price(String hard_seat_price) {
        this.hard_seat_price = hard_seat_price;
    }
}
