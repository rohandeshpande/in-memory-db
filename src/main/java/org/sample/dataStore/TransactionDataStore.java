package org.sample.dataStore;

import org.sample.dataStore.interfaces.DataStore;

import java.util.ArrayDeque;
import java.util.Deque;

public class TransactionDataStore implements DataStore {
    private Deque<InMemoryDataStore> stack = new ArrayDeque<>();

    public Deque<InMemoryDataStore> getStack() {
        return stack;
    }

    @Override
    public void set(String key, Integer value) {
        InMemoryDataStore inMemoryDataStore = stack.pop();
        inMemoryDataStore.set(key, value);
        stack.push(inMemoryDataStore);
    }

    @Override
    public void unset(String key) {
        InMemoryDataStore inMemoryDataStore = stack.pop();
        inMemoryDataStore.unset(key);
        stack.push(inMemoryDataStore);
    }

    @Override
    public Integer get(String key) {
        if (!stack.isEmpty()) {
            InMemoryDataStore inMemoryDataStore = stack.peek();
            return inMemoryDataStore.get(key);
        }
        return null;
    }

    @Override
    public Integer numEqualTo(Integer value) {
        if (!stack.isEmpty()) {
            InMemoryDataStore inMemoryDataStore = stack.peek();
            return inMemoryDataStore.numEqualTo(value);
        }
        return 0;
    }
}
