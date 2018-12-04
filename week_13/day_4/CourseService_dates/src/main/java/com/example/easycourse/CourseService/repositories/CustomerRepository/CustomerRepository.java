package com.example.easycourse.CourseService.repositories.CustomerRepository;

import com.example.easycourse.CourseService.models.Customer;
import com.example.easycourse.CourseService.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long>, CustomerRepositoryCustom {
    List<Course> getAllRestaurantsForCustomer(Long customerId);
}
