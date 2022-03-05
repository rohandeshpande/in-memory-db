package org.sample.command.impl;

import org.sample.command.Command;
import org.sample.command.CommandHolder;
import org.sample.dataStore.DataStore;

public class NumEqualToCommand implements Command {
    private final DataStore dataStore;

    public NumEqualToCommand(DataStore dataStore) {
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
        commandHolder.setValue(Integer.parseInt(tokens[1]));
        return commandHolder;
    }

    @Override
    public void execute(CommandHolder commandHolder) {
        Integer returnVal = dataStore.numEqualTo(commandHolder.getValue());
        System.out.println(returnVal == null ? 0 : returnVal);
    }
}
