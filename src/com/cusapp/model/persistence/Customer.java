package com.cusapp.model.persistence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="cust_table")
public class Customer {
	@Id@GeneratedValue
	private int custId;
	@NotEmpty(message="name can't be empty")
	private String custName;
	@NotEmpty(message="mobile can't be empty")
	private String mobile;
	@Email
	@NotEmpty(message="email can't be empty")
	
	private String email;
	
	
	
	public Customer() {
		
		
	}
	public Customer(String custName, String mobile, String email) {
		super();
		this.custName = custName;
		this.mobile = mobile;
		this.email = email;
	}
	public Customer(int custId, String custName, String mobile, String email) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.mobile = mobile;
		this.email = email;
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
