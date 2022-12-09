package nl.wayne.j.robert.advent.of.code.puzzle.day03;

import nl.wayne.j.robert.advent.of.code.util.FileReader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PuzzleSolver {

    private FileReader adventFileReader;

    public PuzzleSolver() {
        this.adventFileReader = new FileReader();
    }

    public int solvePuzzleOne(String inputFilePath) {
        List<String> inputs = adventFileReader.readInput(inputFilePath);
        Map<Character, Integer> scoreCard = generateScoreCard();
        int sum = 0;
        for (String backpack : inputs) {
            int compartmentSize = backpack.length() / 2;
            char commonItem = findCommonItem(backpack.substring(0, compartmentSize), backpack.substring(compartmentSize));
            sum += scoreCard.get(commonItem);
        }
        return sum;
    }

    private Map<Character, Integer> generateScoreCard() {
        Map<Character, Integer> scoreCard = new HashMap<>();
        int count = 0;
        for (char item : "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray()) {
            count++;
            scoreCard.put(item, count);
        }

        return scoreCard;
    }

    private char findCommonItem(String compartment1, String compartment2) {
        for (char item1 : compartment1.toCharArray()) {
            for (char item2 : compartment2.toCharArray()) {
                if (item1 == item2) {
                    return item1;
                }
            }
        }
        return '1';
    }

    public int solvePuzzleTwo(String inputFilePath) {
        List<String> inputs = adventFileReader.readInput(inputFilePath);
        Map<Character, Integer> scoreCard = generateScoreCard();
        AtomicInteger sum = new AtomicInteger();
        elfGroups(inputs).forEach(group -> {
            char badge = getBatchForGroup(group);
            sum.addAndGet(scoreCard.get(badge));
        });

        return sum.get();
    }

    private Stream<List<String>> elfGroups(List<String> inputs) {
        int size = inputs.size();
        int fullChunks = (size - 1) / 3;
        return IntStream.range(0, fullChunks + 1).mapToObj(
                n -> inputs.subList(n * 3, n == fullChunks ? size : (n + 1) * 3));
    }

    private char getBatchForGroup(List<String> groupBags) {
        for (char groupOneChar : groupBags.get(0).toCharArray()) {
            for (char groupTwoChar : groupBags.get(1).toCharArray()) {
                if (groupOneChar == groupTwoChar) {
                    for (char groupThreeChar : groupBags.get(2).toCharArray()) {
                        if (groupOneChar == groupThreeChar) {
                            return groupThreeChar;
                        }
                    }
                    break;
                }
            }
        }
        return '0';
    }
}
