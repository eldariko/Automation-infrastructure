package utilities;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;

import java.sql.DriverManager;

public class JDBC extends Base {
    @Description("Open a connection to the Database using a username & password")
    public static void openConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(dbURL, dbUserName, dbPassword);
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
