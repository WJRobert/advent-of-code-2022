package nl.wayne.j.robert.advent.of.code.puzzle.day04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PuzzleSolverTest {

    @Test
    void testSolvePuzzleOne() {
        PuzzleSolver puzzleSolver = new PuzzleSolver();

        assertEquals(494, puzzleSolver.solvePuzzleOne("day04/puzzle_input.txt"));
    }

    @Test
    void testSolvePuzzleTwo() {
        PuzzleSolver puzzleSolver = new PuzzleSolver();

        assertEquals(833, puzzleSolver.solvePuzzleTwo("day04/puzzle_input.txt"));
    }
}
