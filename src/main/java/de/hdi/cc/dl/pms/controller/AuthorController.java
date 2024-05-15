package de.hdi.cc.dl.pms.controller;

import de.hdi.cc.dl.pms.model.Author;
import de.hdi.cc.dl.pms.service.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * Rest Controller for the author entity
 */
@RestController
public class AuthorController {

	private final AuthorService service;

	public AuthorController(AuthorService service){
		this.service = service;
	}

	@GetMapping(path = "api/authors")
	public ResponseEntity<List<Author>> getAllAuthors(){
		return ResponseEntity.of(Optional.ofNullable(service.findAllAuthors()));
	}
}
