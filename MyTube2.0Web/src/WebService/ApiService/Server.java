package WebService.ApiService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
    @Produces(MediaType.APPLICATION_JSON)
    public ServerBO getServerInfo(@PathParam("serverID") int serverID){
        return serverDAO.getServerByID(serverID);
    }

    
}
