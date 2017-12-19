package WebService.ApiService;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

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
    public int signUser(UserBO userBo) {
        int result = userDao.insertNewUser(userBo);
        return result;
    }

    /**
     * get the information of the user by the userID.
     * @param userID
     * @return the user who has the userID param.
     */
    @Path("/{userID}")
    @GET
    @Produces("application/json")
    public UserBO getUserInformation(@PathParam("userID") String userID) {
        UserBO userBo = userDao.getUserById(Integer.parseInt(userID));
        return userBo;
    }
    
    
}
