package WebService.JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import WebService.BO.ServerBO;

public class ServerJDBC extends PostgreSQLJDBC{
	
	public List<ServerBO> getAll() {
		return selectQuery();
	}
	
	public ServerBO getById(int id){
    	return selectQuery("id="+String.valueOf(id)).get(0);
    }
	
	public ServerBO getByHostAndPort(String host, String port) {
		return selectQuery("host='"+host+"' AND port='"+port+"'").get(0);
	}
	
	public int insert(ServerBO serverBO) {
		openConnection();
        Statement stmt;
        try {
            stmt = c.createStatement();
            String sql = "INSERT INTO mytube_server (host, port) "
                    + "VALUES ('"+serverBO.getHost()+"', '"+serverBO.getPort()+"');";
            stmt.executeUpdate(sql);
            			
            closeConnection();
        } catch (SQLException e) {
            System.err.println("problem executing the query");
            closeConnection();
            return -1;
        }
        return 1;
	}
	
	
	private List<ServerBO> selectQuery(){
		return selectQuery("1=1");
	}
	
	private List<ServerBO> selectQuery(String whereConditions) {
		openConnection();
        Statement stmt;
        List<ServerBO> servers = new ArrayList<>();
        try {
        	stmt = c.createStatement();
            String sql = "SELECT * FROM mytube_server WHERE "+whereConditions+";";
            ResultSet rs =stmt.executeQuery(sql);
            
            while (rs.next()) {
            	ServerBO serverBO = new ServerBO();
                serverBO.setId(Integer.parseInt(rs.getString("id")));
                serverBO.setHost(rs.getString("host"));
                serverBO.setPort(rs.getInt("port"));
                serverBO.setOn(rs.getBoolean("on"));
                servers.add(serverBO);
            }
            closeConnection();
            

        } catch (SQLException e) {
            System.err.println("problem executing the query");
            closeConnection();
        } catch(Exception e){
        	System.err.println("problem executing the query");
            closeConnection();
        }
        return servers;
	}

	
	
}
