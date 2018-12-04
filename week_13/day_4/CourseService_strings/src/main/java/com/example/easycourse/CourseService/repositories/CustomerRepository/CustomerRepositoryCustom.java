package com.example.easycourse.CourseService.repositories.CustomerRepository;

import com.example.easycourse.CourseService.models.Course;

import java.util.List;

public interface CustomerRepositoryCustom {
    List<Course> getAllRestaurantsForCustomer(Long customerId);
}
