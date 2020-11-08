package com.ssy.trainorder.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderResult {
    private int order_id;
    private String train_no;
    private String start_station_name;
    private String end_station_name;
    private String start_date;
    private String start_time;
    private String end_time;
    private String last_time;
    private int carriage_no;
    private String seat_type;
    private String seat_position;
    private String money;
    private String order_status;
    private String real_name;
    private String person_id;
    private String passenger_phone;
    private String create_time;

    public OrderResult(int order_id, String train_no, String start_station_name, String end_station_name, String start_date, String start_time, String end_time, String last_time, int carriage_no, String seat_type, String seat_position, String money, String order_status, String real_name, String person_id, String passenger_phone, String create_time) {
        this.order_id = order_id;
        this.train_no = train_no;
        this.start_station_name = start_station_name;
        this.end_station_name = end_station_name;
        this.start_date = start_date;
        this.start_time = start_time;
        this.end_time = end_time;
        this.last_time = last_time;
        this.carriage_no = carriage_no;
        this.seat_type = seat_type;
        this.seat_position = seat_position;
        this.money = money;
        this.order_status = order_status;
        this.real_name = real_name;
        this.person_id = person_id;
        this.passenger_phone = passenger_phone;
        this.create_time = create_time;
    }

    @JsonProperty("order_id")
    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
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

    @JsonProperty("start_date")
    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
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

    @JsonProperty("last_time")
    public String getLast_time() {
        return last_time;
    }

    public void setLast_time(String last_time) {
        this.last_time = last_time;
    }

    @JsonProperty("carriage_no")
    public int getCarriage_no() {
        return carriage_no;
    }

    public void setCarriage_no(int carriage_no) {
        this.carriage_no = carriage_no;
    }

    @JsonProperty("seat_type")
    public String getSeat_type() {
        return seat_type;
    }

    public void setSeat_type(String seat_type) {
        this.seat_type = seat_type;
    }

    @JsonProperty("seat_position")
    public String getSeat_position() {
        return seat_position;
    }

    public void setSeat_position(String seat_position) {
        this.seat_position = seat_position;
    }

    @JsonProperty("money")
    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    @JsonProperty("order_status")
    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    @JsonProperty("real_name")
    public String getReal_name() {
        return real_name;
    }

    public void setReal_name(String real_name) {
        this.real_name = real_name;
    }

    @JsonProperty("person_id")
    public String getPerson_id() {
        return person_id;
    }

    public void setPerson_id(String person_id) {
        this.person_id = person_id;
    }

    @JsonProperty("passenger_phone")
    public String getPassenger_phone() {
        return passenger_phone;
    }

    public void setPassenger_phone(String passenger_phone) {
        this.passenger_phone = passenger_phone;
    }

    @JsonProperty("create_time")
    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }
}
