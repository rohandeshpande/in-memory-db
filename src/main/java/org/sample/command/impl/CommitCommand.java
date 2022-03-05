package org.sample.command.impl;

import org.sample.command.Command;
import org.sample.command.CommandHolder;
import org.sample.dataStore.TransactionManager;

public class CommitCommand implements Command {
    private final TransactionManager transactionManager;

    public CommitCommand(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

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
        transactionManager.commit();
    }
}
