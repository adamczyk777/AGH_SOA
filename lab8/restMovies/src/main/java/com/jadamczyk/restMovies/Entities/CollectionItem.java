package com.jadamczyk.restMovies.Entities;

import javax.persistence.*;

@Entity
@Table(name = "user_movie")
public class CollectionItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "movie", referencedColumnName = "id")
    private Movie movie;

    @OneToOne
    @JoinColumn(name = "user", referencedColumnName = "id")
    private User user;

    public Integer getId() {
        return id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
