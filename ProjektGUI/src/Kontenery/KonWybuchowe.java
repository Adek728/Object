package Kontenery;


import Nadawca.Nadawca;

public class KonWybuchowe extends KonCiezki {
    String rodzajNiebezpieczenstwa;

    public KonWybuchowe(Nadawca nadawca, int tara, boolean zabezpieczenia, int wagaNetto, int wagaBrutto, int iloscpalet, String rodzajWykonczenia, String rodzajNiebezpieczenstwa) {
        super(nadawca, tara, zabezpieczenia, wagaNetto, wagaBrutto, iloscpalet, rodzajWykonczenia);
        this.rodzaj = "Wybuchowe";
        this.rodzajNiebezpieczenstwa = rodzajNiebezpieczenstwa;

    }

    public String getRodzajNiebezpieczenstwa() {
        return rodzajNiebezpieczenstwa;
    }

    @Override
    public String toString() {
        return super.toString() + ", Rodzaj niebezpieczenstwa: " + getRodzajNiebezpieczenstwa();
    }
}
