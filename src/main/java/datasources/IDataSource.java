package datasources;

import java.sql.Connection;
import java.sql.ResultSet;

public interface IDataSource {
    void executeUpdate(String inStatement);
    ResultSet executeReturnQuery(String inStatement);
}
