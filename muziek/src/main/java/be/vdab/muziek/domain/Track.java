package be.vdab.muziek.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Time;
import java.util.Objects;

@Embeddable
@Access(AccessType.FIELD)
public class Track {
    private String naam;
    private Time tijd;

    public String getNaam() {
        return naam;
    }

    public Time getTijd() {
        return tijd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Track)) return false;
        Track track = (Track) o;
        return naam.equals(track.naam) &&
                tijd.equals(track.tijd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(naam, tijd);
    }
}