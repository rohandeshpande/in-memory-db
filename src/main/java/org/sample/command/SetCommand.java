package org.sample.command;

import org.sample.command.interfaces.CommandExecutor;
import org.sample.dataStore.interfaces.DataStore;

public class SetCommand extends GenericCommand implements CommandExecutor {
    private final DataStore dataStore;

    public SetCommand(DataStore dataStore) {
        super(3);
        this.dataStore = dataStore;
    }

    @Override
    public void execute(String input) {
        super.parse(input);
        dataStore.set(super.variableName, super.value);
    }
}
