package de.hdi.cc.dl.pms.service;

import de.hdi.cc.dl.pms.model.Book;
import de.hdi.cc.dl.pms.repo.BookRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class BookService {

	private final BookRepository repo;

	public BookService(BookRepository repo){
		this.repo = repo;
	}

	public List<Book> findAllBooks(){
		var books = repo.getItems();
		if(books.isEmpty()){
			throw new ResponseStatusException(HttpStatus.NO_CONTENT,"no books found");
		}
		return books;
	}
}
