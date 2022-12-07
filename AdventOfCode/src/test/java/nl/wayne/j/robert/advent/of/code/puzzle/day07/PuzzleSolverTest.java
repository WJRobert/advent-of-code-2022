package nl.wayne.j.robert.advent.of.code.puzzle.day07;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PuzzleSolverTest {

    @Test
    void testSolvePuzzleOne() {
        PuzzleSolver puzzleSolver = new PuzzleSolver();

        assertEquals(1642503, puzzleSolver.solvePuzzleOne("day07/puzzle_input.txt"));
    }

    @Test
    void testSolvePuzzleTwo() {
        PuzzleSolver puzzleSolver = new PuzzleSolver();

        assertEquals(6999588, puzzleSolver.solvePuzzleTwo("day07/puzzle_input.txt"));
    }
}
