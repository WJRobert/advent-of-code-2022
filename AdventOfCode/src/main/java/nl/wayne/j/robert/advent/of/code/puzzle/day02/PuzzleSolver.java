package nl.wayne.j.robert.advent.of.code.puzzle.day02;

import nl.wayne.j.robert.advent.of.code.util.FileReader;

import java.util.List;

public class PuzzleSolver {

    private FileReader adventFileReader;

    public PuzzleSolver() {
        this.adventFileReader = new FileReader();
    }

    public int solvePuzzleOne(String inputFilePath) {
        List<String> inputLines = adventFileReader.readInput(inputFilePath);
        int totalScore = 0;
        for (String input : inputLines) {
            String[] moves = input.split(" ");
            Move opponent = getMove(moves[0].trim());
            Move yours = getMove(moves[1].trim());
            totalScore += calculateScore(opponent, yours);
        }
        return totalScore;
    }

    private Move getMove(String move) {
        switch (move){
            case "A":
            case "X":
                return Move.ROCK;
            case "B":
            case "Y":
                return Move.PAPER;
            case "C":
            case "Z":
                return Move.SCISSORS;
        }
        return Move.ROCK;
    }

    private int calculateScore(Move opponent, Move yours) {
        int score= yours.getPoints();
        if (opponent.equals(yours)) {
            score += 3;
        } else {
            if (opponent.equals(Move.ROCK)) {
                score += (yours.equals(Move.PAPER)) ? 6 : 0;
            } else if (opponent.equals(Move.PAPER)) {
                score += (yours.equals(Move.SCISSORS)) ? 6 : 0;
            } else {
                score += (yours.equals(Move.ROCK)) ? 6 : 0;
            }
        }
        return score;
    }

    public int solvePuzzleTwo(String inputFilePath) {
        List<String> inputLines = adventFileReader.readInput(inputFilePath);
        int totalScore = 0;
        for (String input : inputLines) {
            String[] moves = input.split(" ");
            Move opponent = getMove(moves[0].trim());
            Move yours = chooseYourMove(opponent, moves[1]);
            totalScore += calculateScore(opponent, yours);
        }
        return totalScore;
    }

    private Move chooseYourMove(Move opponent, String toDo) {
        if ("X".equals(toDo)) {
            //Loose
            if (opponent.equals(Move.SCISSORS)) {
                return Move.PAPER;
            } else if (opponent.equals(Move.PAPER)) {
                return Move.ROCK;
            } else {
                return Move.SCISSORS;
            }
        } else if ("Y".equals(toDo)) {
            // Draw
            return opponent;
        } else {
            // Win
            if (opponent.equals(Move.SCISSORS)) {
                return Move.ROCK;
            } else if (opponent.equals(Move.PAPER)) {
                return Move.SCISSORS;
            } else {
                return Move.PAPER;
            }
        }
    }
}
