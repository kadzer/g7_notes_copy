package com.example.easycourse.CourseService.repositories.CourseRepository;

import com.example.easycourse.CourseService.models.Customer;
import com.example.easycourse.CourseService.models.Course;

import java.util.List;

public interface CourseRepositoryCustom {
    List<Course> getRestaurantsForStarRating(int rating);
    List<Customer> getAllCustomersForRestaurant(Long id);

    List<Customer> getAllCustomersForRestaurantInTown(Long id, String town);

    List<Customer> getAllCustomersForRestInTownOverAge(Long restaurantId, String town, int age);
}
