package org.sample.dataStore;

public interface DataStore {
    void set(String key, Integer value);

    void unset(String key);

    Integer get(String key);

    Integer numEqualTo(Integer value);
}
