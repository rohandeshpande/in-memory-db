package org.sample.command;

import org.sample.command.interfaces.CommandExecutor;
import org.sample.dataStore.interfaces.DataStore;

public class UnsetCommand extends GenericCommand implements CommandExecutor {
    private DataStore dataStore;

    public UnsetCommand(DataStore dataStore) {
        this.dataStore = dataStore;
    }

    @Override
    public void execute(String input) {
        super.parse(input);
        dataStore.unset(super.variableName);
    }
}
