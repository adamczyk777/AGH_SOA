package com.jadamczyk.theater.Beans;

import com.jadamczyk.theater.Exceptions.SeatDoesNotExistException;
import com.jadamczyk.theater.Interfaces.LocalSeatsServiceInterface;
import com.jadamczyk.theater.Interfaces.SeatAvailabilityServiceInterface;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless
@Remote(SeatAvailabilityServiceInterface.class)
public class SeatAvailabilityService implements SeatAvailabilityServiceInterface {
    @EJB
    private LocalSeatsServiceInterface seatsService;

    @Override
    public boolean isAvailable(int number) throws SeatDoesNotExistException {
        return seatsService.getSeatByNumber(number).isAvailable();
    }
}
