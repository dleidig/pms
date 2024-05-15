package de.hdi.cc.dl.pms.controller;

import de.hdi.cc.dl.pms.model.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.RestClient;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class BookControllerTest {

	private RestClient client;
	@LocalServerPort
	private int port;

	@BeforeEach
	void setup() {
		client = RestClient.builder().baseUrl("http://0.0.0.0:" + port).build();
	}

	@Test
	@DisplayName("api call get all books")
	void testGetAllBooks() {
		var responseEntity = client.get().uri("api/books").retrieve().toEntity(new ParameterizedTypeReference<List<Book>>() {
		});
		assertThat(responseEntity.getStatusCode(),is(HttpStatus.NO_CONTENT));
		assertNull(responseEntity.getBody());
	}
}
