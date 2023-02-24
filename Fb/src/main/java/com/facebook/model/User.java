package com.facebook.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="user")
@Table(name="user")
public class User {
@Id
@Column(name="emailid")
 String emailid;
 String password,name,gender,pno;
 

@Override
public String toString() {
	return "User [emailid=" + emailid + ", password=" + password + ", name=" + name + ", gender=" + gender + ", pno="
			+ pno + "]";
}
 
public String getEmailid() {
	return emailid;
}
public void setEmailid(String emailid) {
	this.emailid = emailid;
}
public String getPassword() {
	return password;
}
public User() {
	
}
public User(String emailid, String password, String name, String gender, String pno) {
	
	this.emailid = emailid;
	this.password = password;
	this.name = name;
	this.gender = gender;
	this.pno = pno;
}
public void setPassword(String password) {
	this.password = password;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getPno() {
	return pno;
}
public void setPno(String pno) {
	this.pno = pno;
}
 
}
