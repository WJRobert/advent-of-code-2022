package nl.wayne.j.robert.advent.of.code.util;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReader {

    public FileReader() {
    }

    public List<String> readInput(String filePath) {
        List<String> fileLines = new ArrayList<>();
        try {
            Path path = Paths.get(getClass().getClassLoader().getResource(filePath).toURI());
            fileLines = Files.readAllLines(path);
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
        return fileLines;
    }
}
