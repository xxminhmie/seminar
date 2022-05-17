package net.javaguides.springboot.model;

import java.util.Date;

public class Statistics {
	private String bookName;
	private String loginName;
	private Date borrowDate;
	private Date dueDate;
	private Date returnedDate;
	private String status;
	
	public Statistics() {
		super();
	}
	public Statistics(String bookName, String loginName, Date borrowDate, Date dueDate, Date returnedDate,
			String status) {
		super();
		this.bookName = bookName;
		this.loginName = loginName;
		this.borrowDate = borrowDate;
		this.dueDate = dueDate;
		this.returnedDate = returnedDate;
		this.status = status;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public Date getBorrowDate() {
		return borrowDate;
	}
	public void setBorrowDate(Date borrowDate) {
		this.borrowDate = borrowDate;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public Date getReturnedDate() {
		return returnedDate;
	}
	public void setReturnedDate(Date returnedDate) {
		this.returnedDate = returnedDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
