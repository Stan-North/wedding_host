package com.javaacademy.wedding_host.controller;

import com.javaacademy.wedding_host.dto.BookingRequestDto;
import com.javaacademy.wedding_host.dto.BookingResponseDto;
import com.javaacademy.wedding_host.dto.CountDTO;
import com.javaacademy.wedding_host.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class BookingController {
    private final BookingService bookingService;

    @GetMapping("/booking/month/{monthNumber}")
    public List<BookingResponseDto> getByMonth(@PathVariable Integer monthNumber) {
        return bookingService.getBookingsByMonthNumber(monthNumber);
    }

    @GetMapping("booking/month/{monthNumber}/free")
    public CountDTO getCountBookingByMonth(@PathVariable Integer monthNumber) {
        return bookingService.getCountByMonth(monthNumber);
    }

    @PostMapping("/booking")
    public void createBooking(@RequestBody BookingRequestDto bookingRequestDto) {
        bookingService.save(bookingRequestDto);
    }
}
