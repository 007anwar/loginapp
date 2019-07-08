package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Uuser {
	@Id
	@Column(name = "id")
private int id;
@Override
public String toString() {
	return "User [id=" + id + ", name=" + name + ", Email=" + Email + ", password=" + password + "]";
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return Email;
}
public void setEmail(String email) {
	Email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
@Column(name = "name")
private String name;
@Column(name = "Email")
private String Email;
@Column(name = "password")
private String password;
}
