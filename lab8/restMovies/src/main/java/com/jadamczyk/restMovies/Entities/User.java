package com.jadamczyk.restMovies.Entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String avatarUri;

    @OneToMany(mappedBy = "user")
    private List<CollectionElement> collection;

    public List<CollectionElement> getCollection() {
        return collection;
    }

    public void setCollection(List<CollectionElement> collection) {
        this.collection = collection;
    }
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatarUri() {
        return avatarUri;
    }

    public void setAvatarUri(String avatarUri) {
        this.avatarUri = avatarUri;
    }
}
