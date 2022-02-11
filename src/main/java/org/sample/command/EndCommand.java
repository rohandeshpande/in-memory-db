package org.sample.command;

import org.sample.command.interfaces.CommandExecutor;

public class EndCommand extends GenericCommand implements CommandExecutor {
    public EndCommand() {
        super(1);
    }

    @Override
    public void execute(String input) {
        System.exit(0);
    }
}
