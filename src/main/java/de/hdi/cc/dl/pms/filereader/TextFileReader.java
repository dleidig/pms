package de.hdi.cc.dl.pms.filereader;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TextFileReader implements FileReader{

	@Override
	public <T> List<T> readFile(String filePath, Function<String, T> mappingFunction) {
		try (var lines = Files.lines(Path.of(filePath))) {
			return lines.map(mappingFunction)
					.collect(Collectors.toList());
		} catch (IOException ex){
			throw new ResponseStatusException(HttpStatus.NO_CONTENT,"file could not be read",ex.getCause());
		}
	}
}


