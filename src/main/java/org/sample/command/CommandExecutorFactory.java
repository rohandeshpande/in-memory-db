package org.sample.command;

import org.sample.command.constant.Command;
import org.sample.command.interfaces.CommandExecutor;
import org.sample.dataStore.TransactionManager;

public class CommandExecutorFactory {
    private TransactionManager transactionManager;

    public CommandExecutorFactory(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public CommandExecutor getCommandExecutor(Command command) {
        if (Command.BEGIN.equals(command)) {
            return new BeginCommand(transactionManager);
        } else if (Command.ROLLBACK.equals(command)) {
            return new RollbackCommand(transactionManager);
        } else if (Command.COMMIT.equals(command)) {
            return new CommitCommand(transactionManager);
        } else if (Command.SET.equals(command)) {
            return new SetCommand(transactionManager.getDataStore());
        } else if (Command.UNSET.equals(command)) {
            return new UnsetCommand(transactionManager.getDataStore());
        } else if (Command.GET.equals(command)) {
            return new GetCommand(transactionManager.getDataStore());
        } else if (Command.NUMEQUALTO.equals(command)) {
            return new NumEqualToCommand(transactionManager.getDataStore());
        } else if (Command.END.equals(command)) {
            return new EndCommand();
        }
        throw new RuntimeException("Command not found");
    }
}
