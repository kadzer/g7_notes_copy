package com.example.easycourse.CourseService;

import com.example.easycourse.CourseService.models.Booking;
import com.example.easycourse.CourseService.models.Customer;
import com.example.easycourse.CourseService.models.Course;
import com.example.easycourse.CourseService.repositories.BookingRepository.BookingRepository;
import com.example.easycourse.CourseService.repositories.CustomerRepository.CustomerRepository;
import com.example.easycourse.CourseService.repositories.CourseRepository.CourseRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseServiceApplicationTests {

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	BookingRepository bookingRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Test
	public void contextLoads() {
	}


	@Test
	public void canFindAllRestaurants(){
		List<Course> found = courseRepository.findAll();
		assertEquals(2, found.size());
	}

	@Test
	public void canGetRestaurantsForStarRating(){
		List<Course> found = courseRepository.getRestaurantsForStarRating(5);
		assertEquals(1, found.size());
		assertEquals("Intro To Python", found.get(0).getName());
	}

	@Test
	public void canGetAllCustomersForRestaurantOsteria() {
		List<Customer> found = courseRepository.getAllCustomersForRestaurant(1L);
		assertEquals(1, found.size());
		assertEquals("Bob", found.get(0).getName());
	}

	@Test
	public void canGetAllCustomersForRestaurantFrenchLaundry(){
		List<Customer> found = courseRepository.getAllCustomersForRestaurant(2L);
		assertEquals(3, found.size());
		assertEquals("Jeff", found.get(0).getName());
		assertEquals("Jackie", found.get(1).getName());
		assertEquals("Eric", found.get(2).getName());
	}

	@Test
	public void canGetAllCustomersForFrenchlaundryInTownNovato(){
		List<Customer> found = courseRepository.getAllCustomersForRestaurantInTown(2L, "novato");
		assertEquals("Jeff", found.get(0).getName());
	}

	@Test
	public void canGetAllCustomersForOsteriaInTownModena(){
		List<Customer> found = courseRepository.getAllCustomersForRestaurantInTown(1L, "modena");
		assertEquals("Bob", found.get(0).getName());
	}

	@Test
	public void canGetAllCustomersForOsteriaInSF() {
		List<Customer> found = courseRepository.getAllCustomersForRestaurantInTown(1L, "san francisco");
		assertEquals(0, found.size());
	}

	@Test
	public void canGetAllBookingsForDate(){
		List<Booking> found = bookingRepository.getAllBookingsForDate("24-12-2018");
		assertEquals(4, found.size());
	}

	@Test
	public void canGetAllResturantsForCustomer(){
		List<Course> found = customerRepository.getAllRestaurantsForCustomer(1L);
		assertEquals("Intro To Python", found.get(0).getName());
	}

	@Test
	public void canGetCustomersInModenaForOsteriatOverAge(){
		List<Customer> found = courseRepository.getAllCustomersForRestInTownOverAge(1L,"modena", 18);
		assertEquals("Bob", found.get(0).getName());

	}

	@Test
	public void canGetCustomersInNovatoForFrenchLaundryOverAge(){
		List<Customer> found = courseRepository.getAllCustomersForRestInTownOverAge(2L,"novato", 18);
		assertEquals(2, found.size());
		assertEquals("Jeff", found.get(0).getName());
		assertEquals("Eric", found.get(1).getName());

	}

}
