package com.javaacademy.wedding_host.service;

import com.javaacademy.wedding_host.dto.BookingRequestDto;
import com.javaacademy.wedding_host.dto.BookingResponseDto;
import com.javaacademy.wedding_host.dto.CountDTO;
import com.javaacademy.wedding_host.entity.BookingEntity;
import com.javaacademy.wedding_host.exception.MonthNumberValidException;
import com.javaacademy.wedding_host.mapper.BookingMapper;
import com.javaacademy.wedding_host.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BookingService {
    private static final int MIN_MONTH_NUMBER = 1;
    private static final int MAX_MONTH_NUMBER = 12;
    private static final String MONTH_NUMBER_EXCEPTION_MESSAGE = "Неверный номер месяца (введите от 1 до 12)";
    private final BookingRepository bookingRepository;
    private final BookingMapper bookingMapper;

    public void save(BookingRequestDto bookingRequestDto) {
        if (isMonthNumberValid(bookingRequestDto.getMonth())) {
            BookingEntity bookingEntity = bookingMapper.convertToEntity(bookingRequestDto);
            bookingEntity.setBooked(true);
            bookingRepository.save(bookingEntity);
        }
    }

    public List<BookingResponseDto> getBookingsByMonthNumber(int monthNumber) {
        return bookingRepository.getBookingCountByMonthNumber(monthNumber).stream()
                .map(entity -> new BookingResponseDto(entity.getMonthNumber(), entity.getDayNumber(), entity.isBooked()))
                .toList();
    }

    public CountDTO getCountByMonth(int monthNumber) {
        int size = bookingRepository.getBookingCountByMonthNumber(monthNumber).size();
        return new CountDTO(size);
    }

    private boolean isMonthNumberValid(int monthNumber) {
        if ((monthNumber >= MIN_MONTH_NUMBER) && (monthNumber <= MAX_MONTH_NUMBER)) {
            return true;
        } else {
            throw new MonthNumberValidException(MONTH_NUMBER_EXCEPTION_MESSAGE);
        }
    }
}
