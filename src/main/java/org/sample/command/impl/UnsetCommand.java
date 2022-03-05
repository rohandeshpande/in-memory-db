package org.sample.command.impl;

import org.sample.command.Command;
import org.sample.command.CommandHolder;
import org.sample.dataStore.DataStore;

public class UnsetCommand implements Command {
    private final DataStore dataStore;

    public UnsetCommand(DataStore dataStore) {
        this.dataStore = dataStore;
    }

    @Override
    public boolean isValid(String input) {
        String[] tokens = input.split(" ");
        return (tokens.length == 2);
    }

    @Override
    public CommandHolder parse(String input) {
        String[] tokens = input.split(" ");
        CommandHolder commandHolder = new CommandHolder();
        commandHolder.setVariableName(tokens[1]);
        return commandHolder;
    }

    @Override
    public void execute(CommandHolder commandHolder) {
        dataStore.unset(commandHolder.getVariableName());
    }
}
