package net.javaguides.springboot.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "detail")
public class Detail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "book_id")
	private String bookId;
	
	@ManyToOne
	@JoinColumn(name = "bookdetail")
    private Book bookdetail;

	@Column(name = "returned_date")
	private java.util.Date returnedDate;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "note")
	private Boolean note;
	
//	@ManyToOne
//	@JoinColumn(name = "category")
//    private CategoryEntity category;
	
	@ManyToOne
	@JoinColumn(name = "borrow")
    private Borrow borrow;

	public Detail() {
		super();
	}

	
	public Detail(long id, String bookId, Book bookdetail, Date returnedDate, String status, Boolean note,
			Borrow borrow) {
		super();
		this.id = id;
		this.bookId = bookId;
		this.bookdetail = bookdetail;
		this.returnedDate = returnedDate;
		this.status = status;
		this.note = note;
		this.borrow = borrow;
	}


	public Book getBookdetail() {
		return bookdetail;
	}


	public void setBookdetail(Book bookdetail) {
		this.bookdetail = bookdetail;
	}


	public String getBookId() {
		return bookId;
	}

	public void setBookId(String book) {
		this.bookId = book;
	}

	public java.util.Date getReturnedDate() {
		return returnedDate;
	}

	public void setReturnedDate(java.util.Date returnedDate) {
		this.returnedDate = returnedDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Boolean getNote() {
		return note;
	}

	public void setNote(Boolean note) {
		this.note = note;
	}

	public Borrow getBorrow() {
		return borrow;
	}

	public void setBorrow(Borrow borrow) {
		this.borrow = borrow;
	}
	
	

}