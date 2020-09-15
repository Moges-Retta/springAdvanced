package be.vdab.restservice.domain;

public class FiliaalIdNaam {
    private final long id;
    private final String naam;

    public FiliaalIdNaam(Filiaal filiaal) {
        id = filiaal.getId();
        naam = filiaal.getNaam();
    }

    public long getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }
}
