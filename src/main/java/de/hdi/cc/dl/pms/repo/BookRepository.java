package de.hdi.cc.dl.pms.repo;

import de.hdi.cc.dl.pms.model.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepository implements PmsRepository<Book> {

	/**
	 * final because we do not need put/delete/post functionality
	 */
	private List<Book> books;

	public BookRepository(){
		loadItems();
	}

	@Override
	public void loadItems() {
		books = List.of();
	}

	@Override
	public List<Book> getItems(){
		return books;
	}
}
