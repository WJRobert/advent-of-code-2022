package nl.wayne.j.robert.advent.of.code.puzzle.day06;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PuzzleSolverTest {

    @Test
    void testSolvePuzzleOne() {
        PuzzleSolver puzzleSolver = new PuzzleSolver();

        assertEquals(1210, puzzleSolver.solvePuzzleOne("day06/puzzle_input.txt"));
    }

    @Test
    void testSolvePuzzleTwo() {
        PuzzleSolver puzzleSolver = new PuzzleSolver();

        assertEquals(3476, puzzleSolver.solvePuzzleTwo("day06/puzzle_input.txt"));
    }
}
