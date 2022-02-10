package org.sample.command;

import org.sample.command.interfaces.CommandExecutor;
import org.sample.dataStore.interfaces.DataStore;

public class NumEqualToCommand extends GenericCommand implements CommandExecutor {
    private DataStore dataStore;

    public NumEqualToCommand(DataStore dataStore) {
        super(2);
        this.dataStore = dataStore;
    }

    @Override
    public void execute(String input) {
        this.parse(input);
        Integer returnVal = dataStore.numEqualTo(super.value);
        System.out.println(returnVal == null ? 0 : returnVal);
    }

    @Override
    public void parse(String input) {
        String[] tokens = input.split(" ");
        isValid(tokens.length);
        if (tokens.length == 2) {
            super.value = Integer.parseInt(tokens[1]);
        }
    }
}
