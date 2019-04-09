package com.jadamczyk.theater.Interfaces;

import com.jadamczyk.theater.Exceptions.SeatDoesNotExistException;
import com.jadamczyk.theater.Exceptions.SeatUnavailableException;
import com.jadamczyk.theater.Models.Seat;

public interface LocalSeatsServiceInterface {
    Seat getSeatByNumber(int number) throws SeatDoesNotExistException;

    int getSeatPrice(int number) throws SeatDoesNotExistException;

    void buyTicket(int number) throws SeatUnavailableException, SeatDoesNotExistException;
}
