package WebService.ApiService;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

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
    
    /**
     * Add new content to the DB
     * @param userBo the new content to add
     * @return result - > the ID of the new content
     */
    @Path("/new")
    @POST
    public int uploadContent(ContentBO contentBO){
    	 int result = contentDAO.insertNewCotent(contentBO);
         return result;
    }

    @Path("/{contentID}")
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
    @Path("/user/{userID}")
    @GET
    @Produces("application/json")
    public List<ContentBO> getcontentsFromUser(@PathParam("userID") int userID) {
        return contentDAO.getContentByUserID(userID);
    }
    
    @Path("/{contentID}")
    @PUT
    public int updateContent(@PathParam("userID") int userID, ContentBO contentBO){
        return contentDAO.updateContent(userID, contentBO);
    }

    @Path("/{contentID}")
    @DELETE
    public int deleteContent(@PathParam("contentID") int contentID){
        return contentDAO.deleteByID(contentID);
    }
}
