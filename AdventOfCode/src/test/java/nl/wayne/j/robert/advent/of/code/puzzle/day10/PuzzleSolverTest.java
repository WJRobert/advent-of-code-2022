package nl.wayne.j.robert.advent.of.code.puzzle.day10;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PuzzleSolverTest {

    @Test
    void testSolvePuzzleOne() {
        PuzzleSolver puzzleSolver = new PuzzleSolver();

        assertEquals(14560, puzzleSolver.solvePuzzleOne("day10/puzzle_input.txt"));
    }

    @Test
    void testSolvePuzzleTwo() {
        PuzzleSolver puzzleSolver = new PuzzleSolver();

        assertEquals("####.#..#.###..#..#.####.###..#..#.#####\n" +
                "#....#.#..#..#.#..#.#....#..#.#..#....#.\n" +
                "###..##...#..#.####.###..#..#.#..#...#..\n" +
                "#....#.#..###..#..#.#....###..#..#..#...\n" +
                "#....#.#..#.#..#..#.#....#....#..#.#...#\n" +
                "####.#..#.#..#.#..#.####.#.....##..####.\n", puzzleSolver.solvePuzzleTwo("day10/puzzle_input.txt"));
    }
}
