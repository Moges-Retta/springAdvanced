package be.vdab.xml.services;

public class DefaultKwadraatService implements KwadraatService{
    @Override
    public int kwadraat(int getal) {
        return getal * getal;
    }
}
