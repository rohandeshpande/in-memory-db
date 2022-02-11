package org.sample.dataStore.interfaces;

public interface DataStore {
    void set(String key, Integer value);

    void unset(String key);

    Integer get(String key);

    Integer numEqualTo(Integer value);
}
