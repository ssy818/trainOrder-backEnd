package com.ssy.trainorder.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Order {
    private int order_id;
    private String create_time;
    private String order_status;
    private double money;
    private String train_no;
    private String depart_date;
    private int start_stop_no;
    private int end_stop_no;
    private int carriage_no;
    private int seat_no;
    private String user_phone;
    private String person_id;

    public Order(int order_id, String create_time, String order_status, double money, String train_no, String depart_date, int start_stop_no, int end_stop_no, int carriage_no, int seat_no, String user_phone, String person_id) {
        this.order_id = order_id;
        this.create_time = create_time;
        this.order_status = order_status;
        this.money = money;
        this.train_no = train_no;
        this.depart_date = depart_date;
        this.start_stop_no = start_stop_no;
        this.end_stop_no = end_stop_no;
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

    @JsonProperty("money")
    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @JsonProperty("train_no")
    public String getTrain_no() {
        return train_no;
    }

    public void setTrain_no(String train_no) {
        this.train_no = train_no;
    }

    @JsonProperty("depart_date")
    public String getDepart_date() {
        return depart_date;
    }

    public void setDepart_date(String depart_date) {
        this.depart_date = depart_date;
    }

    @JsonProperty("start_stop_no")
    public int getStart_stop_no() {
        return start_stop_no;
    }

    public void setStart_stop_no(int start_stop_no) {
        this.start_stop_no = start_stop_no;
    }

    @JsonProperty("end_stop_no")
    public int getEnd_stop_no() {
        return end_stop_no;
    }

    public void setEnd_stop_no(int end_stop_no) {
        this.end_stop_no = end_stop_no;
    }

    @JsonProperty("carriage_no")
    public int getCarriage_no() {
        return carriage_no;
    }

    public void setCarriage_no(int carriage_no) {
        this.carriage_no = carriage_no;
    }

    @JsonProperty("seat_no")
    public int getSeat_no() {
        return seat_no;
    }

    public void setSeat_no(int seat_no) {
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

}
