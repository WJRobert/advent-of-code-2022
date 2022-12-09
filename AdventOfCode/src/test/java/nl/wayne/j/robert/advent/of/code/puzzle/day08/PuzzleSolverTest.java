package nl.wayne.j.robert.advent.of.code.puzzle.day08;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PuzzleSolverTest {

    @Test
    void testSolvePuzzleOne() {
        PuzzleSolver puzzleSolver = new PuzzleSolver();

        assertEquals(1681, puzzleSolver.solvePuzzleOne("day08/puzzle_input.txt"));
    }

    @Test
    void testSolvePuzzleTwo() {
        PuzzleSolver puzzleSolver = new PuzzleSolver();

        assertEquals(201684, puzzleSolver.solvePuzzleTwo("day08/puzzle_input.txt"));
    }
}
