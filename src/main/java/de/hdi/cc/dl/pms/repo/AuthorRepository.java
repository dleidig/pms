package de.hdi.cc.dl.pms.repo;

import de.hdi.cc.dl.pms.filereader.FileReader;
import de.hdi.cc.dl.pms.filereader.TextFileReader;
import de.hdi.cc.dl.pms.model.Author;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Repository
public class AuthorRepository implements PmsRepository<Author> {

	private final FileReader fileReader;
	private List<Author> authors;

	public AuthorRepository(){
		this.fileReader = new TextFileReader();
		loadItems();
	}

	@Override
	public void loadItems() {
		authors = fileReader.readFile("src/main/resources/persistence/txt/authors.txt", this::mapLineToAuthor);
	}

	@Override
	public List<Author> getItems(){
		return authors;
	}

	private Author mapLineToAuthor(String line){
		try{
			String[] values = line.split(";");
			for (String value : values) {
				if (value.trim().isBlank()) {
					throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Invalid data format: Empty value found in resource");
				}
			}
			return new Author(Long.parseLong(values[0]), values[1], values[2], Long.parseLong(values[3]));
		} catch (Exception ex){
			throw new ResponseStatusException(HttpStatus.NO_CONTENT,"error during resource array parsing", ex.getCause());
		}
	}
}
