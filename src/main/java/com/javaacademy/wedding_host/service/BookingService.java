package com.javaacademy.wedding_host.service;

import com.javaacademy.wedding_host.dto.RequestDto;
import com.javaacademy.wedding_host.dto.ResponseDto;
import com.javaacademy.wedding_host.entity.BookingEntity;
import com.javaacademy.wedding_host.exception.DateTakenException;
import com.javaacademy.wedding_host.exception.MonthNumberValidException;
import com.javaacademy.wedding_host.repository.BookingRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@RequiredArgsConstructor
@Service
public class BookingService {
    private static final int MIN_MONTH_NUMBER = 1;
    private static final int MAX_MONTH_NUMBER = 12;
    private static final String MONTH_NUMBER_EXCEPTION_MESSAGE = "Неверный номер месяца (введите от 1 до 12)";
    private static final String DATE_TAKEN_EXCEPTION_MESSAGE = "Эта дата уже забронирована";
    private final BookingRepository bookingRepository;

    public void save(RequestDto requestDto) {
        if (isMonthNumberValid(requestDto.getMonth())
                && isDateFree(requestDto.getMonth(), requestDto.getDay())) {
            bookingRepository.save(createEntity(requestDto.getMonth(), requestDto.getDay()));
        }
    }

    public ResponseDto getBookingsByMonthNumber(int monthNumber) {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setEntities(bookingRepository.getBookingCountByMonthNumber(monthNumber));
        return responseDto;
    }

    private BookingEntity createEntity(int monthNumber, int dayNumber) {
        BookingEntity entity = new BookingEntity(monthNumber, dayNumber);
        entity.setBooked(true);
        return entity;
    }

    private boolean isMonthNumberValid(int monthNumber) {
        if ((monthNumber >= MIN_MONTH_NUMBER) && (monthNumber <= MAX_MONTH_NUMBER)) {
            return true;
        } else {
            throw new MonthNumberValidException(MONTH_NUMBER_EXCEPTION_MESSAGE);
        }
    }

    private boolean isDateFree(int monthNumber, int dayNumber) {
        List<BookingEntity> bookings = bookingRepository.getBookingCountByMonthNumber(monthNumber);
        if (bookings.isEmpty()) {
            return true;
        }
        for (BookingEntity bookingEntity : bookings) {
            if (bookingEntity.getDay() == dayNumber && (!bookingEntity.isBooked())) {
                return true;
            }
        }
        throw new DateTakenException(DATE_TAKEN_EXCEPTION_MESSAGE);
    }

}
