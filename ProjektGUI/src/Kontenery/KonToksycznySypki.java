package Kontenery;

import Nadawca.Nadawca;

public class KonToksycznySypki extends KonCiezki{
    String rodzajZanieczyszczenia;

    public KonToksycznySypki(Nadawca nadawca, int tara, boolean zabezpieczenia, int wagaNetto, int wagaBrutto, int iloscpalet, String rodzajWykonczenia, String rodzajZanieczyszczenia) {
        super(nadawca, tara, zabezpieczenia, wagaNetto, wagaBrutto, iloscpalet, rodzajWykonczenia);
        this.rodzaj = "ToksyczneSypkie";
        this.rodzajZanieczyszczenia = rodzajZanieczyszczenia;
    }

    public String getRodzajZanieczyszczenia() {
        return rodzajZanieczyszczenia;
    }

    @Override
    public String toString() {
        return super.toString() + ", Rodzaj zanieczyszczenia: " + getRodzajZanieczyszczenia();
    }
}
