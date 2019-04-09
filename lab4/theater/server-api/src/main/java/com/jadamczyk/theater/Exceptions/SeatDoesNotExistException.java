package com.jadamczyk.theater.Exceptions;

import java.io.Serializable;

public class SeatDoesNotExistException extends Exception implements Serializable {
    public SeatDoesNotExistException(int number) {
        super(String.format("Seat with number %d does not exist", number));
    }
}
