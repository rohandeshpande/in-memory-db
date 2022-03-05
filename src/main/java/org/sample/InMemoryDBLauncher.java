package org.sample;

import org.sample.command.Command;
import org.sample.command.CommandExecutorFactory;
import org.sample.command.CommandHolder;
import org.sample.command.constant.CommandType;
import org.sample.dataStore.impl.InMemoryDataStore;
import org.sample.dataStore.impl.TransactionDataStore;
import org.sample.dataStore.TransactionManager;

import java.util.Scanner;

public class InMemoryDBLauncher {

    private static final InMemoryDataStore inMemoryDataStore = new InMemoryDataStore();
    private static final TransactionDataStore transactionDataStore = new TransactionDataStore();
    private static final TransactionManager transactionManager = new TransactionManager(transactionDataStore, inMemoryDataStore);
    private static final CommandExecutorFactory commandExecutorFactory = new CommandExecutorFactory(transactionManager);

    public static void main(String[] args) {
        while (true) {
            Scanner in = new Scanner(System.in);
            String input = in.nextLine();
            CommandType inputCommandType = getCommand(input);
            try {
                Command command = commandExecutorFactory.getCommand(inputCommandType);
                if (command.isValid(input)) {
                    CommandHolder commandHolder = command.parse(input);
                    command.execute(commandHolder);
                } else {
                    throw new RuntimeException("Invalid input");
                }
            } catch (Exception exception) {
                exception.printStackTrace();
                System.out.println(exception.getMessage());
            }
        }
    }

    private static CommandType getCommand(String input) {
        String command = "";
        if (input.contains(" ")) {
            command = input.substring(0, input.indexOf(" "));
        } else {
            command = input;
        }
        return CommandType.valueOf(command);
    }
}
