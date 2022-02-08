package com.friendbuy.dataStore;

import java.util.HashMap;
import java.util.Map;

public class InMemoryDataStore implements DataStore {
    private final Map<String,Integer> dataMap = new HashMap<>();
    private final Map<Integer,Integer> countValueMap = new HashMap<>();

    @Override
    public void set(String key, Integer value) {
        Integer existingValue = dataMap.get(key);
        dataMap.put(key, value);
        decrementCount(existingValue);
        incrementCount(value);
    }

    @Override
    public void unset(String key) {
        Integer existingValue = dataMap.get(key);
        decrementCount(existingValue);
        dataMap.remove(key);
    }

    @Override
    public Integer get(String key) {
        return dataMap.getOrDefault(key, null);
    }

    @Override
    public Integer numEqualTo(Integer value) {
        return countValueMap.getOrDefault(value, 0);
    }

    private void incrementCount(Integer value) {
        countValueMap.put(value, countValueMap.getOrDefault(value,0)+1);
    }

    private void decrementCount(Integer value) {
        if (value == null) {
            return;
        }
        countValueMap.put(value, countValueMap.get(value)-1);
    }
}
