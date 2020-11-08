package com.ssy.trainorder.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TicketInfo {
    private String train_no;
    private String start_station_name;
    private String end_station_name;
    private String start_time;
    private String end_time;

    public TicketInfo(String train_no, String start_station_name, String end_station_name, String start_time, String end_time) {
        this.train_no = train_no;
        this.start_station_name = start_station_name;
        this.end_station_name = end_station_name;
        this.start_time = start_time;
        this.end_time = end_time;
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
}
