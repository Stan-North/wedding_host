package com.javaacademy.wedding_host.database;

import com.javaacademy.wedding_host.entity.BookingEntity;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
@Data
public class BookingDataBase {
    private final Map<Integer, List<BookingEntity>> data = new HashMap<>();

    public void save(BookingEntity bookingEntity) {
        List<BookingEntity> bookingByMonth = data.get(bookingEntity.getMonth());
        bookingByMonth.add(bookingEntity);
    }

    public List<BookingEntity> getBookingsByMonthNumber(Integer monthNumber) {
        return data.get(monthNumber);
    }
}

