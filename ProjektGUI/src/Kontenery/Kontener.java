package Kontenery;

import Nadawca.Nadawca;

public abstract class Kontener {
    Nadawca nadawca;
    int tara;
    boolean zabezpieczenia;
    int wagaNetto;
    int wagaBrutto;
    String rodzaj;
    int czasWejsciaNaMagazyn;
    int czasNaNaMagazynie;
    int czasMaxymalny;
    static int numer = 0;
    int id;

    public Kontener(Nadawca nadawca, int tara, boolean zabezpieczenia, int wagaNetto, int wagaBrutto) {
        this.nadawca = nadawca;
        this.tara = tara;
        this.zabezpieczenia = zabezpieczenia;
        this.wagaNetto = wagaNetto;
        this.wagaBrutto = wagaBrutto;
        this.rodzaj = "";
        numer = numer + 1;
        this.id = numer;
    }

    public int getTara() {
        return tara;
    }

    public String getRodzaj(){
        return rodzaj;
    }

    public int getId() {
        return id;
    }


    public int getCzasNaNaMagazynie() {
        return czasNaNaMagazynie;
    }

    public void setCzasNaNaMagazynie(int czasNaNaMagazynie) {
        this.czasNaNaMagazynie = czasNaNaMagazynie;
    }

    public int getCzasMaxymalny() {
        return czasMaxymalny;
    }

    public void setCzasMaxymalny(int czasMaxymalny) {
        this.czasMaxymalny = czasMaxymalny;
    }

    public int getCzasWejsciaNaMagazyn() {
        return czasWejsciaNaMagazyn;
    }

    public void setCzasWejsciaNaMagazyn(int czasWejsciaNaMagazyn) {
        this.czasWejsciaNaMagazyn = czasWejsciaNaMagazyn;
    }

    public Nadawca getNadawca() {
        return nadawca;
    }

    @Override
    public String toString() {
        return "Kontener "+ getRodzaj()+ ", o ID: "+ getId() + ", Id Nadawcy: " + getNadawca().getId() + ", Ciezar: " + getTara() + " kg,";
    }
}