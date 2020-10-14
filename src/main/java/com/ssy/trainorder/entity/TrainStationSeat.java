package com.ssy.trainorder.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TrainStationSeat {
    private String train_no;
    private int stop_no;
    private String seat_type;
    private double price;

    public TrainStationSeat(String train_no, int stop_no, String seat_type, double price) {
        this.train_no = train_no;
        this.stop_no = stop_no;
        this.seat_type = seat_type;
        this.price = price;
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

    @JsonProperty("seat_type")
    public String getSeat_type() {
        return seat_type;
    }

    public void setSeat_type(String seat_type) {
        this.seat_type = seat_type;
    }

    @JsonProperty("price")
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "TrainStationSeatPrice{" +
                "train_no='" + train_no + '\'' +
                ", stop_no=" + stop_no +
                ", seat_type='" + seat_type + '\'' +
                ", price=" + price +
                '}';
    }
}
