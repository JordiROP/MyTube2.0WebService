package WebService.JDBC;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgreSQLJDBC {
    Connection c = null;

    protected void openConnection() {
        try {
            String dbURL = "jdbc:postgresql://localhost:5432/mytube2?user=postgres&password=1234";
            c = DriverManager.getConnection(dbURL);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("problem opening the connection");
            System.exit(0);
        }
        System.out.println("Opened database successfully");
    }

    protected void closeConnection(){
        try {
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("problem closing the connection");
        }
        System.out.println("Closed database successfully");
    }
    
}