package ru.dolgova.practice2.command;

import ru.dolgova.practice2.command.executor.*;

import java.util.Map;
import java.util.Scanner;

public class CommandReader {
    static {
        printCommands();
    }

    public static void startReadCommand() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Введите вашу команду: ");
            String command = scanner.nextLine();
            if (readCommand(command) == 0) {
                break;
            }
        }
        scanner.close();
    }

    private static final Map<CommandType, CommandExecutor> COMMAND_EXECUTORS_GROUPED_BY_COMMAND = Map.of(
            CommandType.CREATE_FILM, new FilmCreate(),
            CommandType.DELETE_FILM, new FilmRemove(),
            CommandType.CREATE_DIRECTOR, new DirectorCreate(),
            CommandType.DELETE_DIRECTOR, new DirectorRemove(),
            CommandType.WRITE_ALL, new ViewAll()
    );

    private static int readCommand(String command) {
        CommandType commandType = getCommandType(command);
        if (COMMAND_EXECUTORS_GROUPED_BY_COMMAND.containsKey(commandType)) {
            var commandExecutor = COMMAND_EXECUTORS_GROUPED_BY_COMMAND.get(commandType);
            return commandExecutor.execute(command);
        }
        if (commandType == CommandType.EXIT) {
            return 0;
        }
        System.out.println("Неверная команда!");
        return 1;
    }

    private static CommandType getCommandType(String commandString) {
        if (commandString.contains("1.")) {
            return CommandType.CREATE_DIRECTOR;
        }
        if (commandString.contains("2.")) {
            return CommandType.CREATE_FILM;
        }
        if (commandString.contains("3.")) {
            return CommandType.DELETE_DIRECTOR;
        }
        if (commandString.contains("4.")) {
            return CommandType.DELETE_FILM;
        }
        if (commandString.contains("5.")) {
            return CommandType.WRITE_ALL;
        }
        if (commandString.contains("6.")) {
            return CommandType.EXIT;
        }
        return CommandType.UNDEFINED;
    }

    private static void printCommands() {
        System.out.println("Список доступных команд:\n" +
                "   1 - Создать режиссера: 1. <id режиссера> <Имя> <Фамилия> <Дата рождения('ГГГГ-ММ-ДД')> <Пол(m/f)>\n" +
                "   2 - Создать фильм: 2. <id фильма> <Название> <Рейтинг> <id режиссера>\n" +
                "   3 - Удалить режиссера: 3. <id режиссера> (при этом удалятся все фильмы, снятые режиссёром) \n" +
                "   4 - Удалить фильм: 4. <id фильма> \n" +
                "   5 - Вывести все фильмы: 5. \n" +
                "   6 - Выйти: 6. \n");
    }
}
