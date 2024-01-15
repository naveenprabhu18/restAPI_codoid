package com.codesimple.codesimple.entitybook;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="booklist")
public class Book {
	
	private String name;
	@Id
	private int id;
	private int marks;
	
	
	
	public Book() {
		
	}
	public Book(String name, int id, int marks) {
		
		this.name = name;
		this.id = id;
		this.marks = marks;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}

}
