package org.sample.dataStore;

import org.sample.command.constant.Output;
import org.sample.dataStore.impl.InMemoryDataStore;
import org.sample.dataStore.impl.TransactionDataStore;

import java.util.Iterator;

public class TransactionManager {
    private TransactionDataStore transactionDataStore;
    private InMemoryDataStore inMemoryDataStore;

    public TransactionManager(TransactionDataStore transactionDataStore, InMemoryDataStore inMemoryDataStore) {
        this.transactionDataStore = transactionDataStore;
        this.inMemoryDataStore = inMemoryDataStore;
    }

    public boolean isTransactionInProgress() {
        return !transactionDataStore.getStack().isEmpty();
    }

    public void begin() {
        InMemoryDataStore stackInMemoryDataStore = new InMemoryDataStore();
        this.inMemoryDataStore.getDataMap().forEach((k, v) -> {
            stackInMemoryDataStore.set(k, v);
        });
        transactionDataStore.getStack().push(stackInMemoryDataStore);
    }

    public void rollback() {
        try {
            transactionDataStore.getStack().pop();
        } catch (Exception exception) {
            System.out.println(Output.NO_TRANSACTION.getPrintVal());
        }
    }

    public void commit() {
        Iterator<InMemoryDataStore> itr = transactionDataStore.getStack().descendingIterator();
        while (itr.hasNext()) {
            InMemoryDataStore inMemoryDataStore = itr.next();
            inMemoryDataStore.getDataMap().forEach((k, v) -> {
                this.inMemoryDataStore.set(k, v);
            });
        }
        transactionDataStore.getStack().clear();
    }

    public DataStore getDataStore() {
        if (isTransactionInProgress()) {
            return transactionDataStore;
        } else {
            return inMemoryDataStore;
        }
    }
}