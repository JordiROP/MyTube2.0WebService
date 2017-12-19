package WebService.ApiService;

import WebService.BO.UserBO;
import WebService.DAO.UserDAO;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/user")
public class User{

    UserDAO userDao = new UserDAO();
    private static final String SUCCESS_RESULT="{ \"result\": \"succes\" }";
    private static final String FAILURE_RESULT="{ \"result\": \"failure\" }";

    /**
     * Add new user to the DB
     * @param userBo the new user to add
     * @return result
     */
    @Path("/new")
    @POST
    public String signUser(UserBO userBo) {
        int result = userDao.insertNewUser(userBo);
        if(result == 1){
            return SUCCESS_RESULT;
        }
        return FAILURE_RESULT;
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
