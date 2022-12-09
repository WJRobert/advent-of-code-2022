package nl.wayne.j.robert.advent.of.code.puzzle.day08;

import nl.wayne.j.robert.advent.of.code.util.FileReader;

import java.util.List;

public class PuzzleSolver {

    private final FileReader adventFileReader;

    public PuzzleSolver() {
        this.adventFileReader = new FileReader();
    }

    public int solvePuzzleOne(String inputFilePath) {
        int[][] grid = generateGrid(inputFilePath);
        int visibleTrees = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        for (int r = 0; r < rows; r++) {
            if (r == 0 || r == rows - 1) {
                visibleTrees += cols;
            } else {
                for (int c = 0; c < cols; c++) {
                    if (c == 0 || c == cols - 1) {
                        visibleTrees++;
                    } else {
                        int currentHeight = grid[r][c];
                        boolean isTopShorter = currentHeight > grid[r - 1][c];
                        boolean isBottomShorter = currentHeight > grid[r + 1][c];
                        boolean isLeftShorter = currentHeight > grid[r][c - 1];
                        boolean isRightShorter = currentHeight > grid[r][c + 1];
                        if (isTopShorter && r - 1 > 0) {
                            for (int i = r - 1; i >= 0; i--) {
                                if (grid[i][c] >= currentHeight) {
                                    isTopShorter = false;
                                    break;
                                }
                            }
                        }
                        if (!isTopShorter && isBottomShorter && r + 1 < rows) {
                            for (int i = r + 1; i < rows; i++) {
                                if (grid[i][c] >= currentHeight) {
                                    isBottomShorter = false;
                                    break;
                                }
                            }
                        }
                        if (c - 1 > 0 && !isTopShorter && !isBottomShorter && isLeftShorter) {
                            for (int i = c - 1; i >= 0; i--) {
                                if (grid[r][i] >= currentHeight) {
                                    isLeftShorter = false;
                                    break;
                                }
                            }
                        }
                        if (c + 1 < cols && !isTopShorter && !isBottomShorter && !isLeftShorter && isRightShorter) {
                            for (int i = c + 1; i < cols; i++) {
                                if (grid[r][i] >= currentHeight) {
                                    isRightShorter = false;
                                    break;
                                }
                            }
                        }
                        if (isTopShorter || isBottomShorter || isLeftShorter || isRightShorter) {
                            visibleTrees++;
                        }
                    }
                }
            }
        }
        return visibleTrees;
    }

    public int solvePuzzleTwo(String inputFilePath) {
        int[][] grid = generateGrid(inputFilePath);
        int highestScenicScore = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        for (int r = 1; r < rows - 1; r++) {
            for (int c = 1; c < cols - 1; c++) {
                int currentHeight = grid[r][c];
                int topTrees = getTopTreesVisibleCount(grid, r, c, currentHeight);
                int bottomTrees = getBottomTrees(grid, rows, r, c, currentHeight);
                int leftTrees = getLeftTrees(grid, r, c, currentHeight);
                int rightTrees = getRightTrees(grid, cols, r, c, currentHeight);

                int treeScore = topTrees * bottomTrees * leftTrees * rightTrees;
                if (highestScenicScore < treeScore) {
                    highestScenicScore = treeScore;
                }
            }
        }
        return highestScenicScore;
    }

    private int getRightTrees(int[][] grid, int cols, int r, int c, int currentHeight) {
        int rightTrees = 0;
        for (int i = c + 1; i < cols; i++) {
            if (grid[r][i] >= currentHeight) {
                rightTrees++;
                break;
            } else {
                rightTrees++;
            }
        }
        return rightTrees;
    }

    private int getLeftTrees(int[][] grid, int r, int c, int currentHeight) {
        int leftTrees = 0;
        for (int i = c - 1; i >= 0; i--) {
            if (grid[r][i] >= currentHeight) {
                leftTrees++;
                break;
            } else {
                leftTrees++;
            }
        }
        return leftTrees;
    }

    private int getBottomTrees(int[][] grid, int rows, int r, int c, int currentHeight) {
        int bottomTrees = 0;
        for (int i = r + 1; i < rows; i++) {
            if (grid[i][c] >= currentHeight) {
                bottomTrees++;
                break;
            } else {
                bottomTrees++;
            }
        }
        return bottomTrees;
    }

    private int getTopTreesVisibleCount(int[][] grid, int r, int c, int currentHeight) {
        int topTrees = 0;
        for (int i = r - 1; i >= 0; i--) {
            if (grid[i][c] >= currentHeight) {
                topTrees++;
                break;
            } else {
                topTrees++;
            }
        }
        return topTrees;
    }

    private int[][] generateGrid(String inputFilePath) {
        List<String> inputLines = adventFileReader.readInput(inputFilePath);
        int rows = inputLines.size();
        int cols = inputLines.get(0).length();
        int[][] grid = new int[rows][cols];
        for (int r = 0; r < rows; r++) {
            String input = inputLines.get(r);
            for (int c = 0; c < cols; c++) {
                grid[r][c] = Integer.parseInt(input.substring(c, c + 1));
            }
        }

        return grid;
    }
}
