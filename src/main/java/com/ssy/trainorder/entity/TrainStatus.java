package com.ssy.trainorder.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TrainStatus {
    private String train_no;
    private String start_date;
    private String train_status;

    public TrainStatus(String train_no, String start_date, String train_status) {
        this.train_no = train_no;
        this.start_date = start_date;
        this.train_status = train_status;
    }

    @JsonProperty("train_no")
    public String getTrain_no() {
        return train_no;
    }

    public void setTrain_no(String train_no) {
        this.train_no = train_no;
    }

    @JsonProperty("start_date")
    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    @JsonProperty("train_status")
    public String getTrain_status() {
        return train_status;
    }

    public void setTrain_status(String train_status) {
        this.train_status = train_status;
    }

    @Override
    public String toString() {
        return "TrainStatus{" +
                "train_no='" + train_no + '\'' +
                ", start_date='" + start_date + '\'' +
                ", train_status='" + train_status + '\'' +
                '}';
    }
}
