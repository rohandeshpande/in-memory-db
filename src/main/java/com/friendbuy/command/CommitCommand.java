package com.friendbuy.command;

import com.friendbuy.dataStore.DataStore;
import com.friendbuy.dataStore.TransactionManager;

public class CommitCommand extends GenericCommand implements CommandExecutor {
    private TransactionManager transactionManager;
    private DataStore dataStore;

    public CommitCommand(TransactionManager transactionManager, DataStore dataStore) {
        this.transactionManager = transactionManager;
        this.dataStore = dataStore;
    }

    @Override
    public void execute(String input) {
        transactionManager.commit(dataStore);
    }
}
