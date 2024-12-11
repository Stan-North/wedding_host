package com.javaacademy.wedding_host.service;

import com.javaacademy.wedding_host.dto.BookingRequestDto;
import com.javaacademy.wedding_host.dto.BookingResponseDto;
import com.javaacademy.wedding_host.dto.CountDTO;
import com.javaacademy.wedding_host.entity.BookingEntity;
import com.javaacademy.wedding_host.mapper.BookingMapper;
import com.javaacademy.wedding_host.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BookingService {
    private final BookingRepository bookingRepository;
    private final BookingMapper bookingMapper;

    public void save(BookingRequestDto bookingRequestDto) {
        BookingEntity bookingEntity = bookingMapper.convertToEntity(bookingRequestDto);
        bookingEntity.setBooked(true);
        bookingRepository.save(bookingEntity);
    }

    public List<BookingResponseDto> getBookingsByMonthNumber(int monthNumber) {
        return bookingRepository.getBookingCountByMonthNumber(monthNumber).stream()
                .map(bookingMapper::convertToResponseDto)
                .toList();
    }

    public CountDTO getCountByMonth(int monthNumber) {
        int size = bookingRepository.getBookingCountByMonthNumber(monthNumber).size();
        return new CountDTO(size);
    }
}
