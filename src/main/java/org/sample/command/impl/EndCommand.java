package org.sample.command.impl;

import org.sample.command.Command;
import org.sample.command.CommandHolder;

public class EndCommand implements Command {

    @Override
    public boolean isValid(String input) {
        String[] tokens = input.split(" ");
        return (tokens.length == 1);
    }

    @Override
    public CommandHolder parse(String input) {
        return new CommandHolder();
    }

    @Override
    public void execute(CommandHolder commandHolder) {
        System.exit(0);
    }
}
