package com.jadamczyk.theater.Interfaces;

import com.jadamczyk.theater.Exceptions.NotEnoughFundsException;
import com.jadamczyk.theater.Exceptions.SeatDoesNotExistException;
import com.jadamczyk.theater.Exceptions.SeatUnavailableException;

public interface TicketsServiceInterface {
    void buyTicket(int number) throws SeatDoesNotExistException, NotEnoughFundsException, SeatUnavailableException;

    int getWallet();
}
