package com.codesimple.codesimple.control;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codesimple.codesimple.entitybook.Book;
import com.codesimple.codesimple.service.Bookservice;

@RestController
public class BookList {
	@Autowired
	private Bookservice bookservice;
	
	@RequestMapping(value="/booking",method=RequestMethod.GET)
	public List<Book>getbook( @RequestParam (value="id",required=false) Set<Integer>age,
	@RequestParam(value="name",required=false)String naam){
	
		return bookservice.seviceb(age,naam);
	}
	@RequestMapping(value="/book",method=RequestMethod.POST)
	public Book insertBook(@RequestBody Book book) {
		return bookservice.insertservicebook(book);
	}
	@RequestMapping(value="/bookbyId/{id}")
		public Optional<Book> getbookbyId(@PathVariable("id") Integer bookid) {
		return bookservice.getbookId(bookid);
	}
	@RequestMapping(value="/bookbyId",method=RequestMethod.PUT)
	public Book updatebook(@RequestBody Book bookid) {
		return bookservice.updatebook(bookid);
}
	@RequestMapping(value="/deletebyId/{bookid}",method=RequestMethod.DELETE)
    public String deleteId(@PathVariable Integer bookid) {
		return bookservice.deleteIdby(bookid);
    	
    }
	@GetMapping("/getbook/{marks}")
	public List<Book> getByMarks(@PathVariable int marks){
		return bookservice.findByMarks(marks);
	}
	// pagenumber defines the no of page and pagesize defines the no of elements
	@RequestMapping(value="/getpagesize/{pageNumber}/{pageSize}/{name}",method=RequestMethod.GET)
	public Page<Book> BookPagination(@PathVariable Integer pageNumber,@PathVariable Integer pageSize,@PathVariable String name){
		return bookservice.getEmployeePage(pageNumber,pageSize, name);
	}
	
}
