package nl.wayne.j.robert.advent.of.code.puzzle.day02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PuzzleSolverTest {

    @Test
    void testSolvePuzzleOne() {
        PuzzleSolver puzzleSolver = new PuzzleSolver();

        assertEquals(10816, puzzleSolver.solvePuzzleOne("day02/puzzle_input.txt"));
    }

    @Test
    void testSolvePuzzleTwo() {
        PuzzleSolver puzzleSolver = new PuzzleSolver();

        assertEquals(0, puzzleSolver.solvePuzzleTwo("day02/puzzle_input.txt"));
    }
}
