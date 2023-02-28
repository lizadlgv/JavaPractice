package ru.dolgova.practice2.command.executor;

import ru.dolgova.practice2.command.CommandType;

public interface CommandExecutor {
    int execute(String text);

    CommandType getCommandType();
}
