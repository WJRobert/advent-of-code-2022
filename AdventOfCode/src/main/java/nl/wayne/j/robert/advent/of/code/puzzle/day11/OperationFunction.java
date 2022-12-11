package nl.wayne.j.robert.advent.of.code.puzzle.day11;

public enum OperationFunction {
    MULTIPLY("*"),
    ADD("+");
    private String function;

    OperationFunction(String function) {
        this.function = function;
    }

    static OperationFunction fromOperation(String function) {
        if (MULTIPLY.function.equals(function)) {
            return OperationFunction.MULTIPLY;
        } else {
            return OperationFunction.ADD;
        }
    }
}
