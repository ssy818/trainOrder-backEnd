package com.ssy.trainorder.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DirectTicketResult {
    private String train_no;
    private String start_station_name;
    private String end_station_name;
    private String start_time;
    private String end_time;
    private String last_time;
    private String premier_seat;
    private String first_seat;
    private String second_seat;
    private String soft_sleeper;
    private String hard_sleeper;
    private String hard_seat;

    public DirectTicketResult(String train_no, String start_station_name, String end_station_name, String start_time, String end_time) {
        this.train_no = train_no;
        this.start_station_name = start_station_name;
        this.end_station_name = end_station_name;
        this.start_time = start_time;
        this.end_time = end_time;
        this.last_time = "";
        this.premier_seat = "--";
        this.first_seat = "--";
        this.second_seat = "--";
        this.soft_sleeper = "--";
        this.hard_sleeper = "--";
        this.hard_seat = "--";
    }

    public DirectTicketResult(String train_no, String start_station_name, String end_station_name, String start_time, String end_time, String last_time, String premier_seat, String first_seat, String second_seat, String soft_sleeper, String hard_sleeper, String hard_seat) {
        this.train_no = train_no;
        this.start_station_name = start_station_name;
        this.end_station_name = end_station_name;
        this.start_time = start_time;
        this.end_time = end_time;
        this.last_time = last_time;
        this.premier_seat = premier_seat;
        this.first_seat = first_seat;
        this.second_seat = second_seat;
        this.soft_sleeper = soft_sleeper;
        this.hard_sleeper = hard_sleeper;
        this.hard_seat = hard_seat;
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

    @JsonProperty("premier_seat")
    public String getPremier_seat() {
        return premier_seat;
    }

    public void setPremier_seat(String premier_seat) {
        this.premier_seat = premier_seat;
    }

    @JsonProperty("first_seat")
    public String getFirst_seat() {
        return first_seat;
    }

    public void setFirst_seat(String first_seat) {
        this.first_seat = first_seat;
    }

    @JsonProperty("second_seat")
    public String getSecond_seat() {
        return second_seat;
    }

    public void setSecond_seat(String second_seat) {
        this.second_seat = second_seat;
    }

    @JsonProperty("soft_sleeper")
    public String getSoft_sleeper() {
        return soft_sleeper;
    }

    public void setSoft_sleeper(String soft_sleeper) {
        this.soft_sleeper = soft_sleeper;
    }

    @JsonProperty("hard_sleeper")
    public String getHard_sleeper() {
        return hard_sleeper;
    }

    public void setHard_sleeper(String hard_sleeper) {
        this.hard_sleeper = hard_sleeper;
    }

    @JsonProperty("hard_seat")
    public String getHard_seat() {
        return hard_seat;
    }

    public void setHard_seat(String hard_seat) {
        this.hard_seat = hard_seat;
    }

    @Override
    public String toString() {
        return "DirectTicketResult{" +
                "train_no='" + train_no + '\'' +
                ", start_station_name='" + start_station_name + '\'' +
                ", end_station_name='" + end_station_name + '\'' +
                ", start_time='" + start_time + '\'' +
                ", end_time='" + end_time + '\'' +
                ", last_time='" + last_time + '\'' +
                ", premier_seat='" + premier_seat + '\'' +
                ", first_seat='" + first_seat + '\'' +
                ", second_seat='" + second_seat + '\'' +
                ", soft_sleeper='" + soft_sleeper + '\'' +
                ", hard_sleeper='" + hard_sleeper + '\'' +
                ", hard_seat='" + hard_seat + '\'' +
                '}';
    }
}
