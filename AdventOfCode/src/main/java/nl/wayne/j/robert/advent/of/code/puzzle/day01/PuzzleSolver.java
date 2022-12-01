package nl.wayne.j.robert.advent.of.code.puzzle.day01;

import nl.wayne.j.robert.advent.of.code.util.FileReader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PuzzleSolver {

    private FileReader adventFileReader;

    public PuzzleSolver() {
        this.adventFileReader = new FileReader();
    }

    public int solvePuzzleOne(String inputFilePath) {
        List<String> inputLines = adventFileReader.readInput(inputFilePath);
        int totalCalories = 0;
        int mostCalories = 0;
        for (String input: inputLines) {
            if (input == null || input.trim().isBlank()) {
                if (mostCalories < totalCalories) {
                    mostCalories = totalCalories;
                }
                totalCalories = 0;
            } else {
                totalCalories += Integer.parseInt(input);
            }
        }
        return mostCalories;
    }

    public int solvePuzzleTwo(String inputFilePath) {
        List<String> inputLines = adventFileReader.readInput(inputFilePath);
        List<Integer> elfCalories = new ArrayList<>();
        int totalCalories = 0;
        for (String input: inputLines) {
            if (input == null || input.trim().isBlank()) {
                elfCalories.add(totalCalories);
                totalCalories = 0;
            } else {
                totalCalories += Integer.parseInt(input);
            }
        }
        elfCalories.add(totalCalories);
        Collections.sort(elfCalories, Collections.reverseOrder());
        return elfCalories.get(0) + elfCalories.get(1) + elfCalories.get(2);
    }
}
