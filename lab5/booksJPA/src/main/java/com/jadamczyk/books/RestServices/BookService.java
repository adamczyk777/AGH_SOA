package com.jadamczyk.books.RestServices;

import com.jadamczyk.books.DAO.AuthorDAO;
import com.jadamczyk.books.DAO.BookDAO;
import com.jadamczyk.books.Entities.Author;
import com.jadamczyk.books.Entities.Book;
import com.jadamczyk.books.JSON.PlainBook;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/books")
public class BookService {

    private BookDAO bookDAO = new BookDAO();

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getBooks() {
        List<Book> books = bookDAO.findAll();

        return Response.ok().entity(books).build();
    }

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getBook(@PathParam("id") Integer id) {
        return Response.ok().entity(bookDAO.findById(id)).build();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getBooksByAuthor(@QueryParam("authorId") Integer id) {
        AuthorDAO authorDAO = new AuthorDAO();
        Author author = authorDAO.findById(id);
        return Response.ok().entity(bookDAO.findByAuthor(author)).build();
    }

    @GET
    @Path("{id}/rentals")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getBookRentals(@PathParam("id") Integer id) {
        return Response.ok().entity(bookDAO.findById(id).getRentals()).build();
    }

    @DELETE
    @Produces({MediaType.APPLICATION_JSON})
    public Response deleteBook(@QueryParam("id") Integer id) {
        try {
            Book toDelete = bookDAO.findById(id);
            bookDAO.delete(toDelete);
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
    public Response insertBook(PlainBook payload) {
        try {
            Book newBook = new Book();

            newBook.setAuthor(payload.getAuthor());
            newBook.setTitle(payload.getTitle());
            bookDAO.insert(newBook);

            return Response.ok().entity(newBook).build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

    @PUT
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response updateBook(PlainBook payload) {
        try {
//            if (payload.getId()) return Response.status(Response.Status.BAD_REQUEST).build();

            Book bookToUpdate = bookDAO.findById(payload.getId());

            if (payload.getAuthor() != null) bookToUpdate.setAuthor(payload.getAuthor());
            if (payload.getTitle() != null) bookToUpdate.setTitle(payload.getTitle());

            bookDAO.update(bookToUpdate);

            return Response.ok().entity(bookToUpdate).build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }
}
