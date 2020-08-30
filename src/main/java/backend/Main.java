package backend;

import UI.BankSystemUI;
import datasources.PostgresDataSource;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        BankSystemUI bankSystemUI = new BankSystemUI();
        bankSystemUI.start();
//        PostgresDataSource postgresDataSource = new PostgresDataSource();
//        postgresDataSource.connect();

    }
}
