package com.jadamczyk.books.RestServices;

import com.jadamczyk.books.DAO.ReaderDAO;
import com.jadamczyk.books.Entities.Author;
import com.jadamczyk.books.Entities.Book;
import com.jadamczyk.books.Entities.Reader;
import com.jadamczyk.books.Entities.Rental;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.LinkedList;
import java.util.List;

@Path("/reader")
public class ReaderService {
    private ReaderDAO readerDAO = new ReaderDAO();

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getBooks() {
        List<Reader> authors = readerDAO.findAll();

        return Response.ok().entity(authors).build();
    }

    @DELETE
    @Produces({MediaType.APPLICATION_JSON})
    public Response deleteBook(@QueryParam("id") Integer id) {
        try {
            Reader toDelete = readerDAO.findById(id);
            readerDAO.delete(toDelete);
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

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getBook(@PathParam("id") Integer id) {
        Reader reader = readerDAO.findById(id);
        return Response.ok().entity(reader).build();
    }

    @GET
    @Path("{id}/rentals")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getReaderRentals(@PathParam("id") Integer id) {
        return Response.ok().entity(readerDAO.findById(id).getRentals()).build();
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response insertBook(Reader payload) {
        try {
            Reader newReader = new Reader();

            newReader.setName(payload.getName());
            newReader.setSurname(payload.getSurname());
            readerDAO.insert(newReader);

            return Response.ok().entity(newReader).build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

    @PUT
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response updateBook(Reader payload) {
        try {
            if (payload.getId() == null) return Response.status(Response.Status.BAD_REQUEST).build();

            Reader readerToUpdate = readerDAO.findById(payload.getId());

            if (payload.getName() != null) readerToUpdate.setName(payload.getName());
            if (payload.getSurname() != null) readerToUpdate.setSurname(payload.getSurname());

            readerDAO.update(readerToUpdate);

            return Response.ok().entity(readerToUpdate).build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }
}
