package de.hdi.cc.dl.pms.repo;

import de.hdi.cc.dl.pms.filereader.FileReader;
import de.hdi.cc.dl.pms.filereader.TextFileReader;
import de.hdi.cc.dl.pms.model.Book;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class BookRepository implements PmsRepository<Book> {

	private List<Book> books;
	private final FileReader fileReader;

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
		String[] values = line.split(";");
		return new Book(Long.parseLong(values[0]), values[1], new BigDecimal(values[2]),values[3],values[4]);
	}
}
