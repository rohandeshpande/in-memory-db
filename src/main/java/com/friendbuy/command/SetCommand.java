package com.friendbuy.command;

import com.friendbuy.dataStore.DataStore;

public class SetCommand extends GenericCommand implements CommandExecutor {
    private DataStore dataStore;

    public SetCommand(DataStore dataStore) {
        this.dataStore = dataStore;
    }

    @Override
    public void execute(String input) {
        super.parse(input);
        dataStore.set(super.variableName, super.value);
    }
}
