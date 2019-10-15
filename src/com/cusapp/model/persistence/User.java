package com.cusapp.model.persistence;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="user_table_new", uniqueConstraints={@UniqueConstraint(columnNames={"email"})})

public class User {
	@Id @GeneratedValue
		private int id;
		private String userName;
		
		private String email;
		private String profile;
		
		private String password;
		private boolean active;
		
		
		
		public User() {
			
			
		}
		public User(String userName, String email, String profile, String password, boolean active) {
			super();
			this.userName = userName;
			this.email = email;
			this.profile = profile;
			this.password = password;
			this.active = active;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getProfile() {
			return profile;
		}
		public void setProfile(String profile) {
			this.profile = profile;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public boolean isActive() {
			return active;
		}
		public void setActive(boolean active) {
			this.active = active;
		}
		
		
}

	