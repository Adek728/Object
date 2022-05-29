package Magazyny;

import Kontenery.Kontener;
import Statki.Statek;

import java.util.ArrayList;
import java.util.List;

public class Wagon extends Thread{
    int iloscMaxymalna;
    int iloscNaWagonie = 0;
    List<Kontener> kontenery = new ArrayList<>();
    boolean czyMoznaZaladowac = true;
    public Wagon(){
        this.iloscMaxymalna = 10;
    }
    public void maxymalnaIlosc(){
        for(int i = 0; i < 10; i++)
            kontenery.remove(0);
        this.iloscNaWagonie = 0;
    }




    public void dodajKontener(Statek statek, int id){
        List<Kontener> list = statek.getListaKontenerow();
        for(Kontener kon : list){
            if(kon.getId() == id){
                kontenery.add(kon);
                iloscNaWagonie++;
            }
        }
    }
    public int getIloscNaWagonie() {
        return iloscNaWagonie;
    }
    public void setCzyMoznaZaladowac(boolean czyMoznaZaladowac) {
        this.czyMoznaZaladowac = czyMoznaZaladowac;
    }

    public boolean getCzyMoznaZaladowac() {
        return czyMoznaZaladowac;
    }



}
