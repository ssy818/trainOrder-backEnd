package com.ssy.trainorder.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Order {
    private int order_id;
    private String create_time;
    private String order_status;
    private double price;
    private int leave_stop_no;
    private int arrive_stop_no;
    private String leave_date;
    private String train_no;
    private int carriage_no;
    private String seat_no;
    private String user_phone;
    private String person_id;

    public Order(int order_id, String create_time, String order_status, double price, int leave_stop_no, int arrive_stop_no, String leave_date, String train_no, int carriage_no, String seat_no, String user_phone, String person_id) {
        this.order_id = order_id;
        this.create_time = create_time;
        this.order_status = order_status;
        this.price = price;
        this.leave_stop_no = leave_stop_no;
        this.arrive_stop_no = arrive_stop_no;
        this.leave_date = leave_date;
        this.train_no = train_no;
        this.carriage_no = carriage_no;
        this.seat_no = seat_no;
        this.user_phone = user_phone;
        this.person_id = person_id;
    }

    @JsonProperty("order_id")
    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    @JsonProperty("create_time")
    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    @JsonProperty("order_status")
    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    @JsonProperty("price")
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @JsonProperty("leave_stop_no")
    public int getLeave_stop_no() {
        return leave_stop_no;
    }

    public void setLeave_stop_no(int leave_stop_no) {
        this.leave_stop_no = leave_stop_no;
    }

    @JsonProperty("arrive_stop_no")
    public int getArrive_stop_no() {
        return arrive_stop_no;
    }

    public void setArrive_stop_no(int arrive_stop_no) {
        this.arrive_stop_no = arrive_stop_no;
    }

    @JsonProperty("leave_date")
    public String getLeave_date() {
        return leave_date;
    }

    public void setLeave_date(String leave_date) {
        this.leave_date = leave_date;
    }

    @JsonProperty("train_no")
    public String getTrain_no() {
        return train_no;
    }

    public void setTrain_no(String train_no) {
        this.train_no = train_no;
    }

    @JsonProperty("carriage_no")
    public int getCarriage_no() {
        return carriage_no;
    }

    public void setCarriage_no(int carriage_no) {
        this.carriage_no = carriage_no;
    }

    @JsonProperty("seat_no")
    public String getSeat_no() {
        return seat_no;
    }

    public void setSeat_no(String seat_no) {
        this.seat_no = seat_no;
    }

    @JsonProperty("user_phone")
    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    @JsonProperty("person_id")
    public String getPerson_id() {
        return person_id;
    }

    public void setPerson_id(String person_id) {
        this.person_id = person_id;
    }

    @Override
    public String toString() {
        return "Order{" +
                "order_id=" + order_id +
                ", create_time='" + create_time + '\'' +
                ", order_status='" + order_status + '\'' +
                ", price=" + price +
                ", leave_stop_no=" + leave_stop_no +
                ", arrive_stop_no=" + arrive_stop_no +
                ", leave_date='" + leave_date + '\'' +
                ", train_no='" + train_no + '\'' +
                ", carriage_no=" + carriage_no +
                ", seat_no='" + seat_no + '\'' +
                ", user_phone='" + user_phone + '\'' +
                ", person_id='" + person_id + '\'' +
                '}';
    }
}
