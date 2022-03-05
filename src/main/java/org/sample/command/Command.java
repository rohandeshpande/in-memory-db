package org.sample.command;

public interface Command {
    boolean isValid(String input);

    CommandHolder parse(String input);

    void execute(CommandHolder commandHolder);
}