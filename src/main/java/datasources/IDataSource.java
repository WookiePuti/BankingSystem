package datasources;

import java.sql.Connection;

public interface IDataSource {
    void executeUpdate(String inStatement);
}
