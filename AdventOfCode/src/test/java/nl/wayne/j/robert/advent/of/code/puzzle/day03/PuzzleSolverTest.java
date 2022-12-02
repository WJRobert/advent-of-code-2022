package nl.wayne.j.robert.advent.of.code.puzzle.day03;

import nl.wayne.j.robert.advent.of.code.puzzle.day01.PuzzleSolver;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PuzzleSolverTest {

    @Test
    void testSolvePuzzleOne() {
        PuzzleSolver puzzleSolver = new PuzzleSolver();

        assertEquals(0, puzzleSolver.solvePuzzleOne("day03/puzzle_input.txt"));
    }

    @Test
    void testSolvePuzzleTwo() {
        PuzzleSolver puzzleSolver = new PuzzleSolver();

        assertEquals(0, puzzleSolver.solvePuzzleTwo("day03/puzzle_input.txt"));
    }
}
