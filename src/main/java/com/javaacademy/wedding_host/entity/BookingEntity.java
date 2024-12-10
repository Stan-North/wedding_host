package com.javaacademy.wedding_host.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class BookingEntity {
    private final Integer monthNumber;
    private final Integer dayNumber;
    private boolean isBooked;
}
