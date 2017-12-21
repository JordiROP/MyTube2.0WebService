package WebService.DAO;

import java.util.List;

import WebService.BO.ServerBO;
import WebService.JDBC.ServerJDBC;

public class ServerDAO {

    private static ServerJDBC postgres = new ServerJDBC();

	public ServerBO getServerByID(int serverID) {
		return postgres.getById(serverID);
	}

	public int insertNewServer(ServerBO serverBO) {
		return postgres.insert(serverBO);
	}

	public List<ServerBO> getAllServers() {
		return postgres.getAll();
	}

	public ServerBO getServerByHostPort(String host, String port) {
		return postgres.getByHostAndPort(host, port);
	}
}
