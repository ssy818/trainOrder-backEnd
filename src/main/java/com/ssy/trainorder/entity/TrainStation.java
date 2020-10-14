package com.ssy.trainorder.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TrainStation {
    private String train_no;
    private int stop_no;
    private String city_name;
    private String station_name;
    private String arrive_time;
    private int stop_interval;
    private int last_day;

    public TrainStation(String train_no, int stop_no, String city_name, String station_name, String arrive_time, int stop_interval, int last_day) {
        this.train_no = train_no;
        this.stop_no = stop_no;
        this.city_name = city_name;
        this.station_name = station_name;
        this.arrive_time = arrive_time;
        this.stop_interval = stop_interval;
        this.last_day = last_day;
    }

    @JsonProperty("train_no")
    public String getTrain_no() {
        return train_no;
    }

    public void setTrain_no(String train_no) {
        this.train_no = train_no;
    }

    @JsonProperty("stop_no")
    public int getStop_no() {
        return stop_no;
    }

    public void setStop_no(int stop_no) {
        this.stop_no = stop_no;
    }

    @JsonProperty("city_name")
    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
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

    @JsonProperty("stop_interval")
    public int getStop_interval() {
        return stop_interval;
    }

    public void setStop_interval(int stop_interval) {
        this.stop_interval = stop_interval;
    }

    @Override
    public String toString() {
        return "TrainStation{" +
                "train_no='" + train_no + '\'' +
                ", stop_no=" + stop_no +
                ", city_name='" + city_name + '\'' +
                ", station_name='" + station_name + '\'' +
                ", arrive_time='" + arrive_time + '\'' +
                ", stop_interval=" + stop_interval +
                ", last_day=" + last_day +
                '}';
    }
}
