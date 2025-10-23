package com.example.demo.dto.request;

import lombok.Data;

@Data
public class RoomReq {
    private String nameroom;
    private String passroom;
    private long max_quantity;
}
