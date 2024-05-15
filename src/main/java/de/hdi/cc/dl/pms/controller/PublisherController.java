package de.hdi.cc.dl.pms.controller;

import de.hdi.cc.dl.pms.model.Publisher;
import de.hdi.cc.dl.pms.service.BookService;
import de.hdi.cc.dl.pms.service.PublisherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * Rest Controller for the publisher entity
 */
@RestController
public class PublisherController {

	private final PublisherService service;

	public PublisherController(PublisherService service){
		this.service = service;
	}

	@GetMapping(path = "api/publishers")
	public ResponseEntity<List<Publisher>> getAllPublishers(){
		return ResponseEntity.of(Optional.ofNullable(service.findAllPublishers()));
	}
}
