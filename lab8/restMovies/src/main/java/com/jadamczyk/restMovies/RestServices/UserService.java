package com.jadamczyk.restMovies.RestServices;

import com.jadamczyk.restMovies.DAO.UserDAO;
import com.jadamczyk.restMovies.Entities.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/user")
public class UserService {
    private UserDAO userDAO = new UserDAO();

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getUsers() {
        List<User> users = userDAO.findAll();

        return Response.ok().entity(users).build();
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getUser(@PathParam("id") Integer id) {
        User user = userDAO.findById(id);
        return Response.ok().entity(user).build();
    }

    @DELETE
    @Produces({MediaType.APPLICATION_JSON})
    public Response deleteUser(@QueryParam("id") Integer id) {
        try {
            User toDelete = userDAO.findById(id);
            userDAO.delete(toDelete);
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
    public Response insertUser(User payload) {
        try {
            User newUser = new User();

            newUser.setName(payload.getName());
            newUser.setAvatarUri(payload.getAvatarUri());
            userDAO.insert(newUser);

            return Response.ok().entity(newUser).build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

    @PUT
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response updateUser(User payload) {
        try {
            if (payload.getId() == null) return Response.status(Response.Status.BAD_REQUEST).build();

            User userToUpdate = userDAO.findById(payload.getId());

            if (payload.getName() != null) userToUpdate.setName(payload.getName());
            if (payload.getAvatarUri() != null) userToUpdate.setAvatarUri(payload.getAvatarUri());

            userDAO.update(userToUpdate);

            return Response.ok().entity(userToUpdate).build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }
}
