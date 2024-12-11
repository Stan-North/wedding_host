package com.javaacademy.wedding_host.mapper;

import com.javaacademy.wedding_host.dto.BookingRequestDto;
import com.javaacademy.wedding_host.dto.BookingResponseDto;
import com.javaacademy.wedding_host.entity.BookingEntity;
import org.springframework.stereotype.Component;

@Component
public class BookingMapper {

    public BookingRequestDto convertToRequestDto(BookingEntity bookingEntity) {
        return new BookingRequestDto(
                bookingEntity.getMonthNumber(),
                bookingEntity.getDayNumber(),
                bookingEntity.isBooked());
    }

    public BookingResponseDto convertToResponseDto(BookingEntity bookingEntity) {
        return new BookingResponseDto(
                bookingEntity.getMonthNumber(),
                bookingEntity.getMonthNumber(),
                bookingEntity.isBooked());
    }

    public BookingEntity convertToEntity(BookingRequestDto requestDto) {
        return new BookingEntity(
                requestDto.getMonth(),
                requestDto.getDay());
    }
}
