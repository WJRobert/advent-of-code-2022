package nl.wayne.j.robert.advent.of.code.puzzle.day07;

import nl.wayne.j.robert.advent.of.code.util.FileReader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PuzzleSolver {

    Map<String, Integer> dirSizeMap = new HashMap<>();
    private FileReader adventFileReader;

    public PuzzleSolver() {
        this.adventFileReader = new FileReader();
    }

    public int solvePuzzleOne(String inputFilePath) {
        buildFolderMap(inputFilePath);
        return calculateSumOfTotalSizes();
    }

    private void buildFolderMap(String inputFilePath) {
        List<String> inputLines = adventFileReader.readInput(inputFilePath);
        dirSizeMap = new HashMap<>();
        boolean isFirstFolder = true;
        String currentDir = "/";
        dirSizeMap.put(currentDir, 0);
        for (String input : inputLines) {
            if (!isFirstFolder) {
                if (input.startsWith("$ cd")) {
                    String dir = input.substring(5);
                    if ("..".equals(dir)) {
                        currentDir = currentDir.substring(0, currentDir.lastIndexOf("/"));
                    } else {
                        currentDir += "/" + dir;
                        if (!dirSizeMap.containsKey(currentDir)) {
                            dirSizeMap.put(currentDir, 0);
                        }
                    }
                } else if (Character.isDigit(input.charAt(0))) {
                    String[] commandResults = input.split(" ");
                    int fileSize = Integer.parseInt(commandResults[0]);
                    int currentDirSize = dirSizeMap.get(currentDir) + fileSize;
                    dirSizeMap.put(currentDir, currentDirSize);
                    updateParentFolderSizes(currentDir, fileSize);
                }
            } else {
                isFirstFolder = false;
            }
        }
    }

    private void updateParentFolderSizes(String currentDir, int fileSize) {
        while (!"/".equals(currentDir)) {
            currentDir = currentDir.substring(0, currentDir.lastIndexOf("/"));
            int currentDirSize = dirSizeMap.get(currentDir) + fileSize;
            dirSizeMap.put(currentDir, currentDirSize);
        }
    }

    private int calculateSumOfTotalSizes() {
        int largestSize = 100000;
        int sum = 0;
        for (int dirSize : dirSizeMap.values()) {
            if (dirSize <= largestSize) {
                sum += dirSize;
            }
        }
        return sum;
    }

    public int solvePuzzleTwo(String inputFilePath) {
        buildFolderMap(inputFilePath);
        return getBestDeletionFolderSize();
    }

    private int getBestDeletionFolderSize() {
        int unusedSpace = 70000000 - dirSizeMap.get("/");
        int sizeToFree = 30000000 - unusedSpace;
        int smallestFolderSize = 70000000;
        for (int dirSize : dirSizeMap.values()) {
            if (dirSize >= sizeToFree && dirSize < smallestFolderSize) {
                smallestFolderSize = dirSize;
            }
        }
        return smallestFolderSize;
    }
}
