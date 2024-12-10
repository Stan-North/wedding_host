package com.javaacademy.wedding_host.controller;

import com.javaacademy.wedding_host.dto.RequestDto;
import com.javaacademy.wedding_host.entity.BookingEntity;
import com.javaacademy.wedding_host.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookingController {
    private final BookingService bookingService;

    @GetMapping("/booking/month/{monthNumber}")
    public List<BookingEntity> getByMonth(@PathVariable Integer monthNumber) {
        return bookingService.getBookingsByMonthNumber(monthNumber).getEntities();
    }

    @GetMapping("booking/month/{monthNumber}/free")
    public int getCountBookingByMonth(@PathVariable Integer monthNumber) {
        return bookingService.getBookingsByMonthNumber(monthNumber).getEntities().size();
    }

    @PostMapping("/booking")
    public void createBooking(@RequestBody RequestDto requestDto) {
        bookingService.save(requestDto);
    }
}
