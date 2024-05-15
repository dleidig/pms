package de.hdi.cc.dl.pms.repo;

import de.hdi.cc.dl.pms.model.Author;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AuthorRepository implements PmsRepository<Author> {

	private List<Author> authors;

	public AuthorRepository(){
		loadItems();
	}

	@Override
	public void loadItems() {
		authors = List.of();
	}

	@Override
	public List<Author> getItems(){
		return authors;
	}
}
