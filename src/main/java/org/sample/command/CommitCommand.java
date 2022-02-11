package org.sample.command;

import org.sample.command.interfaces.CommandExecutor;
import org.sample.dataStore.TransactionManager;

public class CommitCommand extends GenericCommand implements CommandExecutor {
    private final TransactionManager transactionManager;

    public CommitCommand(TransactionManager transactionManager) {
        super(1);
        this.transactionManager = transactionManager;
    }

    @Override
    public void execute(String input) {
        transactionManager.commit();
    }
}
