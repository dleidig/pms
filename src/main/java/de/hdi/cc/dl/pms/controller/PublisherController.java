package de.hdi.cc.dl.pms.controller;

import de.hdi.cc.dl.pms.model.Publisher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Rest Controller for the publisher entity
 */
@RestController
public class PublisherController {

	@GetMapping(path = "api/publishers")
	public ResponseEntity<List<Publisher>> getAllPublishers(){
		return ResponseEntity.noContent().build();
	}
}
