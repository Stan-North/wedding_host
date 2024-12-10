package com.javaacademy.wedding_host.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class BookingEntity {
    private final int month;
    private final int day;
    private boolean isBooked;
}
