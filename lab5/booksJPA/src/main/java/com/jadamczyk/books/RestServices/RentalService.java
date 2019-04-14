package com.jadamczyk.books.RestServices;

import com.jadamczyk.books.DAO.RentalDAO;
import com.jadamczyk.books.Entities.Rental;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/rental")
public class RentalService {

    private RentalDAO rentalDAO = new RentalDAO();

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getBooks() {
        List<Rental> authors = rentalDAO.findAll();

        return Response.ok().entity(authors).build();
    }

    @DELETE
    @Produces({MediaType.APPLICATION_JSON})
    public Response deleteBook(@QueryParam("id") Integer id) {
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
    public Response insertBook(Rental payload) {
        try {
            Rental newRental = new Rental();

            newRental.setReader(payload.getReader());
            newRental.setBook(payload.getBook());
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
    public Response updateBook(Rental payload) {
        try {
            if (payload.getId() == null) return Response.status(Response.Status.BAD_REQUEST).build();

            Rental rentalToUpdate = rentalDAO.findById(payload.getId());

            if (payload.getBook() != null) rentalToUpdate.setBook(payload.getBook());
            if (payload.getReader() != null) rentalToUpdate.setReader(payload.getReader());
            if (payload.getRentDate() != null) rentalToUpdate.setRentDate(payload.getRentDate());
            if (payload.getReturnDate() != null) rentalToUpdate.setReturnDate(payload.getReturnDate());

            rentalDAO.update(rentalToUpdate);

            return Response.ok().entity(rentalToUpdate).build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }
}
