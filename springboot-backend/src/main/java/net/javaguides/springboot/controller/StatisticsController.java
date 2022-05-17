package net.javaguides.springboot.controller;

import java.util.Date ;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.model.Detail;
import net.javaguides.springboot.model.Statistics;
import net.javaguides.springboot.repository.DetailRepository;
import net.javaguides.springboot.repository.UserRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/")
public class StatisticsController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private DetailRepository detailRepository;

	// get all user
//	@GetMapping("/statistics")
//	public List<User> getAllUsers() {
//		return userRepository.findAll();
//	}
	@PostMapping("/statistics/{date}")
	public ResponseEntity<List<Statistics>> getStatisticsByDate(@PathVariable String date) {
		List<Statistics> result = new ArrayList<Statistics>();


		String[] words = date.split(",");
		Date startedDate = convertStringToDate(words[0]);
		Date endDate = convertStringToDate(words[1]);
		
		List<Detail> details = detailRepository.findAll();		
		for (Detail d : details) {
			if(d.getStatus().equals("returned")) {
				Date dateTS = new Date(d.getReturnedDate().getTime());
				if(dateTS.after(startedDate) && dateTS.before(endDate)) {
					System.out.println("++");
					result.add(createNewStatistics(d));
				}
//				System.out.print("returned");
			}
		}
		return ResponseEntity.ok(result);
	}
	
	public static java.util.Date convertStringToDate(String dateString) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date parsed = new java.util.Date();
		try {
			parsed = format.parse(dateString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//        java.sql.Date sql = new java.sql.Date(parsed.getTime());
        return parsed;
		
	}
	
	public static Statistics createNewStatistics(Detail d) {
		Statistics r = new Statistics(d.getBookdetail().getBookName(),
				d.getBorrow().getUser().getLoginName(),
				d.getBorrow().getBorrowDate(),
				d.getBorrow().getDueDate(),
				d.getReturnedDate(),
				d.getStatus());
		return r;
	}

}
