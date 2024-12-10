package com.javaacademy.wedding_host.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingRequestDto {
    private Integer month;
    private Integer day;
    private boolean booked;
}
