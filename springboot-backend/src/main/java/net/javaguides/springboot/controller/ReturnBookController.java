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
		System.out.println("getReturnBookListById func " + id);
		
		List<Detail> detailList = detailRepository.findAll();
		List<Detail> details = new ArrayList<>();
		for (Detail d : detailList) {
			if (String.valueOf(d.getBorrow().getId()).equals(String.valueOf(id))) {
				details.add(d);
			}
		}
		return ResponseEntity.ok(details);
	}
	
	// get book id list by RFID
	@PostMapping("/return-book/inventory/{id}")
	public ResponseEntity<List<Detail>> getBookIdListByRFID(@PathVariable Long id) {		
		System.out.print("Inventory starting....");
		
		List<Detail> list = new ArrayList<>();
		List<Detail> detailList = detailRepository.findAll();
		for (Detail d : detailList) {
			if (String.valueOf(d.getBorrow().getId()).equals(String.valueOf(id))) {
//				readByRFIDReader(list);
				if(d.getBookId().equals("300EFE2F94D01C42540BE4F9")) {
					d.setNote(true);
				}
				list.add(d);
			}
		}
		return ResponseEntity.ok(list);
	}
	
	// TODO
	public List<String> readByRFIDReader(List<String> list) {
		CAENRFIDReader myReader = new CAENRFIDReader();
		try {
			myReader.Connect(CAENRFIDPort.CAENRFID_TCP, "192.168.1.2");
			CAENRFIDLogicalSource mySource = myReader.GetSource("Source_0");
			
			
			// get Reader Infor
			CAENRFIDReaderInfo info =myReader.GetReaderInfo();
			
			String model = info.GetModel();
			String serialNumber = info.GetSerialNumber();
			String fwRelease = myReader.GetFirmwareRelease();
			int power = myReader.GetPower();// tinh theo cong de xac dinh khoang cach
			
			// in ra thong tin
			System.out.println("Model: " + model);
			System.out.println("SerialNumber: " + serialNumber);
			System.out.println("fwRelease: " + fwRelease);
			System.out.println("power: " + power);
			System.out.println();
			
			// thoi gian nhan
			mySource.SetSession_EPC_C1G2(CAENRFIDLogicalSourceConstants.EPC_C1G2_SESSION_S1);
			
			// chua thong tin cua cac tag
			// chua tat ca thong tin quet tren thiet bi
			CAENRFIDTag[] myTags = mySource.Inventory();
			if (myTags.length > 0) {
				// show list cac thong tin san pham
				// id san pham la duy nhat: example 48718273123
				for (int i=0; i<myTags.length; i++) {
//					list.add(this.hex(myTags[i].GetId()));
					System.out.println("EPC: " + this.hex(myTags[i].GetId()));
				}
			}
			myReader.Disconnect();
		}catch(Exception ex) {
			System.out.println(ex);
			if(myReader != null) {
				try {
					myReader.Disconnect();
				} catch (CAENRFIDException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return list;
	}
	
	/*
	 * @return tra ve mot chuoi duoc in hoa
	 */
	public static String hex(byte[] bytes) {
		StringBuilder result = new StringBuilder();
		for(byte aByte : bytes) {
			result.append(String.format("%02x", aByte));
		}
		return result.toString().toUpperCase();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
