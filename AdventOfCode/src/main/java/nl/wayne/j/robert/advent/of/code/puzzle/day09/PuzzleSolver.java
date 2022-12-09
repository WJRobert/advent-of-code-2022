package nl.wayne.j.robert.advent.of.code.puzzle.day09;

import nl.wayne.j.robert.advent.of.code.util.FileReader;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PuzzleSolver {
    private FileReader adventFileReader;

    public PuzzleSolver() {
        this.adventFileReader = new FileReader();
    }

    public int solvePuzzleOne(String inputFilePath) {
        int[] tail = new int[]{0, 0};
        int[] head = new int[]{0, 0};
        Set<String> visitedPositions = new HashSet<>();
        List<String> inputLines = adventFileReader.readInput(inputFilePath);
        for (String input : inputLines) {
            char movement = input.charAt(0);
            int moves = Integer.parseInt(input.substring(2));
            while (moves > 0) {
                switch (movement) {
                    case 'R':
                        head[0] += 1;
                        tail = calculateTailAndAddPosition(tail, head, visitedPositions);
                        break;
                    case 'L':
                        head[0] -= 1;
                        tail = calculateTailAndAddPosition(tail, head, visitedPositions);
                        break;
                    case 'D':
                        head[1] -= 1;
                        tail = calculateTailAndAddPosition(tail, head, visitedPositions);
                        break;
                    case 'U':
                        head[1] += 1;
                        tail = calculateTailAndAddPosition(tail, head, visitedPositions);
                        break;
                }
                moves--;
            }
        }
        return visitedPositions.size();
    }

    private int[] calculateTailAndAddPosition(int[] tail, int[] head, Set<String> visitedPositions) {
        tail = calculateTailsNewPosition(head, tail);
        visitedPositions.add(tail[0] + "," + tail[1]);
        return tail;
    }

    private int[] calculateTailsNewPosition(int[] head, int[] tail) {

        if (Math.abs(head[0] - tail[0]) <= 1 && Math.abs(head[1] - tail[1]) <= 1) {// Check if no movement needed
            return tail;
        }
        if (head[1] == tail[1]) {// Check if same row
            if (head[0] > tail[0]) {
                tail[0] += 1;
            } else {
                tail[0] -= 1;
            }
        } else if (head[0] == tail[0]) {//Check if same column
            if (head[1] > tail[1]) {
                tail[1] += 1;
            } else {
                tail[1] -= 1;
            }
        } else {
            if (head[0] > tail[0]) {
                tail[0] += 1;
            } else {
                tail[0] -= 1;
            }

            if (head[1] > tail[1]) {
                tail[1] += 1;
            } else {
                tail[1] -= 1;
            }

        }
        return tail;
    }

    public int solvePuzzleTwo(String inputFilePath) {
        int[] knot1 = new int[]{0, 0};
        int[] knot2 = new int[]{0, 0};
        int[] knot3 = new int[]{0, 0};
        int[] knot4 = new int[]{0, 0};
        int[] knot5 = new int[]{0, 0};
        int[] knot6 = new int[]{0, 0};
        int[] knot7 = new int[]{0, 0};
        int[] knot8 = new int[]{0, 0};
        int[] knot9 = new int[]{0, 0};
        int[] head = new int[]{0, 0};
        Set<String> visitedPositions = new HashSet<>();
        List<String> inputLines = adventFileReader.readInput(inputFilePath);
        for (String input : inputLines) {
            char movement = input.charAt(0);
            int moves = Integer.parseInt(input.substring(2));
            while (moves > 0) {
                switch (movement) {
                    case 'R':
                        head[0] += 1;
                        knot1 = calculateTailsNewPosition(head, knot1);
                        knot2 = calculateTailsNewPosition(knot1, knot2);
                        knot3 = calculateTailsNewPosition(knot2, knot3);
                        knot4 = calculateTailsNewPosition(knot3, knot4);
                        knot5 = calculateTailsNewPosition(knot4, knot5);
                        knot6 = calculateTailsNewPosition(knot5, knot6);
                        knot7 = calculateTailsNewPosition(knot6, knot7);
                        knot8 = calculateTailsNewPosition(knot7, knot8);
                        knot9 = calculateTailsNewPosition(knot8, knot9);
                        visitedPositions.add(knot9[0] + "," + knot9[1]);
                        break;
                    case 'L':
                        head[0] -= 1;
                        knot1 = calculateTailsNewPosition(head, knot1);
                        knot2 = calculateTailsNewPosition(knot1, knot2);
                        knot3 = calculateTailsNewPosition(knot2, knot3);
                        knot4 = calculateTailsNewPosition(knot3, knot4);
                        knot5 = calculateTailsNewPosition(knot4, knot5);
                        knot6 = calculateTailsNewPosition(knot5, knot6);
                        knot7 = calculateTailsNewPosition(knot6, knot7);
                        knot8 = calculateTailsNewPosition(knot7, knot8);
                        knot9 = calculateTailsNewPosition(knot8, knot9);
                        visitedPositions.add(knot9[0] + "," + knot9[1]);
                        break;
                    case 'D':
                        head[1] -= 1;
                        knot1 = calculateTailsNewPosition(head, knot1);
                        knot2 = calculateTailsNewPosition(knot1, knot2);
                        knot3 = calculateTailsNewPosition(knot2, knot3);
                        knot4 = calculateTailsNewPosition(knot3, knot4);
                        knot5 = calculateTailsNewPosition(knot4, knot5);
                        knot6 = calculateTailsNewPosition(knot5, knot6);
                        knot7 = calculateTailsNewPosition(knot6, knot7);
                        knot8 = calculateTailsNewPosition(knot7, knot8);
                        knot9 = calculateTailsNewPosition(knot8, knot9);
                        visitedPositions.add(knot9[0] + "," + knot9[1]);
                        break;
                    case 'U':
                        head[1] += 1;
                        knot1 = calculateTailsNewPosition(head, knot1);
                        knot2 = calculateTailsNewPosition(knot1, knot2);
                        knot3 = calculateTailsNewPosition(knot2, knot3);
                        knot4 = calculateTailsNewPosition(knot3, knot4);
                        knot5 = calculateTailsNewPosition(knot4, knot5);
                        knot6 = calculateTailsNewPosition(knot5, knot6);
                        knot7 = calculateTailsNewPosition(knot6, knot7);
                        knot8 = calculateTailsNewPosition(knot7, knot8);
                        knot9 = calculateTailsNewPosition(knot8, knot9);
                        visitedPositions.add(knot9[0] + "," + knot9[1]);
                        break;
                }
                moves--;
            }
        }
        return visitedPositions.size();
    }

}
