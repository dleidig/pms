package de.hdi.cc.dl.pms.controller;

import de.hdi.cc.dl.pms.model.Author;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthorController {

	@GetMapping(path = "api/authors")
	public ResponseEntity<List<Author>> getAllAuthors(){
		return ResponseEntity.noContent().build();
	}
}
