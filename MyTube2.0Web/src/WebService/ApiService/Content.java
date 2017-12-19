package WebService.ApiService;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import WebService.BO.ContentBO;
import WebService.DAO.ContentDAO;

@Path("/content")
public class Content {
	
	ContentDAO contentDAO = new ContentDAO();
    @Path("/")
    @GET
    @Produces("application/json")
    public List<ContentBO> getListOfContents(){
        return contentDAO.getListOfContents();
    }

    @Path("/content")
    @POST
    public int uploadContent(ContentBO contentBO){
    	 int result = contentDAO.insertNewCotent(contentBO);
         return result;
    }

    @Path("/content/{contentID}")
    @GET
    @Produces("application/json")
    public ContentBO getSearchContentByID(@PathParam("contentID") int contentID){
        return contentDAO.getContentByID(contentID);
    }
    
    /**
     * Returns the list of contents of this user.
     * @param userID
     * @return
     */
    @Path("/content/{userID}")
    @GET
    @Produces("application/json")
    public List<ContentBO> getcontentsFromUser(@PathParam("userID") String userID) {
        return null;
    }
    
    @Path("/{contentID}/server")
    @GET
    //Si volem XML tmb es pot
    @Produces("application/json")
    public String getAllContent(@PathParam("contentID") String contentID){

        return null;
    }

    @Path("/content/{contentID}/download")
    @GET
    @Produces("application/json")
    public String downloadContent(@PathParam("contentID") String contentID){
        return null;
    }
    
    @Path("/content/{contentID}")
    @PUT
    public Response updateContent(@FormParam("userID") String userID, @Context HttpServletResponse servletResponse){
        /*EXEMPLE ----> https://www.tutorialspoint.com/restful/restful_methods.htm */
        return null;
    }

    @Path("/content/{contentID}")
    @DELETE
    public Response deleteContent(@PathParam("contentID") String userID){
        /*EXEMPLE ----> https://www.tutorialspoint.com/restful/restful_methods.htm */
        return null;
    }
}
