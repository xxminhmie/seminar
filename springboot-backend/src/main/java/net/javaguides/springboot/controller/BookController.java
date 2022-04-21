package net.javaguides.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Book;
import net.javaguides.springboot.repository.BookRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/")
public class BookController {

	@Autowired
	private BookRepository bookRepository;
	
	// get all employees
	@GetMapping("/books")
	public List<Book> getAllBooks(){
		return bookRepository.findAll();
	}		
	
	// create employee rest api
	@PostMapping("/books")
	public Book createBook(@RequestBody Book book) {
		return bookRepository.save(book);
	}
	
	// get employee by id rest api
//	@GetMapping("/employees/{id}")
//	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
//		Employee employee = employeeRepository.findById(id)
//				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
//		return ResponseEntity.ok(employee);
//	}
	
	// update employee rest api
	
//	@PutMapping("/employees/{id}")
//	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails){
//		Employee employee = employeeRepository.findById(id)
//				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
//		
//		employee.setFirstName(employeeDetails.getFirstName());
//		employee.setLastName(employeeDetails.getLastName());
//		employee.setEmailId(employeeDetails.getEmailId());
//		
//		Employee updatedEmployee = employeeRepository.save(employee);
//		return ResponseEntity.ok(updatedEmployee);
//	}
	
	// delete employee rest api
//	@DeleteMapping("/employees/{id}")
//	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id){
//		Employee employee = employeeRepository.findById(id)
//				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
//		
//		employeeRepository.delete(employee);
//		Map<String, Boolean> response = new HashMap<>();
//		response.put("deleted", Boolean.TRUE);
//		return ResponseEntity.ok(response);
//	}
	
	
}
