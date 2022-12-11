package nl.wayne.j.robert.advent.of.code.puzzle.day11;

import nl.wayne.j.robert.advent.of.code.util.FileReader;

import java.util.*;

public class PuzzleSolver {

    private final FileReader adventFileReader;

    public PuzzleSolver() {
        this.adventFileReader = new FileReader();
    }

    public Long solvePuzzleOne(String inputFilePath) {
        List<Monkey> monkeys = generateMonkeys(inputFilePath);
        return runShenanigans(monkeys, 20, true);
    }

    private Long runShenanigans(List<Monkey> monkeys, int rounds, boolean useRelaxMethod) {
        Map<Integer, List<Long>> monkeyItems = new HashMap<>();
        for (int i=0; i<monkeys.size(); i++) {
            monkeyItems.put(i, monkeys.get(i).items);
        }
        Map<Integer, Integer> monkeyInspected = new HashMap<>();
        for (int round = 1; round<=rounds; round++) {
            int monkeyIndex = 0;
            for (Monkey monkey: monkeys) {
                if (!monkeyInspected.containsKey(monkeyIndex)) {
                    monkeyInspected.put(monkeyIndex, 0);
                }
                List<Long> items = monkeyItems.get(monkeyIndex);
                if (!items.isEmpty()) {
                    int currentInspectedCount = monkeyInspected.get(monkeyIndex);
                    for (Long item: items) {
                        currentInspectedCount++;
                        Long worryLevel = calculateWorryLevel(item, monkey.operationFunction, monkey.operationValue, useRelaxMethod);
                        if (worryLevel%monkey.divisibleValue==0) {
                            List<Long> newItems = monkeyItems.get(monkey.trueMonkeyId);
                            newItems.add(worryLevel);
                            monkeyItems.put(monkey.trueMonkeyId, newItems);
                        } else {
                            List<Long> newItems = monkeyItems.get(monkey.falseMonkeyId);
                            newItems.add(worryLevel);
                            monkeyItems.put(monkey.falseMonkeyId, newItems);
                        }
                    }
                    monkeyItems.put(monkeyIndex, new ArrayList<>());
                    monkeyInspected.put(monkeyIndex, currentInspectedCount);
                }
                monkeyIndex++;
            }
        }
        return getMonkeyBusinessValue(monkeyInspected);
    }

    private Long getMonkeyBusinessValue(Map<Integer, Integer> itemsInspected) {
        List<Integer> values = new ArrayList<>(itemsInspected.values());
        values.sort(Collections.reverseOrder());
        return values.get(0).longValue()*values.get(1).longValue();
    }

    private long calculateWorryLevel(long item, OperationFunction operationFunction, Integer operationValue, boolean useRelaxMethod) {
        double worryLevel = item * 1.0;
        if (OperationFunction.MULTIPLY.equals(operationFunction)) {
            if (operationValue == null) {
                worryLevel *= item;
            } else {
                worryLevel *= operationValue;
            }
        } else {
            if (operationValue == null) {
                worryLevel += item;
            } else {
                worryLevel += operationValue;
            }
        }
        if (!useRelaxMethod) {
            return (long) (worryLevel%9699690);
        } else {
            double dividedValue = Math.floor(worryLevel / 3.0);
            return (long) dividedValue;
        }
    }

    private List<Monkey> generateMonkeys(String inputFilePath) {
        List<Monkey> monkeys = new ArrayList<>();
        List<String> inputLines = adventFileReader.readInput(inputFilePath);
        Monkey currentMonkey = null;
        for(String line: inputLines) {
            String input = line.trim();
            if(input.startsWith("Monkey")) {
                if (currentMonkey != null) {
                    monkeys.add(currentMonkey);
                }
                currentMonkey = new Monkey();
            } else if (input.startsWith("Starting items:")) {
                String[] items = input.substring(15).split(",");
                for (String item: items) {
                    currentMonkey.items.add(Long.parseLong(item.trim()));
                }
            } else if (input.startsWith("Operation:")) {
                currentMonkey.operationFunction = OperationFunction.fromOperation(input.substring(21,22));
                String operationValue = input.substring(23).trim();
                if ("old".equals(operationValue)) {
                    currentMonkey.operationValue = null;
                } else {
                    currentMonkey.operationValue = Integer.parseInt(operationValue);
                }
            } else if (input.startsWith("Test:")) {
                currentMonkey.divisibleValue = Integer.parseInt(input.substring(19).trim());
            } else if (input.startsWith("If true:")) {
                currentMonkey.trueMonkeyId = Integer.parseInt(input.substring(25).trim());
            } else if (input.startsWith("If false:")) {
                currentMonkey.falseMonkeyId = Integer.parseInt(input.substring(26).trim());
            }
        }
        monkeys.add(currentMonkey);
        return monkeys;
    }

    public Long solvePuzzleTwo(String inputFilePath) {
        List<Monkey> monkeys = generateMonkeys(inputFilePath);
        return runShenanigans(monkeys, 10000, false);
    }
}
