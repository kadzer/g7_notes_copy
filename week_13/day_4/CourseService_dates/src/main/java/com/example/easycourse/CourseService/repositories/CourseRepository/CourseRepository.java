package com.example.easycourse.CourseService.repositories.CourseRepository;

import com.example.easycourse.CourseService.models.Customer;
import com.example.easycourse.CourseService.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>, CourseRepositoryCustom {
    List<Course> getRestaurantsForStarRating(int rating);

    List<Customer> getAllCustomersForRestaurant(Long id);

    List<Customer> getAllCustomersForRestaurantInTown(Long id, String town);

    List<Customer> getAllCustomersForRestInTownOverAge(Long restaurantId, String town, int age);
}
