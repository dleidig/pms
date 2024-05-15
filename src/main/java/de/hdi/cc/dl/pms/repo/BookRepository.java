package de.hdi.cc.dl.pms.repo;

import de.hdi.cc.dl.pms.filereader.FileReader;
import de.hdi.cc.dl.pms.filereader.TextFileReader;
import de.hdi.cc.dl.pms.model.Book;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.List;

/**
 * Textfile based repo implementation of the PmsRepository.
 * Loads the file on bean instantiation and splits all columns by semicolon
 * throws a ResponseStatusException on errors
 */
@Repository
public class BookRepository implements PmsRepository<Book> {

	private final FileReader fileReader;
	private List<Book> books;

	public BookRepository(){
		this.fileReader = new TextFileReader();
		loadItems();
	}

	@Override
	public void loadItems(){
		books = fileReader.readFile("src/main/resources/persistence/txt/books.txt",this::mapLineToBook);
	}

	@Override
	public List<Book> getItems(){
		return books;
	}

	private Book mapLineToBook(String line){
		try{
			String[] values = line.split(";");
			for (String value : values) {
				if (value.trim().isBlank()) {
					throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Invalid data format: Empty value found in resource");
				}
			}
			return new Book(Long.parseLong(values[0]), values[1], new BigDecimal(values[2]),values[3],values[4]);
		} catch (Exception ex){
			throw new ResponseStatusException(HttpStatus.NO_CONTENT,"error during resource array parsing",ex.getCause());
		}
	}
}
