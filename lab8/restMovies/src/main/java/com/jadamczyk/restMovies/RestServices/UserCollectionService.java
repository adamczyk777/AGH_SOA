package com.jadamczyk.restMovies.RestServices;

import com.jadamczyk.restMovies.DAO.CollectionElementDAO;
import com.jadamczyk.restMovies.DAO.MovieDAO;
import com.jadamczyk.restMovies.DAO.UserDAO;
import com.jadamczyk.restMovies.Entities.CollectionElement;
import com.jadamczyk.restMovies.Entities.Movie;
import com.jadamczyk.restMovies.Entities.User;
import com.jadamczyk.restMovies.JSON.PlainMovieId;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/{userId}/collection")
public class UserCollectionService {
    private CollectionElementDAO ceDAO = new CollectionElementDAO();
    private UserDAO userDAO = new UserDAO();
    private MovieDAO movieDAO =  new MovieDAO();

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getCollection(@PathParam("userId") Integer userId) {
        User user = userDAO.findById(userId);
        List<CollectionElement> ceList = ceDAO.findAll(user);

        return Response.ok().entity(ceList).build();
    }

    @DELETE
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response deleteCollectionElement(@PathParam("userId") Integer userId, @PathParam("id") Integer id) {
        try {
            CollectionElement toDelete = ceDAO.findById(id);
            ceDAO.delete(toDelete);
            return Response
                    .status(204)
                    .entity(toDelete)
                    .build();
        } catch (Exception e) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .build();
        }
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response insertCollectionElement(@PathParam("userId") Integer userId, PlainMovieId payload) {
        try {
            CollectionElement newCe= new CollectionElement();
            Movie movie = movieDAO.findById(payload.getId());
            User user = userDAO.findById(userId);

            newCe.setUser(user);
            newCe.setMovie(movie);
            ceDAO.insert(newCe);

            return Response.status(201).entity(newCe).build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }
}
