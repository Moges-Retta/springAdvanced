package be.vdab.muziek.domain;

public class AlbumNaamEnArtiest {
    private String naam;
    private String artiest;

    public AlbumNaamEnArtiest(Album album) {
        this.naam = album.getNaam();
        this.artiest = album.getArtist().getNaam();
    }

    public String getNaam() {
        return naam;
    }

    public String getArtiest() {
        return artiest;
    }
}
