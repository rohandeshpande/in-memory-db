package org.sample.dataStore;

import org.sample.dataStore.interfaces.DataStore;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

public class TransactionDataStore implements DataStore {
    Deque<Map<String, Integer>> dequeAsStack = new ArrayDeque<>();
    Deque<Integer> rollbackCountStack = new ArrayDeque<>();

    @Override
    public void set(String key, Integer value) {
        Map<String,Integer> map = Map.of(key, value);
        dequeAsStack.push(map);
        Integer count = rollbackCountStack.pop();
        rollbackCountStack.push(++count);
    }

    @Override
    public void unset(String key) {
        dequeAsStack.pop();
        Integer count = rollbackCountStack.pop();
        rollbackCountStack.push(--count);
    }

    @Override
    public Integer get(String key) {
        Map<String,Integer> map = dequeAsStack.peek();
        return map.getOrDefault(key, null);
    }

    @Override
    public Integer numEqualTo(Integer value) {
        int count = 0;
        Map<String,Integer> map = dequeAsStack.peek();
        if (map == null || map.values() == null) {
            return count;
        }
        for(Integer i : map.values()) {
            if (i == value) {
                count++;
            }
        }
        return count;
    }


    public void initRollBackStack() {
        rollbackCountStack.push(0);
    }

    public void processRollback() {
        int countToRollback = rollbackCountStack.pop();
        try{
            for (int i = 0; i < countToRollback; i++) {
                dequeAsStack.pop();
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
