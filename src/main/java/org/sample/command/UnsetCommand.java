package org.sample.command;

import org.sample.command.interfaces.CommandExecutor;
import org.sample.dataStore.interfaces.DataStore;

public class UnsetCommand extends GenericCommand implements CommandExecutor {
    private DataStore dataStore;

    public UnsetCommand(DataStore dataStore) {
        super(2);
        this.dataStore = dataStore;
    }

    @Override
    public void execute(String input) {
        super.parse(input);
        dataStore.unset(super.variableName);
    }
}
