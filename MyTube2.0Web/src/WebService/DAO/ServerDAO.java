package WebService.DAO;

import WebService.BO.ServerBO;
import WebService.JDBC.PostgreSQLJDBC;

public class ServerDAO {

    private static PostgreSQLJDBC postgres = new PostgreSQLJDBC();

	public ServerBO getServerByID(String serverID) {
		return postgres.getServerByID(serverID);
		
	}
}
