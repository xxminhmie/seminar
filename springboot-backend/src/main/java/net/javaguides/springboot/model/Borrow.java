package net.javaguides.springboot.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "borrow")
public class Borrow {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "card_id")
	private long cardId;

	@Column(name = "borrow_date")
	private java.util.Date borrowDate;
	
//	@OneToMany(mappedBy = "category")
//	private List<NewsEntity> news = new ArrayList<>();
	
	@OneToMany(mappedBy = "borrow")
	private List<Detail> details = new ArrayList<>();
	

	public Borrow(long id, long cardId, Date borrowDate) {
		super();
		this.id = id;
		this.cardId = cardId;
		this.borrowDate = borrowDate;
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

	public long getCardId() {
		return cardId;
	}

	public void setCardId(long cardId) {
		this.cardId = cardId;
	}

	public java.util.Date getBorrowDate() {
		return borrowDate;
	}

	public void setBorrow_date(java.util.Date borrowDate) {
		this.borrowDate = borrowDate;
	}
	
	
}
