package be.vdab.muziek.domain;

import javax.persistence.*;
import javax.persistence.criteria.Fetch;

@Entity
@Table(name="artiesten")
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String naam;

    public Artist(String naam) {
        this.naam = naam;
    }
    protected Artist(){

    }

    public long getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }
}
