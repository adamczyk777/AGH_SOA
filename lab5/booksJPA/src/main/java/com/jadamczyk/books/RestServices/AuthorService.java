package com.jadamczyk.books.RestServices;

import com.jadamczyk.books.DAO.AuthorDAO;
import com.jadamczyk.books.Entities.Author;
import com.jadamczyk.books.Entities.Book;
import com.jadamczyk.books.Entities.Rental;
import com.jadamczyk.books.JSON.PlainAuthor;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.LinkedList;
import java.util.List;


@Path("/author")
public class AuthorService {
    private AuthorDAO authorDAO = new AuthorDAO();

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getBooks() {
        List<Author> authors = authorDAO.findAll();

        return Response.ok().entity(authors).build();
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getBook(@PathParam("id") Integer id) {
        Author author = authorDAO.findById(id);
        return Response.ok().entity(author).build();
    }

    @GET
    @Path("{id}/books")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getAuthorBooks(@PathParam("id") Integer id) {
        Author author = authorDAO.findById(id);
        return Response.ok().entity(author.getBooks()).build();
    }

    @GET
    @Path("{id}/rentals")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getAuthorRentals(@PathParam("id") Integer id) {
        Author author = authorDAO.findById(id);
        List<Rental> rentals = new LinkedList<>();
        List<Book> books = author.getBooks();
        books.stream().forEach(book -> rentals.addAll(book.getRentals()));
        return Response.ok().entity(rentals).build();
    }

    @DELETE
    @Produces({MediaType.APPLICATION_JSON})
    public Response deleteBook(@QueryParam("id") Integer id) {
        try {
            Author toDelete = authorDAO.findById(id);
            authorDAO.delete(toDelete);
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
    public Response insertBook(PlainAuthor payload) {
        try {
            Author newAuthor = new Author();

            newAuthor.setName(payload.getName());
            newAuthor.setSurname(payload.getSurname());
            authorDAO.insert(newAuthor);

            return Response.ok().entity(newAuthor).build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

    @PUT
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response updateBook(PlainAuthor payload) {
        try {
            if (payload.getId() == null) return Response.status(Response.Status.BAD_REQUEST).build();

            Author authorToUpdate = authorDAO.findById(payload.getId());

            if (payload.getName() != null) authorToUpdate.setName(payload.getName());
            if (payload.getSurname() != null) authorToUpdate.setSurname(payload.getSurname());

            authorDAO.update(authorToUpdate);

            return Response.ok().entity(authorToUpdate).build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }
}
