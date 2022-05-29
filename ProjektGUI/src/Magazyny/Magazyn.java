package Magazyny;

import Czas.Czas;
import Kontenery.Kontener;
import Nadawca.Nadawca;
import Statki.Statek;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Magazyn {
    int iloscMaxymalna;
    int iloscNaMagazynie;
    Czas czas;
    List<Kontener> kontenery = new ArrayList<Kontener>();
    static int numer = 0;
    int id;
    public Magazyn(int iloscMaxymalna, Czas czas) {
        this.iloscMaxymalna = iloscMaxymalna;
        this.czas = czas;
        numer = numer + 1;
        this.id = numer;
    }



    public void dodajKontener(Kontener kontener){
        if(iloscNaMagazynie < iloscMaxymalna){
            kontenery.add(kontener);
            iloscNaMagazynie++;
            String rodzaj = kontener.getRodzaj();
            if(rodzaj.equals("Wybuchowe")){
                kontener.setCzasWejsciaNaMagazyn(czas.getCzas());
                kontener.setCzasNaNaMagazynie(czas.getCzas());
                kontener.setCzasMaxymalny(czas.getCzas() + 5);
            }
            if(rodzaj.equals("ToksyczneCiekle")){
                kontener.setCzasWejsciaNaMagazyn(czas.getCzas());
                kontener.setCzasNaNaMagazynie(czas.getCzas());
                kontener.setCzasMaxymalny(czas.getCzas() + 10);
            }
            if(rodzaj.equals("ToksyczneSypkie")){
                kontener.setCzasWejsciaNaMagazyn(czas.getCzas());
                kontener.setCzasNaNaMagazynie(czas.getCzas());
                kontener.setCzasMaxymalny(czas.getCzas() + 14);
            }
            kontener.setCzasWejsciaNaMagazyn(czas.getCzas());
        }else {
            System.out.println("Brak miejsca w magazynie");
        }
    }
    public void dodajKontener(Statek statek, int id){
        if(iloscNaMagazynie < iloscMaxymalna){
            List<Kontener> list = statek.getListaKontenerow();
            for(int i = 0; i < list.size();i++){
                if(list.get(i).getId() == id){
                    kontenery.add(list.get(i));
                    String rodzaj = list.get(i).getRodzaj();
                    if(rodzaj.equals("Wybuchowe")){
                        list.get(i).setCzasWejsciaNaMagazyn(czas.getCzas());
                        list.get(i).setCzasNaNaMagazynie(czas.getCzas());
                        list.get(i).setCzasMaxymalny(czas.getCzas() + 5);
                    }
                    if(rodzaj.equals("ToksyczneCiekle")){
                        list.get(i).setCzasWejsciaNaMagazyn(czas.getCzas());
                        list.get(i).setCzasNaNaMagazynie(czas.getCzas());
                        list.get(i).setCzasMaxymalny(czas.getCzas() + 10);
                    }
                    if(rodzaj.equals("ToksyczneSypkie")){
                        list.get(i).setCzasWejsciaNaMagazyn(czas.getCzas());
                        list.get(i).setCzasNaNaMagazynie(czas.getCzas());
                        list.get(i).setCzasMaxymalny(czas.getCzas() + 14);
                    }
                    list.get(i).setCzasWejsciaNaMagazyn(czas.getCzas());

                }
            }
        }
        iloscNaMagazynie++;
    }

    public void odejmijKontener(Kontener kontener){
        kontenery.remove(kontener);
    }

    public void utylizacja(int id){
        kontenery.removeIf(kon -> kon.getId() == id);
        System.out.println("Kontener o ID " + id + " zostal utylizowany");
    }



    public void info(){
        System.out.println("Na magazynie o ID: " + getId());
        for(Kontener kon : kontenery){
            if(kon.getRodzaj().equals("Wybuchowe") || kon.getRodzaj().equals("ToksyczneCiekle") || kon.getRodzaj().equals("ToksyczneSypkie")){
                System.out.println("Kontener o ID:" + kon.getId() + " " + kon.getRodzaj() + " i ladownosci: " + kon.getTara() + " oraz czasie do utylizacji: " +
                        (kon.getCzasMaxymalny()-kon.getCzasNaNaMagazynie()) + " dni");
            }else{
                System.out.println("Kontener o ID:" + kon.getId() + " " + kon.getRodzaj() + " i ladownosci: " + kon.getTara());
            }
        }
    }
    public void koniecCzasu(Kontener kon){
        kontenery.remove(kon);
        kon.getNadawca().setIloscOstrzezen();
    }

    public int getId() {
        return id;
    }
    public List<Kontener> Sortowanie(){
        for(int i = 1; i < kontenery.size(); i++){
            if(kontenery.get(i-1).getCzasWejsciaNaMagazyn() > kontenery.get(i).getCzasWejsciaNaMagazyn()){
                Collections.swap(kontenery, i-1, i);
                i = 1;
            }
            else if(kontenery.get(i-1).getCzasWejsciaNaMagazyn() == kontenery.get(i).getCzasWejsciaNaMagazyn()){
                if(compare(kontenery.get(i).getNadawca(), kontenery.get(i-1).getNadawca()) > 0){
                    Collections.swap(kontenery, i-1, i);
                     i = 1;
                }
            }
        }
        return kontenery;
    }

    public int compare(Nadawca o1, Nadawca o2) {
        return o1.getName().compareTo(o2.getName());
    }

    public int getIloscMaxymalna() {
        return iloscMaxymalna;
    }

    public int getIloscNaMagazynie() {
        return iloscNaMagazynie;
    }

    public void setIloscNaMagazynie(int iloscNaMagazynie) {
        this.iloscNaMagazynie = iloscNaMagazynie;
    }
    public List<Kontener> getKontenery() {
        return kontenery;
    }
}
