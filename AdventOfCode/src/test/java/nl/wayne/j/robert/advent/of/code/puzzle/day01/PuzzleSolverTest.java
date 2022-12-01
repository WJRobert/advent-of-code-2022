package nl.wayne.j.robert.advent.of.code.puzzle.day01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PuzzleSolverTest {

    @Test
    void testSolvePuzzleOne() {
        PuzzleSolver puzzleSolver = new PuzzleSolver();

        assertEquals(74711, puzzleSolver.solvePuzzleOne("day01/puzzle_input.txt"));
    }

    @Test
    void testSolvePuzzleTwo() {
        PuzzleSolver puzzleSolver = new PuzzleSolver();

        assertEquals(209481, puzzleSolver.solvePuzzleTwo("day01/puzzle_input.txt"));
    }
}
