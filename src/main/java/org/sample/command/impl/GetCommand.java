package org.sample.command.impl;

import org.sample.command.Command;
import org.sample.command.CommandHolder;
import org.sample.command.constant.Output;
import org.sample.dataStore.DataStore;

public class GetCommand implements Command {
    private final DataStore dataStore;

    public GetCommand(DataStore dataStore) {
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
        Integer returnVal = dataStore.get(commandHolder.getVariableName());
        System.out.println(returnVal == null ? Output.NULL.getPrintVal() : returnVal);
    }
}
