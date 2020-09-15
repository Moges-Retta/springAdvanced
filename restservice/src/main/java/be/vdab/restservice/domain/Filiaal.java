package be.vdab.restservice.domain;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@Entity
@Table(name="filialen")
@XmlRootElement(name="filiaal")
@XmlAccessorType(XmlAccessType.FIELD)
public class Filiaal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotEmpty
    private String naam;
    @NotEmpty
    private String gemeente;
    @NotNull
    @PositiveOrZero
    private BigDecimal omzet;

    public Filiaal(@NotEmpty String naam, @NotEmpty String gemeente, @NotNull @PositiveOrZero BigDecimal omzet) {
        this.naam = naam;
        this.gemeente = gemeente;
        this.omzet = omzet;
    }

    protected Filiaal(){}

    public long getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }

    public String getGemeente() {
        return gemeente;
    }

    public BigDecimal getOmzet() {
        return omzet;
    }

}