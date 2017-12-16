package WebService.ApiService;

import WebService.RestBean.BeanJson;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class Content {
    @Path("/content")
    @GET
    //Si volem XML tmb es pot
    @Produces(MediaType.APPLICATION_JSON)
    public String getSearchContent(){
        return null;
    }

    @Path("/content")
    @POST
    public Response uploadContent(BeanJson bean){
        /*String resultat = bean.getNom();
        return Response.status(201).entity(resultat).build();*/
        return null;
    }

    @Path("/content/{contentID}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getSearchContentByID(@PathParam("contentID") String contentID){
        return null;
    }

    @Path("/content/{contentID}/download")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
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
