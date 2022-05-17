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
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; //EPC
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "login_name")
	private String loginName;
	
	@Column(name = "password")
	private String password;
	
//	@OneToMany(mappedBy = "user")
//	private List<Borrow> borrows = new ArrayList<>();

	public User(Long id, String name, String phone, String loginName, String password, List<Borrow> borrows) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.loginName = loginName;
		this.password = password;
//		this.borrows = borrows;
	}

	public User() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

//	public List<Borrow> getBorrows() {
//		return borrows;
//	}
//
//	public void setBorrows(List<Borrow> borrows) {
//		this.borrows = borrows;
//	}
	
	

}
