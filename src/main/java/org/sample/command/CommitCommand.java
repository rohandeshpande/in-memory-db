package org.sample.command;

import org.sample.command.interfaces.CommandExecutor;
import org.sample.dataStore.interfaces.DataStore;
import org.sample.dataStore.TransactionManager;

public class CommitCommand extends GenericCommand implements CommandExecutor {
    private TransactionManager transactionManager;
    private DataStore dataStore;

    public CommitCommand(TransactionManager transactionManager, DataStore dataStore) {
        super(1);
        this.transactionManager = transactionManager;
        this.dataStore = dataStore;
    }

    @Override
    public void execute(String input) {
        transactionManager.commit(dataStore);
    }
}
