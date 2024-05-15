package de.hdi.cc.dl.pms.repo;

import de.hdi.cc.dl.pms.filereader.FileReader;
import de.hdi.cc.dl.pms.filereader.TextFileReader;
import de.hdi.cc.dl.pms.model.Publisher;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

/**
 * Textfile based repo implementation of the PmsRepository.
 * Loads the file on bean instantiation and splits all columns by semicolon
 * throws a ResponseStatusException on errors
 */
@Repository
public class PublisherRepository implements PmsRepository<Publisher> {

	private final FileReader fileReader;
	private List<Publisher> publishers;

	public PublisherRepository(){
		this.fileReader = new TextFileReader();
		loadItems();
	}

	@Override
	public void loadItems() {
		publishers = fileReader.readFile("src/main/resources/persistence/txt/publishers.txt",this::mapLineToPublisher);
	}

	@Override
	public List<Publisher> getItems(){
		return publishers;
	}

	private Publisher mapLineToPublisher(String line){
		try{
			String[] values = line.split(";");
			for (String value : values) {
				if (value.trim().isBlank()) {
					throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Invalid data format: Empty value found in resource");
				}
			}
			return new Publisher(Long.parseLong(values[0]), values[1]);
		} catch (Exception ex){
			throw new ResponseStatusException(HttpStatus.NO_CONTENT,"error during resource array parsing",ex.getCause());
		}
	}
}
