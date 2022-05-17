package net.javaguides.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.caen.RFIDLibrary.CAENRFIDException;
import com.caen.RFIDLibrary.CAENRFIDLogicalSource;
import com.caen.RFIDLibrary.CAENRFIDLogicalSourceConstants;
import com.caen.RFIDLibrary.CAENRFIDPort;
import com.caen.RFIDLibrary.CAENRFIDReader;
import com.caen.RFIDLibrary.CAENRFIDReaderInfo;
import com.caen.RFIDLibrary.CAENRFIDTag;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Book;
import net.javaguides.springboot.model.Borrow;
import net.javaguides.springboot.model.Detail;
import net.javaguides.springboot.model.TagRead;
import net.javaguides.springboot.repository.BookRepository;
import net.javaguides.springboot.repository.BorrowRepository;
import net.javaguides.springboot.repository.DetailRepository;
import net.javaguides.springboot.repository.TagReadRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/")
public class ReturnBookController {

	@Autowired
	private DetailRepository detailRepository;

	@Autowired
	private TagReadRepository tagReadRepository;

	List<TagRead> scannedTagReadList;

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
		for (Detail d : detailList) {
			if (String.valueOf(d.getBorrow().getId()).equals(String.valueOf(borrowId))) {
				detailListByBorrowId.add(d);
			}
		}
		return detailListByBorrowId;
	}

	// get return book list by borrow id rest api
	@GetMapping("/return-book/{id}")
	public ResponseEntity<List<Detail>> getReturnBookListById(@PathVariable Long id) {
		List<Detail> detailList = detailRepository.findAll();
		List<Detail> details = new ArrayList<>();
		for (Detail d : detailList) {
			if (String.valueOf(d.getBorrow().getId()).equals(String.valueOf(id))) {
				details.add(d);
			}
		}
		return ResponseEntity.ok(details);
	}

	@PostMapping("/return-book/inventory/{id}")
	public ResponseEntity<List<Detail>> getBookIdListByRFID(@PathVariable Long id) throws Exception {
		List<Detail> result = new ArrayList<>();

		List<Detail> detailList = detailRepository.findAll();
		this.scannedTagReadList = readByRFIDReader();

		if (scannedTagReadList == null) {
			return null;
		}

		for (Detail d : detailList) { // get detail list by borrow id
			if (String.valueOf(d.getBorrow().getId()).equals(String.valueOf(id))) {
				for (TagRead tag : this.scannedTagReadList) {
					if (d.getBookId().equals(tag.getBook().getId())) {
						d.setNote(true);
					}
				}
				result.add(d);
			}
		}
		return ResponseEntity.ok(result);
	}

	@PutMapping("/return-book/return/{id}")
	public ResponseEntity<List<Detail>> updateBookIdListByRFID(@PathVariable Long id) {
		List<Detail> result = new ArrayList<>();
		List<Detail> detailList = detailRepository.findAll();
//		scannedTagReadList = readByRFIDReader();

		for (Detail d : detailList) { // get detail list by borrow id
			if (String.valueOf(d.getBorrow().getId()).equals(String.valueOf(id))) {
			}
			for (TagRead tag : this.scannedTagReadList) {
				if (d.getBookId().equals(tag.getBook().getId())) {
					d.setNote(true);
					d.setStatus("returned");
				    java.util.Date today = new java.util.Date();   
				    d.setReturnedDate(today);

				}
			}
//			result.add(d);
			Detail updatedDetail = detailRepository.save(d);
			result.add(updatedDetail);
		}
		return ResponseEntity.ok(result);
	}

	public List<TagRead> readByRFIDReader() throws Exception {
		List<TagRead> result = new ArrayList<>();

//		Read scanner = new Read();
//		List<String> tags = scanner.ReadTag();
		
		List<String> tags = new ArrayList<>();
		tags.add("300F4F573AD001C08369A249");// scan
		tags.add("300F4F573AD001C08369A28F");// scan
		
		if (tags == null) {
//			scanner = null;
			System.gc();
			System.out.println("Tags is null, no tag was scanned!");
			return null;
		} else {
			List<TagRead> listTagRead = tagReadRepository.findAll();
			for (TagRead tag : listTagRead) {
				for (String rfidString : tags) {
					if (tag.getTagRfid().toLowerCase().equals(rfidString.toLowerCase())) {
						result.add(tag);
					}

				}
			}
			return result;
		}


		
	}

}
