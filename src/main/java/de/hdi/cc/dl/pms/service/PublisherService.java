package de.hdi.cc.dl.pms.service;

import de.hdi.cc.dl.pms.model.Publisher;
import de.hdi.cc.dl.pms.repo.PublisherRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PublisherService {

	private final PublisherRepository repo;

	public PublisherService(PublisherRepository repo){
		this.repo = repo;
	}

	public List<Publisher> findAllPublishers(){
		var books = repo.getItems();
		if(books.isEmpty()){
			throw new ResponseStatusException(HttpStatus.NO_CONTENT,"no publishers found");
		}
		return books;
	}
}
