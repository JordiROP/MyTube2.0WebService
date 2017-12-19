package WebService.DAO;

import WebService.BO.ServerBO;
import WebService.JDBC.ServerJDBC;

public class ServerDAO {

    private static ServerJDBC postgres = new ServerJDBC();

	public ServerBO getServerByID(int serverID) {
		return postgres.getById(serverID);
	}
}
