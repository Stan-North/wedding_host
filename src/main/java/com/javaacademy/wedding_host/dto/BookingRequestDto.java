package com.javaacademy.wedding_host.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingRequestDto {
    @JsonProperty("month")
    private Integer monthNumber;
    @JsonProperty("day")
    private Integer dayNumber;
    @JsonProperty("booked")
    private boolean isBooked;
}
