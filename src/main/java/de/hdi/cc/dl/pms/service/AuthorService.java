package de.hdi.cc.dl.pms.service;

import de.hdi.cc.dl.pms.model.Author;
import de.hdi.cc.dl.pms.repo.AuthorRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class AuthorService {

	private final AuthorRepository repo;

	public AuthorService(AuthorRepository repo){
		this.repo = repo;
	}

	public List<Author> findAllAuthors(){
		var authors = repo.getItems();
		if(authors.isEmpty()){
			throw new ResponseStatusException(HttpStatus.NO_CONTENT,"no authors found");
		}
		return authors;
	}
}
