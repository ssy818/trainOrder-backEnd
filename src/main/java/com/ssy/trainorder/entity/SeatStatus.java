package com.ssy.trainorder.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SeatStatus {
    private String seat_position;
    private int remaining;

    public SeatStatus(String seat_position, int remaining) {
        this.seat_position = seat_position;
        this.remaining = remaining;
    }

    @JsonProperty("seat_position")
    public String getSeat_position() {
        return seat_position;
    }

    public void setSeat_position(String seat_position) {
        this.seat_position = seat_position;
    }

    @JsonProperty("remaining")
    public int getRemaining() {
        return remaining;
    }

    public void setRemaining(int remaining) {
        this.remaining = remaining;
    }
}
