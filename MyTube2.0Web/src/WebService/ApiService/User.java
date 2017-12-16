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

    @Path("/new")
    @POST
    public String signUser(UserBO userBo) {
        int result = userDao.insertNewUser(userBo);
        if(result == 1){
            return SUCCESS_RESULT;
        }
        return FAILURE_RESULT;
    }

    @Path("/{userID}/content")
    @GET
    //Si volem XML tmb es pot
    @Produces(MediaType.APPLICATION_JSON)
    public String contentFromUser(@PathParam("userID") String userID) {
        return null;
    }

    @Path("/{userID}")
    @GET
    //Si volem XML tmb es pot
    @Produces(MediaType.APPLICATION_JSON)
    public String showUserInformation(@PathParam("userID") String userID) {
        UserBO userbo = userDao.getUserById(Integer.parseInt(userID));
        return userbo.getUsername();
    }
}
