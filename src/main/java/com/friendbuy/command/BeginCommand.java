package com.friendbuy.command;

import com.friendbuy.dataStore.DataStore;
import com.friendbuy.dataStore.TransactionDataStore;
import com.friendbuy.dataStore.TransactionManager;

public class BeginCommand extends GenericCommand implements CommandExecutor {
    private TransactionManager transactionManager;

    public BeginCommand(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    @Override
    public void execute(String input) {
        transactionManager.begin();
    }
}
