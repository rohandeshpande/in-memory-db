package org.sample.command;

import org.sample.command.constant.CommandType;
import org.sample.command.impl.BeginCommand;
import org.sample.command.impl.CommitCommand;
import org.sample.command.impl.EndCommand;
import org.sample.command.impl.GetCommand;
import org.sample.command.impl.NumEqualToCommand;
import org.sample.command.impl.RollbackCommand;
import org.sample.command.impl.SetCommand;
import org.sample.command.impl.UnsetCommand;
import org.sample.dataStore.TransactionManager;

public class CommandExecutorFactory {
    private TransactionManager transactionManager;

    public CommandExecutorFactory(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public Command getCommand(CommandType commandType) {
        if (CommandType.BEGIN.equals(commandType)) {
            return new BeginCommand(transactionManager);
        } else if (CommandType.ROLLBACK.equals(commandType)) {
            return new RollbackCommand(transactionManager);
        } else if (CommandType.COMMIT.equals(commandType)) {
            return new CommitCommand(transactionManager);
        } else if (CommandType.SET.equals(commandType)) {
            return new SetCommand(transactionManager.getDataStore());
        } else if (CommandType.UNSET.equals(commandType)) {
            return new UnsetCommand(transactionManager.getDataStore());
        } else if (CommandType.GET.equals(commandType)) {
            return new GetCommand(transactionManager.getDataStore());
        } else if (CommandType.NUMEQUALTO.equals(commandType)) {
            return new NumEqualToCommand(transactionManager.getDataStore());
        } else if (CommandType.END.equals(commandType)) {
            return new EndCommand();
        }
        throw new RuntimeException("Command not found");
    }
}
