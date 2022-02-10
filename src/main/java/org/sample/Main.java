package org.sample;

import org.sample.command.BeginCommand;
import org.sample.command.CommitCommand;
import org.sample.command.GetCommand;
import org.sample.command.NumEqualToCommand;
import org.sample.command.RollbackCommand;
import org.sample.command.SetCommand;
import org.sample.command.UnsetCommand;
import org.sample.command.constant.Command;
import org.sample.command.interfaces.CommandExecutor;
import org.sample.dataStore.interfaces.DataStore;
import org.sample.dataStore.InMemoryDataStore;
import org.sample.dataStore.TransactionDataStore;
import org.sample.dataStore.TransactionManager;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static final DataStore dataStore = new InMemoryDataStore();
    private static final TransactionDataStore transactionDataStore = new TransactionDataStore();
    private static final TransactionManager transactionManager = new TransactionManager(transactionDataStore);
    private static final Map<Command, CommandExecutor> commandFactory = new HashMap<>();
    static {
        commandFactory.put(Command.SET, new SetCommand(dataStore));
        commandFactory.put(Command.UNSET, new UnsetCommand(dataStore));
        commandFactory.put(Command.GET, new GetCommand(dataStore));
        commandFactory.put(Command.NUMEQUALTO, new NumEqualToCommand(dataStore));
        commandFactory.put(Command.BEGIN, new BeginCommand(transactionManager));
        commandFactory.put(Command.ROLLBACK, new RollbackCommand(transactionManager));
        commandFactory.put(Command.COMMIT, new CommitCommand(transactionManager, dataStore));
    }

    public static void main(String[] args) {
        while (true) {
            Scanner in = new Scanner(System.in);
            String input = in.nextLine();
            Command inputCommand = getCommand(input);

            if (Command.END.name().equals(input)) {
                System.exit(0);
            } else {
                CommandExecutor commandExecutor = commandFactory.get(inputCommand);
                commandExecutor.execute(input);
            }
        }
    }

    private static Command getCommand(String input) {
        String command = "";
        if (input.contains(" ")) {
             command = input.substring(0, input.indexOf(" "));
        } else {
            command = input;
        }
        return Command.valueOf(command);
    }
}


//TODO
/*
- add validator for each command
- add print method for each command
- add test cases
- complete transaction
- add comments
 */