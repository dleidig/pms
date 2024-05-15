package de.hdi.cc.dl.pms.service;

import de.hdi.cc.dl.pms.model.Book;
import de.hdi.cc.dl.pms.repo.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

	@InjectMocks
	private BookService bookService;

	@Mock
	private BookRepository bookRepository;

	@Test
	public void testFindBooks() {
		var book1 = new Book(1L, "Book1", BigDecimal.ONE, "isbn1","1");
		var book2 = new Book(2L, "Book2", BigDecimal.TEN, "isbn2","2");

		List<Book> expectedBooks = Arrays.asList(book1, book2);
		when(bookRepository.getItems()).thenReturn(expectedBooks);
		List<Book> actualBooks = bookService.findAllBooks();
		assertEquals(expectedBooks, actualBooks);
	}
}
