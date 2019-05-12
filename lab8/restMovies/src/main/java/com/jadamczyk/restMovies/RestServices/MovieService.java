package com.jadamczyk.restMovies.RestServices;

import com.jadamczyk.restMovies.DAO.MovieDAO;
import com.jadamczyk.restMovies.Entities.Movie;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/movie")
public class MovieService {
    private MovieDAO movieDAO = new MovieDAO();

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getMovies() {
        List<Movie> movies = movieDAO.findAll();

        return Response.ok().entity(movies).build();
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getMovie(@PathParam("id") Integer id) {
        Movie movie = movieDAO.findById(id);
        return Response.ok().entity(movie).build();
    }

    @DELETE
    @Produces({MediaType.APPLICATION_JSON})
    public Response deleteMovie(@QueryParam("id") Integer id) {
        try {
            Movie toDelete = movieDAO.findById(id);
            movieDAO.delete(toDelete);
            return Response
                    .ok()
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
    public Response insertMovie(Movie payload) {
        try {
            Movie newMovie = new Movie();

            newMovie.setTitle(payload.getTitle());
            newMovie.setUri(payload.getUri());
            movieDAO.insert(newMovie);

            return Response.ok().entity(newMovie).build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

    @PUT
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response updateMovie(Movie payload) {
        try {
            if (payload.getId() == null) return Response.status(Response.Status.BAD_REQUEST).build();

            Movie movieToUpdate = movieDAO.findById(payload.getId());

            if (payload.getTitle() != null) movieToUpdate.setTitle(payload.getTitle());
            if (payload.getUri() != null) movieToUpdate.setUri(payload.getUri());

            movieDAO.update(movieToUpdate);

            return Response.ok().entity(movieToUpdate).build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }
}
