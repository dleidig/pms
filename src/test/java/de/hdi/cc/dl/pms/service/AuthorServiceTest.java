package de.hdi.cc.dl.pms.service;

import de.hdi.cc.dl.pms.model.Author;
import de.hdi.cc.dl.pms.model.Book;
import de.hdi.cc.dl.pms.repo.AuthorRepository;
import de.hdi.cc.dl.pms.repo.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AuthorServiceTest {

	@InjectMocks
	private AuthorService authorService;

	@Mock
	private AuthorRepository authorRepository;
	
	@Test
	public void testFindAuthors() {
		var author1 = new Author(1L, "test", "test", 1L);
		var author2 = new Author(2L, "test", "test", 2L);

		List<Author> expectedAuthors = Arrays.asList(author1, author2);
		when(authorRepository.getItems()).thenReturn(expectedAuthors);
		List<Author> actualAuthors = authorService.findAllAuthors();
		assertEquals(expectedAuthors, actualAuthors);
	}
}
