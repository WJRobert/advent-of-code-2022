package nl.wayne.j.robert.advent.of.code.puzzle.day03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PuzzleSolverTest {

    @Test
    void testSolvePuzzleOne() {
        PuzzleSolver puzzleSolver = new PuzzleSolver();

        assertEquals(7845, puzzleSolver.solvePuzzleOne("day03/puzzle_input.txt"));
    }

    @Test
    void testSolvePuzzleTwo() {
        PuzzleSolver puzzleSolver = new PuzzleSolver();

        assertEquals(2790, puzzleSolver.solvePuzzleTwo("day03/puzzle_input.txt"));
    }
}
