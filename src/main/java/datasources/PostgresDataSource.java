package datasources;
import java.sql.*;
import java.util.Properties;

public class PostgresDataSource implements IDataSource{

    private Connection connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://localhost:5433/spring_banking_db";
        Properties props = new Properties();
        props.setProperty("user","postgres");
        props.setProperty("password","start");

        Connection returnConn = null;

        //            try (Statement statement = conn.createStatement()){
//                statement.executeUpdate("");
//            } catch (SQLException e) {
//                e.printStackTrace();



        return DriverManager.getConnection(url, props);

    }

    @Override
    public void executeUpdate(String inStatement) {
        Connection conn = null;
        try {
            conn = connect();

            try (Statement statement = conn.createStatement()) {
                statement.executeUpdate(inStatement);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    public ResultSet executeReturnQuery(String inStatement) {
        Connection conn = null;
        try {
            conn = connect();
            Statement statement = conn.createStatement();
            return statement.executeQuery(inStatement);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return null;

    }
}
