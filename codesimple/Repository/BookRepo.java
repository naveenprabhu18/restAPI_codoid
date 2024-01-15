package com.codesimple.codesimple.Repository;


import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codesimple.codesimple.entitybook.Book;
import org.springframework.data.domain.Pageable;
@Repository
public interface BookRepo  extends CrudRepository<Book,Integer>{

	List<Book> findAllByidInAndName(Set<Integer> age, String naam);

	public List<Book> findByMarks(int marks);

	Page<Book> findAll(Pageable page);

	

	

	

}
