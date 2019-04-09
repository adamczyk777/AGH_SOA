package com.jadamczyk.theater.Beans;


import com.jadamczyk.theater.Exceptions.NotEnoughFundsException;
import com.jadamczyk.theater.Exceptions.SeatDoesNotExistException;
import com.jadamczyk.theater.Exceptions.SeatUnavailableException;
import com.jadamczyk.theater.Interfaces.LocalSeatsServiceInterface;
import com.jadamczyk.theater.Interfaces.TicketsServiceInterface;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateful;

@Stateful
@Remote(TicketsServiceInterface.class)
public class TicketsService implements TicketsServiceInterface {
    @EJB
    private LocalSeatsServiceInterface seatsService;

    private int wallet = 1000;

    @Override
    public void buyTicket(int number) throws SeatDoesNotExistException, NotEnoughFundsException, SeatUnavailableException {
        int price = seatsService.getSeatPrice(number);

        if (price > wallet) {
            throw new NotEnoughFundsException(number, price, wallet);
        }

        seatsService.buyTicket(number);
        wallet -= price;
    }

    @Override
    public int getWallet() {
        return wallet;
    }
}
