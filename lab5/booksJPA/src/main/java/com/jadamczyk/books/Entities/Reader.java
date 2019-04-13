package com.jadamczyk.books.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "readers")
public class Reader {
    @Id
    private int id;
}
