package Kontenery;

import Nadawca.Nadawca;

public class KonCiekle extends KonPodstawowy {
    String rodzajCieczy;

    public KonCiekle(Nadawca nadawca, int tara, boolean zabezpieczenia, int wagaNetto, int wagaBrutto, int iloscpalet, String rodzajCieczy) {
        super(nadawca, tara, zabezpieczenia, wagaNetto, wagaBrutto, iloscpalet);
        this.rodzaj = "Ciekle";
        this.rodzajCieczy = rodzajCieczy;
    }

    public String getRodzajCieczy() {
        return rodzajCieczy;
    }



    @Override
    public String toString() {
        return super.toString() + ", Rodzaj cieczy: " + getRodzajCieczy();
    }
}
