package com.codesimple.codesimple.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.codesimple.codesimple.Repository.BookRepo;
import com.codesimple.codesimple.entitybook.Book;

@Service
public class Bookservice {
	
	
	@Autowired
	private BookRepo bookRepo;
	
	public List<Book>seviceb(Set<Integer> age,String naam) {
		ArrayList<Book>booklist=new ArrayList<>();
		if(age==null) {
			bookRepo.findAll().forEach(booksql->booklist.add(booksql));
		}
		else {
			return bookRepo.findAllByidInAndName(age,naam);
		}
		

	return booklist;
	}
	public Book insertservicebook(Book book) {
		return bookRepo.save(book);
	}
	public Optional<Book> getbookId(Integer bookid) {
		return bookRepo.findById(bookid);
		
	}
	public Book updatebook(Book bookid) {
		
		return bookRepo.save(bookid);
	}
	public String deleteIdby(Integer bookid) {
		bookRepo.deleteById(bookid);
		return "the value was Deleted";
	}
	public List<Book> findByMarks(int marks){
		return bookRepo.findByMarks(marks);
		
	}
	public Page<Book> getEmployeePage(Integer pageNumber, Integer pageSize, String properties) {
		Sort sort= Sort.by(Sort.Direction.ASC,properties);
		 Pageable page=PageRequest.of(pageNumber,pageSize);
		return  bookRepo.findAll(page);
	}
}
