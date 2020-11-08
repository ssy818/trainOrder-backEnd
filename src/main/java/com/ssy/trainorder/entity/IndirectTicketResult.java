package com.ssy.trainorder.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IndirectTicketResult {
    private String start_staion_name;
    private String train_no_1;
    private String start_time_1;
    private String end_time_1;
    private String mid_station_name;
    private String mid_time;
    private String train_no_2;
    private String start_time_2;
    private String end_time_2;
    private String end_station_name;
    private String last_time;

    public IndirectTicketResult(String start_staion_name, String train_no_1, String start_time_1, String end_time_1, String mid_station_name, String mid_time, String train_no_2, String start_time_2, String end_time_2, String end_station_name, String last_time) {
        this.start_staion_name = start_staion_name;
        this.train_no_1 = train_no_1;
        this.start_time_1 = start_time_1;
        this.end_time_1 = end_time_1;
        this.mid_station_name = mid_station_name;
        this.mid_time = mid_time;
        this.train_no_2 = train_no_2;
        this.start_time_2 = start_time_2;
        this.end_time_2 = end_time_2;
        this.end_station_name = end_station_name;
        this.last_time = last_time;
    }

    @JsonProperty("start_station_name")
    public String getStart_staion_name() {
        return start_staion_name;
    }

    public void setStart_staion_name(String start_staion_name) {
        this.start_staion_name = start_staion_name;
    }

    @JsonProperty("train_no_1")
    public String getTrain_no_1() {
        return train_no_1;
    }

    public void setTrain_no_1(String train_no_1) {
        this.train_no_1 = train_no_1;
    }

    @JsonProperty("start_time_1")
    public String getStart_time_1() {
        return start_time_1;
    }

    public void setStart_time_1(String start_time_1) {
        this.start_time_1 = start_time_1;
    }

    @JsonProperty("end_time_1")
    public String getEnd_time_1() {
        return end_time_1;
    }

    public void setEnd_time_1(String end_time_1) {
        this.end_time_1 = end_time_1;
    }

    @JsonProperty("mid_station_name")
    public String getMid_station_name() {
        return mid_station_name;
    }

    public void setMid_station_name(String mid_station_name) {
        this.mid_station_name = mid_station_name;
    }

    @JsonProperty("mid_time")
    public String getMid_time() {
        return mid_time;
    }

    public void setMid_time(String mid_time) {
        this.mid_time = mid_time;
    }

    @JsonProperty("train_no_2")
    public String getTrain_no_2() {
        return train_no_2;
    }

    public void setTrain_no_2(String train_no_2) {
        this.train_no_2 = train_no_2;
    }

    @JsonProperty("start_time_2")
    public String getStart_time_2() {
        return start_time_2;
    }

    public void setStart_time_2(String start_time_2) {
        this.start_time_2 = start_time_2;
    }

    @JsonProperty("end_time_2")
    public String getEnd_time_2() {
        return end_time_2;
    }

    public void setEnd_time_2(String end_time_2) {
        this.end_time_2 = end_time_2;
    }

    @JsonProperty("end_station_name")
    public String getEnd_station_name() {
        return end_station_name;
    }

    public void setEnd_station_name(String end_station_name) {
        this.end_station_name = end_station_name;
    }

    @JsonProperty("last_time")
    public String getLast_time() {
        return last_time;
    }

    public void setLast_time(String last_time) {
        this.last_time = last_time;
    }

}
