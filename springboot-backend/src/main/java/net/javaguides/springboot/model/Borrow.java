package net.javaguides.springboot.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "borrow")
public class Borrow {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "borrow_date")
	private java.util.Date borrowDate;
	
//	@OneToMany(mappedBy = "category")
//	private List<NewsEntity> news = new ArrayList<>();
	
	@Column(name = "due_date")
	private java.util.Date dueDate;
	
	@OneToMany(mappedBy = "borrow")
	private List<Detail> details = new ArrayList<>();
	

	@ManyToOne
	@JoinColumn(name = "user")
    private User user;
	
	
	public Borrow(long id, Date borrowDate, Date dueDate, User user) {
		super();
		this.id = id;
		this.borrowDate = borrowDate;
		this.dueDate = dueDate;
		this.user = user;
	}

	public Borrow() {
		super();
	}

	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public java.util.Date getBorrowDate() {
		return borrowDate;
	}

	public void setBorrow_date(java.util.Date borrowDate) {
		this.borrowDate = borrowDate;
	}

	public java.util.Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(java.util.Date dueDate) {
		this.dueDate = dueDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
