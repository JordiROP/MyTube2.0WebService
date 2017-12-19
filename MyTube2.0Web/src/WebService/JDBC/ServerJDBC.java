package WebService.JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import WebService.BO.ServerBO;

public class ServerJDBC extends PostgreSQLJDBC{
	public ServerBO getById(int id){
    	return selectQuery("id="+String.valueOf(id)).get(0);
    }
	
	private List<ServerBO> selectQuery(String whereConditions) {
		openConnection();
        Statement stmt;
        List<ServerBO> servers = new ArrayList<>();
        try {
        	stmt = c.createStatement();
            String sql = "SELECT * FROM server WHERE "+whereConditions+";";
            ResultSet rs =stmt.executeQuery(sql);
            
            while (rs.next()) {
            	ServerBO serverBO = new ServerBO();
                serverBO.setId(Integer.parseInt(rs.getString("id")));
                serverBO.setHost(rs.getString("username"));
                serverBO.setPort(rs.getInt("port"));
                servers.add(serverBO);
            }
            closeConnection();
            

        } catch (SQLException e) {
            System.err.println("problem executing the query");
            closeConnection();
        }
        return servers;
	}
}
