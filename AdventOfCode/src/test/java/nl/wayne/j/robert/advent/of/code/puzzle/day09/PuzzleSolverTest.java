package nl.wayne.j.robert.advent.of.code.puzzle.day09;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PuzzleSolverTest {

    @Test
    void testSolvePuzzleOne() {
        PuzzleSolver puzzleSolver = new PuzzleSolver();

        assertEquals(6642, puzzleSolver.solvePuzzleOne("day09/puzzle_input.txt"));
    }

    @Test
    void testSolvePuzzleTwo() {
        PuzzleSolver puzzleSolver = new PuzzleSolver();

        assertEquals(2765, puzzleSolver.solvePuzzleTwo("day09/puzzle_input.txt"));
    }
}
