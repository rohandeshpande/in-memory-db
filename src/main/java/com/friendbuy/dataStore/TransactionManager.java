package com.friendbuy.dataStore;

import java.util.Map;

public class TransactionManager {
    private boolean transactionInProgress;
    private TransactionDataStore transactionDataStore;

    public TransactionManager(TransactionDataStore transactionDataStore) {
        this.transactionDataStore = transactionDataStore;
    }

    public boolean isTransactionInProgress() {
        return transactionInProgress;
    }

    public void begin() {
        transactionInProgress = true;
        transactionDataStore.initRollBackStack();
    }

    public void rollback() {
        transactionDataStore.processRollback();
    }

    public void commit(DataStore dataStore) {
        //Copy data from TransactionDataStore to DataStore
        while (!transactionDataStore.dequeAsStack.isEmpty()) {
            Map<String, Integer> map = transactionDataStore.dequeAsStack.pop();
            for(String key : map.keySet()) {
                dataStore.set(key, map.get(key));
            }
        }
    }
}
