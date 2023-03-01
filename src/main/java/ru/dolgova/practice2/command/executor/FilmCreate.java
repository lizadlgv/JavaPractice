package ru.dolgova.practice2.command.executor;

import lombok.SneakyThrows;
import ru.dolgova.practice2.ApplicationDataSource;
import ru.dolgova.practice2.command.CommandType;

import java.sql.Statement;

public class FilmCreate implements CommandExecutor {
    @Override
    public int execute(String text) {
        return createFilm(text);
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.CREATE_FILM;
    }

    @SneakyThrows
    public static int createFilm(String text) {
        String[] words = text.split(" ");
        StringBuilder title = new StringBuilder();
        String req;
        int set = 0;
        Statement statement = ApplicationDataSource.getConnection().createStatement();
        if (words.length > 5) {
            for (int i = 2; i != words.length - 2; i++) {
                title.append(words[i]).append(" ");
            }
            req = "insert into filmTab(id, title, rating, directorID) values(" + words[1]
                    + ",'" + title + "'," + words[words.length - 2] + "," + words[words.length - 1] + ");";
            set = statement.executeUpdate(req);
            return set;
        }
        req = "insert into filmTab(id, title, rating, directorID) values(" + words[1]
                + ",'" + words[2] + "'," + words[3] + "," + words[4] + ");";
        set = statement.executeUpdate(req);
        statement.close();
        return set;
    }
}
