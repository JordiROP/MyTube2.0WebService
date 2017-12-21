package WebService.ApiService;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import WebService.BO.UserBO;
import WebService.DAO.UserDAO;

@Path("/user")
public class User{

    UserDAO userDao = new UserDAO();
    
    /**
     * listAll the list of all users.
     */
    @Path("/")
    @GET
    @Produces("application/json")
    public List<UserBO> getAllUsers() {
        return userDao.getAllUsers();
    }
    
    
    /**
     * Add new user to the DB
     * @param userBo the new user to add
     * @return result - > the ID of the new user
     */
    @Path("/new")
    @POST
    public Response signUser(UserBO userBo) {
    	int response = userDao.insertNewUser(userBo);
    	if(response != -1){
    		return Response.status(200).build();
    	}else{
    		return Response.status(500).build();
    	}
    }

    /**
     * get the information of the user by the userID.
     * @param userID
     * @return the user who has the userID param.
     */
    @Path("/{userID}")
    @GET
    @Produces("application/json")
    public UserBO getUserInformationByID(@PathParam("userID") int userID) {
        return userDao.getUserById(userID);
    }
    
    /**
     * get the information of the user by the userID.
     * @param userID
     * @return the user who has the userID param.
     */
    @Path("/name/{name}")
    @GET
    @Produces("application/json")
    public List<UserBO> getUsersWithName(@PathParam("name") String name) {
        return userDao.getUsersByName(name);
    }
    
    
}
