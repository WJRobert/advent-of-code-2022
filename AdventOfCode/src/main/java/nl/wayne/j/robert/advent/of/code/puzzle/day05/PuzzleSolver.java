package nl.wayne.j.robert.advent.of.code.puzzle.day05;

import nl.wayne.j.robert.advent.of.code.util.FileReader;

import java.util.List;
import java.util.Stack;

public class PuzzleSolver {
    private final FileReader adventFileReader;
    private final String[][] crateInput = {
            {"R", "N", "P", "G"},
            {"T", "J", "B", "L", "C", "S", "V", "H"},
            {"T", "D", "B", "M", "N", "L"},
            {"R", "V", "P", "S", "B"},
            {"G", "C", "Q", "S", "W", "M", "V", "H"},
            {"W", "Q", "S", "C", "D", "B", "J"},
            {"F", "Q", "L"},
            {"W", "M", "H", "T", "D", "L", "F", "V"},
            {"L", "P", "B", "V", "M", "J", "F"}
    };
    private Stack<String>[] stacks;

    public PuzzleSolver() {
        this.adventFileReader = new FileReader();
        populateCrates();
    }

    private void populateCrates() {
        stacks = new Stack[crateInput.length];
        for (int i = 0; i < crateInput.length; i++) {
            stacks[i] = new Stack<>();
            for (String crate : crateInput[i]) {
                stacks[i].push(crate);
            }
        }
    }

    public String solvePuzzleOne(String inputFilePath) {
        List<String> inputLines = adventFileReader.readInput(inputFilePath);
        for (String input : inputLines) {
            Movement movement = getMovement(input);

            for (int i = 1; i <= movement.toMove; i++) {
                String crate = stacks[movement.fromStack].pop();
                stacks[movement.toStack].push(crate);
            }
        }
        return getTopCrates();
    }

    private Movement getMovement(String input) {
        int positionFrom = input.indexOf("from");
        int positionTo = input.indexOf("to");
        int toMove = Integer.parseInt(input.substring(5, positionFrom).trim());
        int fromStack = Integer.parseInt(input.substring(positionFrom + 5, positionTo).trim()) - 1;
        int toStack = Integer.parseInt(input.substring(positionTo + 3).trim()) - 1;
        return new Movement(toMove, fromStack, toStack);
    }

    private String getTopCrates() {
        StringBuilder builder = new StringBuilder();
        for (Stack<String> stack : stacks) {
            builder.append(stack.pop());
        }
        return builder.toString();
    }

    public String solvePuzzleTwo(String inputFilePath) {
        List<String> inputLines = adventFileReader.readInput(inputFilePath);
        for (String input : inputLines) {
            Movement movement = getMovement(input);

            Stack<String> tmpStack = new Stack<>();
            for (int i = 1; i <= movement.toMove; i++) {
                String crate = stacks[movement.fromStack].pop();
                tmpStack.push(crate);
            }
            for (int i = 1; i <= movement.toMove; i++) {
                String crate = tmpStack.pop();
                stacks[movement.toStack].push(crate);
            }
        }
        return getTopCrates();
    }

    private class Movement {
        int toMove;
        int fromStack;
        int toStack;

        public Movement(int toMove, int fromStack, int toStack) {
            this.toMove = toMove;
            this.fromStack = fromStack;
            this.toStack = toStack;
        }
    }
}


