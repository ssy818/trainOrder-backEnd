package com.ssy.trainorder.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TrainStationResult {
    private String leave_time;
    private String station_name;
    private String arrive_time;
    private String last_time;

    public TrainStationResult(String leave_time, String station_name, String arrive_time, String last_time) {
        this.leave_time = leave_time;
        this.station_name = station_name;
        this.arrive_time = arrive_time;
        this.last_time = last_time;
    }

    @JsonProperty("leave_time")
    public String getLeave_time() {
        return leave_time;
    }

    public void setLeave_time(String leave_time) {
        this.leave_time = leave_time;
    }

    @JsonProperty("station_name")
    public String getStation_name() {
        return station_name;
    }

    public void setStation_name(String station_name) {
        this.station_name = station_name;
    }

    @JsonProperty("arrive_time")
    public String getArrive_time() {
        return arrive_time;
    }

    public void setArrive_time(String arrive_time) {
        this.arrive_time = arrive_time;
    }

    @JsonProperty("last_time")
    public String getLast_time() {
        return last_time;
    }

    public void setLast_time(String last_time) {
        this.last_time = last_time;
    }
}
