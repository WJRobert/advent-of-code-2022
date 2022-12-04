package nl.wayne.j.robert.advent.of.code.puzzle.day04;

import nl.wayne.j.robert.advent.of.code.util.FileReader;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PuzzleSolver {
    private final FileReader adventFileReader;

    public PuzzleSolver() {
        this.adventFileReader = new FileReader();
    }

    public int solvePuzzleOne(String inputFilePath) {
        List<String> inputLines = adventFileReader.readInput(inputFilePath);
        int overlappingPairs = 0;
        for (String input : inputLines) {
            String[] ranges = input.split(",");
            if (fullyContainsOne(getElfRange(ranges[0]), getElfRange(ranges[1]))) {
                overlappingPairs++;
            }
        }
        return overlappingPairs;
    }

    private int[] getElfRange(String range) {
        String[] elfRanges = range.split("-");
        return new int[]{Integer.parseInt(elfRanges[0]), Integer.parseInt(elfRanges[1])};
    }

    private boolean fullyContainsOne(int[] rangeOne, int[] rangeTwo) {
        return (rangeOne[0] <= rangeTwo[0] && rangeOne[1] >= rangeTwo[1])
                || (rangeTwo[0] <= rangeOne[0] && rangeTwo[1] >= rangeOne[1]);
    }

    public int solvePuzzleTwo(String inputFilePath) {
        List<String> inputLines = adventFileReader.readInput(inputFilePath);
        int overlappingPairs = 0;
        for (String input : inputLines) {
            String[] ranges = input.split(",");
            if (pairOverlaps(getElfRange(ranges[0]), getElfRange(ranges[1]))) {
                overlappingPairs++;
            }
        }
        return overlappingPairs;
    }

    private boolean pairOverlaps(int[] rangeOne, int[] rangeTwo) {
        List<Integer> elfOneFullRange = getPopulateRange(rangeOne[0], rangeOne[1]);
        List<Integer> elfTwoFullRange = getPopulateRange(rangeTwo[0], rangeTwo[1]);
        List<Integer> overlapping = elfOneFullRange.stream().filter(
                x -> elfTwoFullRange.stream().anyMatch(y -> y == x)
        ).collect(Collectors.toList());
        return !overlapping.isEmpty();
    }

    private List<Integer> getPopulateRange(int min, int max) {
        List<Integer> populatedRange = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            populatedRange.add(i);
        }
        return populatedRange;
    }
}
