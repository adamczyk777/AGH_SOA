package com.jadamczyk.theater.Views;

import com.jadamczyk.theater.Exceptions.NotEnoughFundsException;
import com.jadamczyk.theater.Exceptions.SeatDoesNotExistException;
import com.jadamczyk.theater.Exceptions.SeatUnavailableException;
import com.jadamczyk.theater.Interfaces.SeatAvailabilityServiceInterface;
import com.jadamczyk.theater.Interfaces.SeatsServiceInterface;
import com.jadamczyk.theater.Interfaces.TicketsServiceInterface;
import com.jadamczyk.theater.Models.Seat;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named("Theater")
@SessionScoped
public class Theater implements Serializable {
    @EJB(lookup = "java:global/server/TicketsService")
    private TicketsServiceInterface ticketsService;

    @EJB(lookup = "java:global/server/SeatAvailabilityService")
    private SeatAvailabilityServiceInterface seatAvailabilityService;

    @EJB(lookup = "java:global/server/SeatsService!com.jadamczyk.theater.Interfaces.SeatsServiceInterface")
    private SeatsServiceInterface seatsService;

    private String error;

    public List<Seat> getSeats() {
        return seatsService.getSeatList();
    }

    public boolean isSeatAvailable(int number) throws SeatDoesNotExistException {
        return seatAvailabilityService.isAvailable(number);
    }

    public void buy(int number) {
        try {
            ticketsService.buyTicket(number);
            error = null;
        } catch (NotEnoughFundsException | SeatDoesNotExistException | SeatUnavailableException e) {
            error = e.getMessage();
        }
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public int getWallet() {
        return ticketsService.getWallet();
    }
}

