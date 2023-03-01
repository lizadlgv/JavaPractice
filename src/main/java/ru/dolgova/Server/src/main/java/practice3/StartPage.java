package practice3;

import ru.dolgova.practice2.ApplicationDataSource;
import practice4.SelectReq;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StartPage {

    public static List<SelectReq> view() throws SQLException {
        Statement statement = ApplicationDataSource.getConnection().createStatement();
        ResultSet set = statement.executeQuery("select * from directorTab join filmTab on directorTab.directorid = filmTab.directorid;");
        return readSelect(set);
    }

    public static List<SelectReq> readSelect(ResultSet set) throws SQLException {
        List<SelectReq> rowsList = new ArrayList<>();
        ResultSetMetaData data = set.getMetaData();
        int columnsNumber = data.getColumnCount();
        while (set.next()) {
            List<String> row = new ArrayList<>();
            for (int i = 1; i <= columnsNumber; i++) {
                row.add(set.getString(i));
            }
            SelectReq req = new SelectReq(row.get(0), row.get(1), row.get(2), row.get(3), row.get(4), row.get(5), row.get(6), row.get(7));
            rowsList.add(req);
        }
        return rowsList;
    }
}