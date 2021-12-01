package utilities;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;

import java.sql.*;

public class JDBC extends Base {

    public static void createDatabaseExample() {
        //Registering the Driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //Getting the connection
        String mysqlUrl = "jdbc:mysql://localhost/";
        openConnection(mysqlUrl, dbUserName, dbPassword);
        //Query to create a database
        String query = "CREATE database IF NOT EXISTS users";
        executeQuery(query);
        closeConnection();
        openConnection(dbURL, dbUserName, dbPassword);
        createTableIfNotExists();
    }

    @Description("CREATE TABLE IF NOT EXISTS")
    private static void createTableIfNotExists() {
        DatabaseMetaData dbm = null;
        try {
            dbm = con.getMetaData();
            // check if "TableName" table is there
            ResultSet tables = dbm.getTables(null, "users", "user", new String[]{"TABLE"});
            while (tables.next()) {
                // Table exists
                System.out.println(tables.getString("TABLE_NAME"));

            }

            // Table does not exist
            String sqlCreate = "CREATE TABLE if not exists `users`.`user` (" +
                    "  `username` VARCHAR(16) NOT NULL," +
                    "  `password` VARCHAR(32) NOT NULL);";
            executeQuery(sqlCreate);
            sqlCreate = "INSERT INTO `users`.`user` (`username`,`password`) VALUES ('admin','admin');";
            executeQuery(sqlCreate);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    private static void executeQuery(String query) {
        try {
            stmt.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Description("Open a connection to the Database using a username & password")
    public static void openConnection(String dbURL, String dbUserName, String dbPassword) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(dbURL, dbUserName, dbPassword);
            System.out.println("Connection established......");
            stmt = con.createStatement();
        } catch (Exception e) {
            System.out.println("Error Occurred while Connecting to DB, See Details: " + e);
        }
    }

    @Description("Close the connection to the Database")
    public static void closeConnection() {
        try {
            con.close();
        } catch (Exception e) {
            System.out.println("Error Occurred while Closing DB, See Details: " + e);
        }
    }
}
