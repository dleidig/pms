package de.hdi.cc.dl.pms.filereader;

import java.util.List;
import java.util.function.Function;

public interface FileReader {
	<T> List<T> readFile(String filePath, Function<String, T> mappingFunction);
}
