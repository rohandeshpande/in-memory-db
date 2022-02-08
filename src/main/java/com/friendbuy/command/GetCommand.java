package com.friendbuy.command;

import com.friendbuy.dataStore.DataStore;

public class GetCommand extends GenericCommand implements CommandExecutor {
    private DataStore dataStore;
    private String output;

    public GetCommand(DataStore dataStore) {
        this.dataStore = dataStore;
    }

    @Override
    public void execute(String input) {
        super.parse(input);
        Integer returnVal = dataStore.get(super.variableName);
        System.out.println(returnVal == null ? Output.NULL.getPrintVal() : returnVal);
    }
}
