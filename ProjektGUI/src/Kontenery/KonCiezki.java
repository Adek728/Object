package Kontenery;

import Nadawca.Nadawca;

public class KonCiezki extends KonPodstawowy {
    String rodzajWykonczenia;

    public KonCiezki(Nadawca nadawca, int tara, boolean zabezpieczenia, int wagaNetto, int wagaBrutto, int iloscpalet, String rodzajWykonczenia) {
        super(nadawca, tara, zabezpieczenia, wagaNetto, wagaBrutto, iloscpalet);
        this.rodzaj = "Ciezki";
        this.rodzajWykonczenia = rodzajWykonczenia;
    }


    public String getRodzajWykonczenia() {
        return rodzajWykonczenia;
    }

    @Override
    public String toString() {
        return super.toString() + ", Rodzaj Wykonczenia: " + getRodzajWykonczenia();
    }
}
