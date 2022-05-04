package net.javaguides.springboot.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tag_read")
public class TagRead {
	
	@Id
	private String tagRfid;
	
	@Column(name = "tag_time")
	private java.util.Date tagTime;
	
	@ManyToOne
	@JoinColumn(name = "book")
    private Book book;
	
	
	public TagRead() {
		super();
	}

	public TagRead(String tagRfid, Date tagTime, Book book) {
		super();
		this.tagRfid = tagRfid;
		this.tagTime = tagTime;
		this.book = book;
	}

	public String getTagRfid() {
		return tagRfid;
	}

	public void setTagRfid(String tagRfid) {
		this.tagRfid = tagRfid;
	}

	public java.util.Date getTagTime() {
		return tagTime;
	}

	public void setTagTime(java.util.Date tagTime) {
		this.tagTime = tagTime;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	
	
	

}
