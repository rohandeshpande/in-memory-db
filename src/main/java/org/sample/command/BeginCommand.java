package org.sample.command;

import org.sample.command.interfaces.CommandExecutor;
import org.sample.dataStore.TransactionManager;

public class BeginCommand extends GenericCommand implements CommandExecutor {
    private TransactionManager transactionManager;

    public BeginCommand(TransactionManager transactionManager) {
        super(1);
        this.transactionManager = transactionManager;
    }

    @Override
    public void execute(String input) {
        transactionManager.begin();
    }
}
