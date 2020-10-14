package com.ssy.trainorder.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TrainSeat {
    private String train_no;
    private String seat_type;
    private int number;
    private int start_carriage_no;
    private int end_carriage_no;

    public TrainSeat(String train_no, String seat_type, int number, int start_carriage_no, int end_carriage_no) {
        this.train_no = train_no;
        this.seat_type = seat_type;
        this.number = number;
        this.start_carriage_no = start_carriage_no;
        this.end_carriage_no = end_carriage_no;
    }

    @JsonProperty("train_no")
    public String getTrain_no() {
        return train_no;
    }

    public void setTrain_no(String train_no) {
        this.train_no = train_no;
    }

    @JsonProperty("seat_type")
    public String getSeat_type() {
        return seat_type;
    }

    public void setSeat_type(String seat_type) {
        this.seat_type = seat_type;
    }

    @JsonProperty("start_carriage_no")
    public int getStart_carriage_no() {
        return start_carriage_no;
    }

    public void setStart_carriage_no(int start_carriage_no) {
        this.start_carriage_no = start_carriage_no;
    }

    @JsonProperty("end_carriage_no")
    public int getEnd_carriage_no() {
        return end_carriage_no;
    }

    public void setEnd_carriage_no(int end_carriage_no) {
        this.end_carriage_no = end_carriage_no;
    }

    @Override
    public String toString() {
        return "TrainSeat{" +
                "train_no='" + train_no + '\'' +
                ", seat_type='" + seat_type + '\'' +
                ", number=" + number +
                ", start_carriage_no=" + start_carriage_no +
                ", end_carriage_no=" + end_carriage_no +
                '}';
    }
}
