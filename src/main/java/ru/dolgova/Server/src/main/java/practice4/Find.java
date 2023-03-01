package practice4;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Find {
    public ArrayList<SelectReq> getDirector() throws SQLException, ClassNotFoundException {
        ArrayList<SelectReq> seconds = new ArrayList<>();
        String sql = "SELECT * FROM directorTab";
        Class.forName("org.postgresql.Driver");
        Statement statement = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "97Polabe").createStatement();
        ResultSet res = statement.executeQuery(sql);
        while (res.next()) {
            seconds.add(new SelectReq(res.getString("directorId"), res.getString("name"), res.getString("secondName"), res.getString("BDay"), res.getString("sex")));
        }
        return seconds;
    }

    public ArrayList<SelectReq> getFilm() throws SQLException, ClassNotFoundException {
        ArrayList<SelectReq> firsts = new ArrayList<>();
        String sql = "SELECT * FROM filmTab";
        Class.forName("org.postgresql.Driver");
        Statement statement = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "97Polabe").createStatement();
        ResultSet res = statement.executeQuery(sql);
        while (res.next()) {
            firsts.add(new SelectReq(res.getString("id"), res.getString("title"), res.getString("rating"), res.getString("directorId")));
        }
        return firsts;
    }

    public SelectReq findDirector(String directorid) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM directorTab where directorId=" + directorid;
        Class.forName("org.postgresql.Driver");
        Statement statement = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "97Polabe").createStatement();
        ResultSet res = statement.executeQuery(sql);
        while (res.next()) {
            return new SelectReq(res.getString("directorId"), res.getString("name"), res.getString("secondName"), res.getString("BDay"), res.getString("sex"));
        }
        return null;
    }

    public SelectReq findFilm(String id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM filmTab where id=" + id;
        Class.forName("org.postgresql.Driver");
        Statement statement = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "97Polabe").createStatement();
        ResultSet res = statement.executeQuery(sql);
        while (res.next()){
            return new SelectReq(res.getString("id"), res.getString("title"), res.getString("rating"), res.getString("directorId"));
        }
        return null;
    }
}
