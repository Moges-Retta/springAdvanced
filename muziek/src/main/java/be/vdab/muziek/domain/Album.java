package be.vdab.muziek.domain;

import javax.persistence.*;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name="albums")
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String naam;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "artiestid")
    private Artist artist;
    @ElementCollection
    @CollectionTable(name = "tracks", joinColumns = @JoinColumn(name = "albumid"))
    private Set<Track> tracks = new LinkedHashSet<>();

    public Album(String naam, Artist artist) {
        this.naam = naam;
        this.artist = artist;
    }

    protected Album(){}
    public long getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }

    public Artist getArtist() {
        return artist;
    }

    public Set<Track> getTracks() {
        return Collections.unmodifiableSet(tracks);
    }
}
