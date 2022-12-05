package nl.wayne.j.robert.advent.of.code.puzzle.day05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PuzzleSolverTest {

    @Test
    void testSolvePuzzleOne() {
        PuzzleSolver puzzleSolver = new PuzzleSolver();

        assertEquals("HBTMTBSDC", puzzleSolver.solvePuzzleOne("day05/puzzle_input.txt"));
    }

    @Test
    void testSolvePuzzleTwo() {
        PuzzleSolver puzzleSolver = new PuzzleSolver();

        assertEquals("PQTJRSHWS", puzzleSolver.solvePuzzleTwo("day05/puzzle_input.txt"));
    }
}
