package org.sample.command;

import org.sample.command.constant.Output;
import org.sample.command.interfaces.CommandExecutor;
import org.sample.dataStore.interfaces.DataStore;

public class GetCommand extends GenericCommand implements CommandExecutor {
    private DataStore dataStore;

    public GetCommand(DataStore dataStore) {
        super(2);
        this.dataStore = dataStore;
    }

    @Override
    public void execute(String input) {
        super.parse(input);
        Integer returnVal = dataStore.get(super.variableName);
        System.out.println(returnVal == null ? Output.NULL.getPrintVal() : returnVal);
    }
}
