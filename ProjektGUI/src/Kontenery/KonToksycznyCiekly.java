package Kontenery;

import Nadawca.Nadawca;

public class KonToksycznyCiekly extends KonCiezki{
    String rodzajCieczy;
    String rodzajZanieczyszczenia;
    public KonToksycznyCiekly(Nadawca nadawca, int tara, boolean zabezpieczenia, int wagaNetto, int wagaBrutto, int iloscpalet, String rodzajWykonczenia, String rodzajCieczy, String rodzajZanieczyszczenia) {
        super(nadawca, tara, zabezpieczenia, wagaNetto, wagaBrutto, iloscpalet, rodzajWykonczenia);
        this.rodzaj = "ToksyczneCiekle";
        this.rodzajCieczy = rodzajCieczy;
        this.rodzajZanieczyszczenia = rodzajZanieczyszczenia;
    }

    public String getRodzajCieczy() {
        return rodzajCieczy;
    }

    public String getRodzajZanieczyszczenia() {
        return rodzajZanieczyszczenia;
    }

    @Override
    public String toString() {
        return super.toString() + ", Rodzaj cieczy: " + getRodzajCieczy() + ", Rodzaj zanieczyszczenia: " + getRodzajZanieczyszczenia();
    }
}
