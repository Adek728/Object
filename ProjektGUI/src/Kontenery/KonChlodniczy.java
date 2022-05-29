package Kontenery;

import Nadawca.Nadawca;

public class KonChlodniczy extends KonCiezki {
    int iloscWyjscDoSieci;

    public KonChlodniczy(Nadawca nadawca, int tara, boolean zabezpieczenia, int wagaNetto, int wagaBrutto, int iloscpalet, String rodzajWykonczenia, int iloscWyjscDoSieci) {
        super(nadawca, tara, zabezpieczenia, wagaNetto, wagaBrutto, iloscpalet, rodzajWykonczenia);
        this.rodzaj = "Chlodniczy";
        this.iloscWyjscDoSieci = iloscWyjscDoSieci;
    }



    public int getIloscWyjscDoSieci() {
        return iloscWyjscDoSieci;
    }

    @Override
    public String toString() {
        return super.toString() + ", Ilosc wyjsc do sieci: " + getIloscWyjscDoSieci();
    }
}
