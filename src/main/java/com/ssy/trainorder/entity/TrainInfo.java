package com.ssy.trainorder.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TrainInfo {
    private String train_no;
    private String train_type;

    public TrainInfo(String train_no, String train_type) {
        this.train_no = train_no;
        this.train_type = train_type;
    }

    @JsonProperty("train_no")
    public String getTrain_no() {
        return train_no;
    }

    public void setTrain_no(String train_no) {
        this.train_no = train_no;
    }

    @JsonProperty("train_type")
    public String getTrain_type() {
        return train_type;
    }

    public void setTrain_type(String train_type) {
        this.train_type = train_type;
    }

    @Override
    public String toString() {
        return "TrainInfo{" +
                "train_no='" + train_no + '\'' +
                ", train_type='" + train_type + '\'' +
                '}';
    }
}
