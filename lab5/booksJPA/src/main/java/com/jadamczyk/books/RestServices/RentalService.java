package com.jadamczyk.books.RestServices;

import com.jadamczyk.books.DAO.BookDAO;
import com.jadamczyk.books.DAO.ReaderDAO;
import com.jadamczyk.books.DAO.RentalDAO;
import com.jadamczyk.books.Entities.Rental;
import com.jadamczyk.books.JSON.PlainRental;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/rental")
public class RentalService {
    private BookDAO bookDAO= new BookDAO();
    private ReaderDAO readerDAO = new ReaderDAO();

    private RentalDAO rentalDAO = new RentalDAO();

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getRentals() {
        List<Rental> authors = rentalDAO.findAll();

        return Response.ok().entity(authors).build();
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getRental(@PathParam("id") Integer id) {
        try {
            return Response.ok().entity(rentalDAO.findById(id)).build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getRentalByAuthor(@QueryParam("authorId") Integer id) {
        try {
            List<Rental> rentals = rentalDAO.findByAuthor(id);

            return Response
                    .ok()
                    .entity(rentals)
                    .build();
        } catch (Exception e) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .build();
        }
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getRentalByBook(@QueryParam("bookId") Integer id) {
        try {
            List<Rental> rentals = rentalDAO.findByBook(id);

            return Response
                    .ok()
                    .entity(rentals)
                    .build();
        } catch (Exception e) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .build();
        }
    }


    @DELETE
    @Produces({MediaType.APPLICATION_JSON})
    public Response deleteRental(@QueryParam("id") Integer id) {
        try {
            Rental toDelete = rentalDAO.findById(id);
            rentalDAO.delete(toDelete);
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
    public Response insertRental(PlainRental payload) {
        try {
            Rental newRental = new Rental();

            newRental.setReader(readerDAO.findById(payload.getReaderId()));
            newRental.setBook(bookDAO.findById(payload.getBookId()));
            newRental.setRentDate(payload.getRentDate());
            newRental.setReturnDate(payload.getReturnDate());
            rentalDAO.insert(newRental);

            return Response.ok().entity(newRental).build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

    @PUT
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response updateRental(PlainRental payload) {
        try {
            if (payload.getId() == null) return Response.status(Response.Status.BAD_REQUEST).build();

            Rental rentalToUpdate = rentalDAO.findById(payload.getId());

            if (payload.getBookId() != null) rentalToUpdate.setBook(bookDAO.findById(payload.getBookId()));
            if (payload.getReaderId() != null) rentalToUpdate.setReader(readerDAO.findById(payload.getReaderId()));
            if (payload.getRentDate() != null) rentalToUpdate.setRentDate(payload.getRentDate());
            if (payload.getReturnDate() != null) rentalToUpdate.setReturnDate(payload.getReturnDate());

            rentalDAO.update(rentalToUpdate);

            return Response.ok().entity(rentalToUpdate).build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }
}
