package com.jadamczyk.theater.Beans;

import com.jadamczyk.theater.Exceptions.SeatDoesNotExistException;
import com.jadamczyk.theater.Exceptions.SeatUnavailableException;
import com.jadamczyk.theater.Interfaces.LocalSeatsServiceInterface;
import com.jadamczyk.theater.Interfaces.SeatsServiceInterface;
import com.jadamczyk.theater.Models.Seat;
import com.jadamczyk.theater.Repositories.SeatsRepository;

import javax.ejb.*;
import java.util.List;

@Singleton
@Remote(SeatsServiceInterface.class)
@Local(LocalSeatsServiceInterface.class)
public class SeatsService implements SeatsServiceInterface, LocalSeatsServiceInterface {
    @EJB
    private SeatsRepository seatsRepository;

    @Override
    public List<Seat> getSeatList() {
        return seatsRepository.getSeats();
    }

    public int getSeatPrice(int number) throws SeatDoesNotExistException {
        return getSeatPrice(getSeatByNumber(number));
    }

    private int getSeatPrice(Seat seat) {
        return seat.getPrice();
    }

    public void buyTicket(int number) throws SeatUnavailableException, SeatDoesNotExistException {
        buyTicket(getSeatByNumber(number));
    }

    @Lock
    private void buyTicket(Seat seat) throws SeatUnavailableException {
        if (!seat.isAvailable()) {
            throw new SeatUnavailableException(seat.getNumber());
        }

        seat.setAvailable(false);
    }

    public Seat getSeatByNumber(int number) throws SeatDoesNotExistException {
        Seat seat = seatsRepository.getSeatByNumber(number);

        if (seat == null) {
            throw new SeatDoesNotExistException(number);
        }

        return seat;
    }
}
