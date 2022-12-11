package nl.wayne.j.robert.advent.of.code.puzzle.day11;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PuzzleSolverTest {

    @Test
    void testSolvePuzzleOne() {
        PuzzleSolver puzzleSolver = new PuzzleSolver();

        assertEquals(57838, puzzleSolver.solvePuzzleOne("day11/puzzle_input.txt"));
    }

    @Test
    void testSolvePuzzleTwo() {
        PuzzleSolver puzzleSolver = new PuzzleSolver();

        assertEquals(15050382231L, puzzleSolver.solvePuzzleTwo("day11/puzzle_input.txt"));
    }
}
