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

    public List<Integer> readIntInput(String filePath) {
        List<Integer> fileLines = new ArrayList<>();
        try {
            Path path = Paths.get(getClass().getClassLoader().getResource(filePath).toURI());
            Stream<String> lines = Files.lines(path);
            fileLines = lines
                    .map(Integer::valueOf)
                    .collect(Collectors.toList());
            lines.close();
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
        return fileLines;
    }

    public List<Long> readLongInput(String filePath) {
        List<Long> fileLines = new ArrayList<>();
        try {
            Path path = Paths.get(getClass().getClassLoader().getResource(filePath).toURI());
            Stream<String> lines = Files.lines(path);
            fileLines = lines
                    .map(Long::valueOf)
                    .collect(Collectors.toList());
            lines.close();
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
        return fileLines;
    }

    public List<String> readInput(String filePath) {
        List<String> fileLines = new ArrayList<>();
        try {
            Path path = Paths.get(getClass().getClassLoader().getResource(filePath).toURI());
            Stream<String> lines = Files.lines(path);
            fileLines = lines
                    .collect(Collectors.toList());
            lines.close();
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
        return fileLines;
    }
}
