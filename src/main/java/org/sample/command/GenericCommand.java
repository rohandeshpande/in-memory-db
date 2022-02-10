package org.sample.command;

public abstract class GenericCommand {
    String variableName;
    Integer value;
    String output;

    public void parse(String input) {
        String[] tokens = input.split(" ");
        if (tokens.length == 3) {
            variableName = tokens[1];
            value = Integer.parseInt(tokens[2]);
        } else if (tokens.length == 2) {
            variableName = tokens[1];
        }
    }
}
