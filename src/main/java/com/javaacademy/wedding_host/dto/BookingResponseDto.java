package com.javaacademy.wedding_host.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingResponseDto {
    private Integer monthNumber;
    private Integer dayNumber;
    private boolean isBooked;
}
