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
	
	public int insert(ServerBO serverBO) {
		openConnection();
        Statement stmt;
        try {
            stmt = c.createStatement();
            String sql = "INSERT INTO server (host, port) "
                    + "VALUES ('"+serverBO.getHost()+"', '"+serverBO.getPort()+"');";
            stmt.executeUpdate(sql);
            			
            closeConnection();
        } catch (SQLException e) {
            System.err.println("problem executing the query");
            closeConnection();
        }
        return getNewstUseRID();
	}
	
	private int getNewstUseRID(){
    	int id = -1;
    	openConnection();
        Statement stmt;
        try {
        	stmt = c.createStatement();
        	String sql = "SELECT timestamp,server_id from server order by timestamp desc limit 1";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
            	id = rs.getInt("server_id");
            }
            closeConnection();
            

        } catch (SQLException e) {
            System.err.println("problem executing the query");
            closeConnection();
        }
        return id;
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
