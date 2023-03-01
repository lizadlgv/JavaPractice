package ru.dolgova.practice2.command.executor;

import lombok.SneakyThrows;
import ru.dolgova.practice2.ApplicationDataSource;
import ru.dolgova.practice2.command.CommandType;

import java.sql.PreparedStatement;

public class DirectorRemove implements CommandExecutor {

    private static final String SQL_DELETE = "delete from directorTab where directorid = ?";

    @Override
    public int execute(String text) {
        return removeDirector(text);
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.DELETE_DIRECTOR;
    }

    @SneakyThrows
    public static int removeDirector(String text) {
        String[] words = text.split(" ");
        int set = 0;
        PreparedStatement stat = ApplicationDataSource.getConnection().prepareStatement(SQL_DELETE);
        stat.setInt(1, Integer.parseInt(words[1]));
        set = stat.executeUpdate();
        return set;
    }
}
