package com.javaacademy.wedding_host.repository;

import com.javaacademy.wedding_host.database.BookingDataBase;
import com.javaacademy.wedding_host.entity.BookingEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BookingRepository {
    private final BookingDataBase dataBase;

    public void save(BookingEntity bookingEntity) {
        dataBase.save(bookingEntity);
    }

    public List<BookingEntity> getBookingCountByMonthNumber(Integer monthNumber) {
        return dataBase.getBookingsByMonthNumber(monthNumber);
    }
}
