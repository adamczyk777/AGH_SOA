package com.jadamczyk.books.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "leases")
public class Lease {
    @Id
    private int id;
}
