package WebService.ApiService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

public class Server {
    @Path("/server/{serverID}")
    @GET
    //Si volem XML tmb es pot
    @Produces(MediaType.APPLICATION_JSON)
    public String getServerInfo(@PathParam("serverID") String serverID){
        //Show the information of the server with ID serverId
        return null;
    }

    @Path("/server/{serverID}/{content}")
    @GET
    //Si volem XML tmb es pot
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllContent(@PathParam("serverID") String serverID, @PathParam("content") String content){

        return null;
    }
}
