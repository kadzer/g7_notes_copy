package com.example.easycourse.CourseService.controllers;

import com.example.easycourse.CourseService.repositories.CourseRepository.CourseRepository;
import com.example.easycourse.CourseService.models.Customer;
import com.example.easycourse.CourseService.models.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping(value = "/stars/{rating}")
    public List<Course> restaurantsForStarRating(@PathVariable int rating){
       return courseRepository.getRestaurantsForStarRating(rating);
    }

    @GetMapping(value = "/{id}/customers")
    public List<Customer> customersForRestaurant(@PathVariable Long id){
        return courseRepository.getAllCustomersForRestaurant(id);
    }

    @GetMapping(value = "{id}/customers/town/{town}")
    public List<Customer> customersForRestaurantInTown(@PathVariable Long id,
                                                       @PathVariable String town){
        return courseRepository.getAllCustomersForRestaurantInTown(id, town);
    }
}
