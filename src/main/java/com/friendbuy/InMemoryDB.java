package com.friendbuy;

import com.friendbuy.command.*;
import com.friendbuy.dataStore.DataStore;
import com.friendbuy.dataStore.InMemoryDataStore;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InMemoryDB {

    private static final DataStore dataStore = new InMemoryDataStore();
    private static final Map<Command, CommandExecutor> commandFactory = new HashMap<>();
    static {
        commandFactory.put(Command.SET, new SetCommand(dataStore));
        commandFactory.put(Command.UNSET, new UnsetCommand(dataStore));
        commandFactory.put(Command.GET, new GetCommand(dataStore));
        commandFactory.put(Command.NUMEQUALTO, new NumEqualToCommand(dataStore));
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
