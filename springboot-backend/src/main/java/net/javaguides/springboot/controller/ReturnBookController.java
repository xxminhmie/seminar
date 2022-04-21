package net.javaguides.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.model.Book;
import net.javaguides.springboot.model.Borrow;
import net.javaguides.springboot.model.Detail;
import net.javaguides.springboot.repository.BookRepository;
import net.javaguides.springboot.repository.BorrowRepository;
import net.javaguides.springboot.repository.DetailRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/")
public class ReturnBookController {

	@Autowired
	private DetailRepository detailRepository;

	@Autowired
	private BorrowRepository borrowRepository;

	// get all employees
	@GetMapping("/return-book")
	public List<Detail> getAllBooks() {
		return detailRepository.findAll();
	}

	@PostMapping("/return-book")
	public List<Detail> getBookListByBorrowId(@RequestBody String jsonData) {
		// https://stackoverflow.com/questions/2591098/how-to-parse-json-in-java
		JSONObject obj = new JSONObject(jsonData);
		Long borrowId = obj.getLong("borrowId");
		
		List<Detail> detailList = detailRepository.findAll();
		List<Detail> detailListByBorrowId = new ArrayList<>();	
		for (Detail d: detailList) {
			if(String.valueOf(d.getBorrow().getId()).equals(String.valueOf(borrowId))) {
				detailListByBorrowId.add(d);
			}
		}
		return detailListByBorrowId;
	}

	@PostMapping("/return-book/start-inventory")
	public List<Detail> getBookListByStartInventory(@RequestBody String jsonData) {
		JSONObject obj = new JSONObject(jsonData);
		Long borrowId = obj.getLong("borrowId");

		System.out.println(borrowId);
//		Borrow borrow = borrowRepository.findById(borrowId).orElse(new Borrow());
		List<Detail> detailList = detailRepository.findAll();
		List<Detail> detailListByBorrowId = new ArrayList<>();
		for (Detail d : detailList) {
			if (String.valueOf(d.getBorrow().getId()).equals(String.valueOf(borrowId))) {
				detailListByBorrowId.add(d);
			}
		}
		return detailListByBorrowId;
	}

}
