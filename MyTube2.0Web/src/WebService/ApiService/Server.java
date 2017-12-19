package WebService.ApiService;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import WebService.BO.ServerBO;
import WebService.DAO.ServerDAO;

public class Server {
	ServerDAO serverDAO = new ServerDAO();
	/**
	 * Shows the information of the server with ID serverId
	 * @param serverID
	 * @return the ServerBO object that corresponds to serverID
	 */
    @Path("/server/{serverID}")
    @GET
    @Produces("application/json")
    public ServerBO getServerInfo(@PathParam("serverID") int serverID){
        return serverDAO.getServerByID(serverID);
    }

    /**
     * Add new server to the DB
     * @param serverBo the new server to add
     * @return result-> the ID of the new Server
     */
    @Path("/new")
    @POST
    public int connectNewServer(ServerBO serverBO){
    	int result = serverDAO.insertNewServer(serverBO);
        return result;
    }
}
