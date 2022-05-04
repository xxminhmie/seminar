package net.javaguides.springboot.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Book {

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id; //EPC

	@Column(name = "book_name")
	private String bookName;

	@Column(name = "author_name")
	private String authorName;

	@Column(name = "category")
	private String category;

	@Column(name = "publisher")
	private String publisher;

	@Column(name = "year")
	private Integer year;
	
	@OneToMany(mappedBy = "book")
	private List<TagRead> tagReads = new ArrayList<>();
	
	@OneToMany(mappedBy = "bookdetail")
	private List<Detail> details = new ArrayList<>();
	

	public Book() {

	}

	public Book(String id, String bookName, String authorName, String category, String publisher, Integer year) {
		super();
		this.id = id;
		this.bookName = bookName;
		this.authorName = authorName;
		this.category = category;
		this.publisher = publisher;
		this.year = year;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	

}
