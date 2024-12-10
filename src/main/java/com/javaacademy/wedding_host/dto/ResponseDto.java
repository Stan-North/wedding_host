package com.javaacademy.wedding_host.dto;

import com.javaacademy.wedding_host.entity.BookingEntity;
import lombok.Data;

import java.util.List;

@Data
public class ResponseDto {
    private List<BookingEntity> entities;
}
