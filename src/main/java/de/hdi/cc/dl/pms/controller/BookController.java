package de.hdi.cc.dl.pms.controller;

import de.hdi.cc.dl.pms.model.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

	@GetMapping(path = "api/books")
	public ResponseEntity<List<Book>> getAllBooks(){
		return ResponseEntity.noContent().build();
	}
}
