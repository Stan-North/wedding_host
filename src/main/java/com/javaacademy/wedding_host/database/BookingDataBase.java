package com.javaacademy.wedding_host.database;

import com.javaacademy.wedding_host.entity.BookingEntity;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class BookingDataBase {
    private final Map<Integer, List<BookingEntity>> data = new ConcurrentHashMap<>();

    public void save(BookingEntity bookingEntity) {
        List<BookingEntity> bookingEntities = data.computeIfAbsent(
                bookingEntity.getMonthNumber(), list -> new ArrayList<>());
        bookingEntities.add(bookingEntity);
    }

    public List<BookingEntity> getBookingsByMonthNumber(Integer monthNumber) {
        return data.computeIfAbsent(monthNumber, list -> new ArrayList<>());
    }
}

