package org.sample.command;

public abstract class GenericCommand {
    String variableName;
    Integer value;
    Integer validTokenCount;

    public GenericCommand(Integer validTokenCount) {
        this.validTokenCount = validTokenCount;
    }

    void isValid(int inputTokenCount) {
        if (validTokenCount != inputTokenCount) {
            throw new RuntimeException("Invalid input");
        }
    }

    public void parse(String input) {
        String[] tokens = input.split(" ");
        isValid(tokens.length);
        if (tokens.length == 3) {
            variableName = tokens[1];
            value = Integer.parseInt(tokens[2]);
        } else if (tokens.length == 2) {
            variableName = tokens[1];
        }
    }
}
