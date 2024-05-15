package de.hdi.cc.dl.pms.controller;

import de.hdi.cc.dl.pms.model.Book;
import de.hdi.cc.dl.pms.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * Rest Controller for the book entity
 */
@RestController
public class BookController {

	private final BookService service;

	public BookController(BookService service){
		this.service = service;
	}

	@GetMapping(path = "api/books")
	public ResponseEntity<List<Book>> getAllBooks(){
		return ResponseEntity.of(Optional.ofNullable(service.findAllBooks()));
	}
}
