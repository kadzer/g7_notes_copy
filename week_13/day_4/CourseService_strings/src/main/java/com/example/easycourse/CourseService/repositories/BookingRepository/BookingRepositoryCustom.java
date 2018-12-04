package com.example.easycourse.CourseService.repositories.BookingRepository;

import com.example.easycourse.CourseService.models.Booking;

import java.util.List;

public interface BookingRepositoryCustom {
    List<Booking> getAllBookingsForDate(String date);
}
