package Kontenery;

import Nadawca.Nadawca;

public class KonPodstawowy extends Kontener {
    int iloscpalet;

    public KonPodstawowy(Nadawca nadawca, int tara, boolean zabezpieczenia, int wagaNetto, int wagaBrutto, int iloscpalet) {
        super(nadawca, tara, zabezpieczenia, wagaNetto, wagaBrutto);
        this.iloscpalet = iloscpalet;
        this.rodzaj = "Podstawowy";
    }



    public int getIloscpalet() {
        return iloscpalet;
    }

    @Override
    public String toString() {
        return super.toString() + " Ilosc palet: " + getIloscpalet();
    }

}
