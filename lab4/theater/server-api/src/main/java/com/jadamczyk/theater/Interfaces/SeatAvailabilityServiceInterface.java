package com.jadamczyk.theater.Interfaces;

import com.jadamczyk.theater.Exceptions.SeatDoesNotExistException;

public interface SeatAvailabilityServiceInterface {
    boolean isAvailable(int number) throws SeatDoesNotExistException;
}
