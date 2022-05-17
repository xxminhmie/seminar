package net.javaguides.springboot.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateParsedDemo {
	
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
		System.out.println("parsed:  " + parsed);
        return parsed;
		
	}

	
	public static void main(String[] args) {
		
		
		Date startedDate = convertStringToDate("2022-04-30");
		Date returnedDate = convertStringToDate("2022-05-04");
//		Date futureDate = convertStringToDate("2022-05-21");
		
		if(returnedDate.after(startedDate)) {
			System.out.print("ok");
		}
//		
//		if(!todayDate.before(futureDate)) {
//			System.out.print("before method");
//		}
		
	}
	

}
