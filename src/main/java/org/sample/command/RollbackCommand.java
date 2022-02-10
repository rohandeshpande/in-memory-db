package org.sample.command;

import org.sample.command.interfaces.CommandExecutor;
import org.sample.dataStore.TransactionManager;

public class RollbackCommand extends GenericCommand implements CommandExecutor {
    private TransactionManager transactionManager;

    public RollbackCommand(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    @Override
    public void execute(String input) {
        transactionManager.rollback();
    }
}