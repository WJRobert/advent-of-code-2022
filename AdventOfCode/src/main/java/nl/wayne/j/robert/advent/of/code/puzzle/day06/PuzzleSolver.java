package nl.wayne.j.robert.advent.of.code.puzzle.day06;

import nl.wayne.j.robert.advent.of.code.util.FileReader;

import java.util.*;

public class PuzzleSolver {

    private FileReader adventFileReader;

    public PuzzleSolver() {
        this.adventFileReader = new FileReader();
    }

    public int solvePuzzleOne(String inputFilePath) {
        return solvePuzzle(inputFilePath, 4);
    }

    public int solvePuzzleTwo(String inputFilePath) {
        return solvePuzzle(inputFilePath, 14);
    }

    private int solvePuzzle(String inputFilePath, int uniqueCount) {
        List<String> inputLines = adventFileReader.readInput(inputFilePath);
        char[] input = inputLines.get(0).toCharArray();

        for (int i=0; i<input.length-uniqueCount; i++) {
            Set<Character> tester = new HashSet<>();
            boolean found = false;
            for (int j=i; j<i+uniqueCount; j++) {
                if (!tester.add(input[j])) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                return i+uniqueCount;
            }
        }
        return -1;
    }
}
