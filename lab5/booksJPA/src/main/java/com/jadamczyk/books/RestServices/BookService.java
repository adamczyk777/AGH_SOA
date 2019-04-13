package com.jadamczyk.books.RestServices;

import com.jadamczyk.books.BookDAO;
import com.jadamczyk.books.Entities.Book;

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

    @DELETE
    @Produces({MediaType.APPLICATION_JSON})
    public Response deleteBook(@QueryParam("id") Integer id) {
        try {
            Book toDelete = bookDAO.findById(id);
            bookDAO.deleteBook(toDelete);
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
    public Response insertBook(Book payload) {
        try {
            Book newBook = new Book();

            newBook.setIsbn(payload.getIsbn());
            newBook.setName(payload.getName());
            newBook.setSurname(payload.getSurname());
            newBook.setTitle(payload.getTitle());
            newBook.setPrice(payload.getPrice());
            newBook.setPublishYear(payload.getPublishYear());
            bookDAO.insertBook(newBook);

            return Response.ok().entity(newBook).build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

    @PUT
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response updateBook(Book payload) {
        try {
            if (payload.getId() == null) return Response.status(Response.Status.BAD_REQUEST).build();

            Book bookToUpdate = bookDAO.findById(payload.getId());

            if (payload.getName() != null) bookToUpdate.setName(payload.getName());
            if (payload.getSurname() != null) bookToUpdate.setSurname(payload.getSurname());
            if (payload.getTitle() != null) bookToUpdate.setTitle(payload.getTitle());
            if (payload.getPrice() != null) bookToUpdate.setPrice(payload.getPrice());
            if (payload.getIsbn() != null) bookToUpdate.setIsbn(payload.getIsbn());
            if (payload.getPublishYear() != null) bookToUpdate.setPublishYear(payload.getPublishYear());

            bookDAO.updateBook(bookToUpdate);

            return Response.ok().entity(bookToUpdate).build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }
}
