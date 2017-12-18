package WebService.JDBC;


import WebService.BO.UserBO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PostgreSQLJDBC {
    Connection c = null;

    public void openConnection() {
        try {
            String dbURL = "jdbc:postgresql://localhost:5432/mytube2?user=postgres&password=postgres";
            c = DriverManager.getConnection(dbURL);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("problem opening the connection");
            System.exit(0);
        }
        System.out.println("Opened database successfully");
    }

    public void closeConnection(){
        try {
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("problem closing the connection");
        }
        System.out.println("Closed database successfully");
    }

    public int insertNewUser(UserBO user){
    	openConnection();
        Statement stmt;
        try {
            stmt = c.createStatement();
            String sql = "INSERT INTO user (username, password) "
                    + "VALUES ('"+user.getUsername()+"', '"+user.getPassword()+"');";
            stmt.executeUpdate(sql);
            closeConnection();
            return 1;
        } catch (SQLException e) {
            System.err.println("problem executing the query");
            closeConnection();
            return -1;
        }
    }
    
    public UserBO getUserById(int id){
    	openConnection();
        Statement stmt;
        try {
            stmt = c.createStatement();
            String sql = "SELECT * FROM mytube_user WHERE id = "+id+";";
            ResultSet rs =stmt.executeQuery(sql);
            UserBO userBO = new UserBO();
            while (rs.next()) {
                userBO.setId(Integer.parseInt(rs.getString("id")));
                userBO.setUsername(rs.getString("username"));
                userBO.setPassword(rs.getString("password"));
            }
            closeConnection();
            return userBO;

        } catch (SQLException e) {
            System.err.println("problem executing the query");
            closeConnection();
            return null;
        }
    }
}
