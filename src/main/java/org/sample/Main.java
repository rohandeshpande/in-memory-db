package org.sample;

import org.sample.command.CommandExecutorFactory;
import org.sample.command.constant.Command;
import org.sample.command.interfaces.CommandExecutor;
import org.sample.dataStore.InMemoryDataStore;
import org.sample.dataStore.TransactionDataStore;
import org.sample.dataStore.TransactionManager;

import java.util.Scanner;

public class Main {

    private static final InMemoryDataStore inMemoryDataStore = new InMemoryDataStore();
    private static final TransactionDataStore transactionDataStore = new TransactionDataStore();
    private static final TransactionManager transactionManager = new TransactionManager(transactionDataStore, inMemoryDataStore);
    private static final CommandExecutorFactory commandExecutorFactory = new CommandExecutorFactory(transactionManager);

    public static void main(String[] args) {
        while (true) {
            Scanner in = new Scanner(System.in);
            String input = in.nextLine();
            Command inputCommand = getCommand(input);
            try {
                CommandExecutor commandExecutor = commandExecutorFactory.getCommandExecutor(inputCommand);
                commandExecutor.execute(input);
            } catch (Exception exception) {
                exception.printStackTrace();
                System.out.println(exception.getMessage());
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
