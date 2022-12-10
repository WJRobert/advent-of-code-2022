package nl.wayne.j.robert.advent.of.code.puzzle.day10;

import nl.wayne.j.robert.advent.of.code.util.FileReader;

import java.util.List;

public class PuzzleSolver {
    private final FileReader adventFileReader;

    public PuzzleSolver() {
        this.adventFileReader = new FileReader();
    }

    public int solvePuzzleOne(String inputFilePath) {
        List<String> inputLines = adventFileReader.readInput(inputFilePath);
        int currentCycle = 1;
        int x = 1;
        int sumOfStrengths = 0;
        for (String input : inputLines) {
            if (input.startsWith("addx")) {
                currentCycle++;
                sumOfStrengths += getUpdateSumOfStrengthsValue(x, currentCycle);
                currentCycle++;
                x += Integer.parseInt(input.substring(5));
                sumOfStrengths += getUpdateSumOfStrengthsValue(x, currentCycle);
            } else {
                currentCycle++;
                sumOfStrengths += getUpdateSumOfStrengthsValue(x, currentCycle);
            }
            if (currentCycle >= 220) {
                return sumOfStrengths;
            }
        }
        return sumOfStrengths;
    }

    private int getUpdateSumOfStrengthsValue(int x, int cycle) {
        int calculatedCycle = cycle - 20;
        if (calculatedCycle == 0 || (calculatedCycle > 0 && calculatedCycle % 40 == 0)) {
            return x * cycle;
        }
        return 0;
    }

    public String solvePuzzleTwo(String inputFilePath) {
        List<String> inputLines = adventFileReader.readInput(inputFilePath);
        int currentCycle = 1;
        int x = 1;
        String[] crtScreen = new String[6];
        int rowIndex = 0;
        StringBuilder currentRow = new StringBuilder();
        currentRow.append(getDrawingString(0, currentCycle));
        for (String input : inputLines) {
            if (input.startsWith("addx")) {
                currentCycle++;
                currentRow.append(getDrawingString(x - 1, currentCycle));
                if (currentCycle % 40 == 0) {
                    crtScreen[rowIndex] = currentRow.toString();
                    currentRow = new StringBuilder();
                    rowIndex++;
                }
                currentCycle++;
                x += Integer.parseInt(input.substring(5));
                currentRow.append(getDrawingString(x - 1, currentCycle));
                if (currentCycle % 40 == 0) {
                    crtScreen[rowIndex] = currentRow.toString();
                    currentRow = new StringBuilder();
                    rowIndex++;
                }
            } else {
                currentCycle++;
                currentRow.append(getDrawingString(x - 1, currentCycle));
                if (currentCycle % 40 == 0) {
                    crtScreen[rowIndex] = currentRow.toString();
                    currentRow = new StringBuilder();
                    rowIndex++;
                }
            }
        }
        return getAndPrintResult(crtScreen);
    }

    private String getDrawingString(int spriteStart, int currentCycle) {
        int currentCol = ((currentCycle) % 40) - 1;
        if (currentCol >= spriteStart && currentCol <= (spriteStart + 2)) {
            return "#";
        }
        return ".";
    }

    private String getAndPrintResult(String[] crtScreen) {
        StringBuilder builder = new StringBuilder();
        for (String row : crtScreen) {
            System.out.println(row);
            builder.append(row).append("\n");
        }
        return builder.toString();
    }
}
