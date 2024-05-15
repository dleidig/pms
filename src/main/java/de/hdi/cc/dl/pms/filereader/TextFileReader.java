package de.hdi.cc.dl.pms.filereader;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.function.Function;

/**
 * Textfile Implementation of the FileReader interface.
 * Requires the caller to implement the mapping functionality
 */
public class TextFileReader implements FileReader{

	@Override
	public <T> List<T> readFile(String filePath, Function<String, T> mappingFunction) {
		try (var lines = Files.lines(Path.of(filePath))) {
			return lines.map(mappingFunction).toList();
		} catch (IOException ex){
			throw new ResponseStatusException(HttpStatus.NO_CONTENT,"file could not be read",ex.getCause());
		}
	}
}


