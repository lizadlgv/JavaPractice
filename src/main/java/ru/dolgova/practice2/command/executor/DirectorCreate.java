package ru.dolgova.practice2.command.executor;

import lombok.SneakyThrows;
import ru.dolgova.practice2.ApplicationDataSource;
import ru.dolgova.practice2.command.CommandType;

import java.sql.Statement;

public class DirectorCreate implements CommandExecutor {
    @Override
    public int execute(String text) {
        return createDirector(text);
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.CREATE_DIRECTOR;
    }

    @SneakyThrows
    public static int createDirector(String text) {
        String[] words = text.split(" ");
        int set = 0;
        Statement statement = ApplicationDataSource.getConnection().createStatement();
        set = statement.executeUpdate("insert into directorTab(directorid, name, secondname, bday, sex) values(" + words[1]
                + ",'" + words[2] + "','" + words[3] + "','" + words[4] + "','" + words[5] + "');");
        statement.close();
        return set;
    }
}
