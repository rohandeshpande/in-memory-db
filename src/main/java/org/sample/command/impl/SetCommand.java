package org.sample.command.impl;

import org.sample.command.Command;
import org.sample.command.CommandHolder;
import org.sample.dataStore.DataStore;

public class SetCommand implements Command {
    private final DataStore dataStore;

    public SetCommand(DataStore dataStore) {
        this.dataStore = dataStore;
    }

    @Override
    public boolean isValid(String input) {
        String[] tokens = input.split(" ");
        return (tokens.length == 3);
    }

    @Override
    public CommandHolder parse(String input) {
        String[] tokens = input.split(" ");
        CommandHolder commandHolder = new CommandHolder();
        commandHolder.setVariableName(tokens[1]);
        commandHolder.setValue(Integer.parseInt(tokens[2]));
        return commandHolder;
    }

    @Override
    public void execute(CommandHolder commandHolder) {
        dataStore.set(commandHolder.getVariableName(), commandHolder.getValue());
    }
}
