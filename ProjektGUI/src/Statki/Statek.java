package Statki;

import Kontenery.Kontener;
import Magazyny.Wagon;
import Magazyny.Magazyn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Statek {

    int maxLadownosc;
    int maxKontenerow;
    int maxKontenerowToksycznychWybuchowych;
    int maxKontenerowCiezkich;
    int maxKontenerowSiec;

    int ladownosc = 0;
    int iloscKontenerow = 0;
    int iloscKontenerowToksycznychWybuchowych = 0;
    int iloscKontenerowCiezkich = 0;
    int iloscKontenerowSiec = 0;

    String nazwa;
    String portMacierzysty;
    String lokZrodlowa;
    String lokDocelowa;
    static int numer = 0;
    int id;
    List<Kontener> listaKontenerow = new ArrayList<Kontener>();

    public Statek(String nazwa, String portMacierzysty, String lokZrodlowa, String lokDocelowa,
                  int maxKontenerow, int maxLadownosc, int maxKontenerowToksycznychWybuchowych, int maxKontenerowCiezkich, int maxKontenerowSiec){
        this.nazwa = nazwa;
        this.portMacierzysty = portMacierzysty;
        this.lokZrodlowa = lokZrodlowa;
        this.lokDocelowa = lokDocelowa;
        this.maxKontenerow = maxKontenerow;
        this.maxLadownosc = maxLadownosc;
        this.maxKontenerowToksycznychWybuchowych = maxKontenerowToksycznychWybuchowych;
        this.maxKontenerowCiezkich = maxKontenerowCiezkich;
        this.maxKontenerowSiec = maxKontenerowSiec;
        numer = numer + 1;
        this.id = numer;
    }



    public void zaladuj(int id, Magazyn magazyn){
        if(ladownosc + taraKontenera(id) <= maxLadownosc){
            String rodzaj = rodzajKonteneraZMagazynu(magazyn, id);
            boolean czyMoznaZaladowac = czyMozna(rodzaj);
            if(czyMoznaZaladowac){
                System.out.println("Zaladowano kontener " + rodzaj + " na statek" );
                dodawanieIlosci(rodzaj);
                dodanieNaStatek(magazyn, id);
                ladownosc = ladownosc + taraKontenera(id);
            }else{
                System.out.println("Ilosc kontenerow tego rodzaju jest maxymalna");
            }
        }else{
            System.out.println("Ladownosc statku nie jest wystarczajaca");
        }
    }

    public void wyladuj(Magazyn magazyn, int id){
        if(czyJestNaStatku(id)){
            String rodzaj = rodzajKontenera(id);
            if(czyMoznaWyladowac(magazyn)){
                for(int i = 0; i < listaKontenerow.size();i++)
                    if(listaKontenerow.get(i).getId() == id){
                        if(listaKontenerow.get(i).getNadawca().getIloscOstrzezen() < 2){
                            magazyn.dodajKontener(this,id);
                            wyjecieZeStatku(id);
                            odejmowanieIlosci(rodzaj);
                            ladownosc = ladownosc - taraKontenera(id);
                            System.out.println("Kontener zostal przeniesiony do magazynu");
                        }else{
                            System.out.println("Nadawca ma zakaz magazynowania kontenerow");
                        }
                    }
            }else {
                System.out.println("Magazyn jest pelny");
            }
        }else {
            System.out.println("Konteneru nie ma na statku");
        }
    }
    public boolean czyMoznaWyladowac(Magazyn magazyn){
        boolean czy = false;
        if(magazyn.getIloscNaMagazynie() < magazyn.getIloscMaxymalna())
            czy = true;
        return czy;
    }

    public void wyladuj(Wagon wagon, int id){
        if(czyJestNaStatku(id)){
            String rodzaj = rodzajKontenera(id);
            if(wagon.getCzyMoznaZaladowac()){
                wagon.dodajKontener(this,id);
                wyjecieZeStatku(id);
                odejmowanieIlosci(rodzaj);
                ladownosc = ladownosc - taraKontenera(id);
            }else{
                System.out.println("Musisz poczekac na przyjazd nowego wagonu");
            }

        }else {
            System.out.println("Konteneru nie ma na statku");
        }
    }
    public void wyjecieZeStatku(int id){
        listaKontenerow.removeIf(kon -> kon.getId() == id);
    }

    public void dodanieNaStatek(Magazyn magazyn, int id){
        List<Kontener> list = magazyn.getKontenery();
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getId() == id){
                listaKontenerow.add(list.get(i));
                magazyn.odejmijKontener(list.get(i));
                magazyn.setIloscNaMagazynie(magazyn.getIloscNaMagazynie() - 1);
            }
        }
    }

    public int taraKontenera(int id){
        int tara = 0;
        for(Kontener kon : listaKontenerow){
            if(kon.getId() == id){
                tara = kon.getTara();
            }
        }
        return tara;
    }

    public boolean czyJestNaStatku(int id){
        boolean result = false;
        for(Kontener kon : listaKontenerow){
            if(kon.getId() == id) {
                result = true;
                break;
            }
        }
        return result;
    }

    public String rodzajKontenera(int id){
        String rodzaj = "";
        for(Kontener kon : listaKontenerow){
            if(kon.getId() == id){
                rodzaj = kon.getRodzaj();
            }
        }
        return rodzaj;
    }

    public String rodzajKonteneraZMagazynu(Magazyn magazyn, int id){
        String rodzaj = "";
        List<Kontener> list = magazyn.getKontenery();
        for(Kontener kon : list){
            if(kon.getId() == id){
                rodzaj = kon.getRodzaj();
            }
        }
        return rodzaj;
    }

    public void dodawanieIlosci(String rodzaj){
        if(rodzaj.equals("Podstawowy") || rodzaj.equals("Ciekle")){
            iloscKontenerow++;
        }
        if(rodzaj.equals("Ciezki")){
            iloscKontenerow++;
            iloscKontenerowCiezkich++;
        }
        if(rodzaj.equals("Chlodniczy")){
            iloscKontenerow++;
            iloscKontenerowSiec++;
        }
        if(rodzaj.equals("ToksyczneSypkie") || rodzaj.equals("Wybuchowe") || rodzaj.equals("ToksyczneCiekle")){
            iloscKontenerow++;
            iloscKontenerowToksycznychWybuchowych++;
        }

    }

    public void odejmowanieIlosci(String rodzaj){
        if(rodzaj.equals("Podstawowy") || rodzaj.equals("Ciekle")){
            iloscKontenerow--;
        }
        if(rodzaj.equals("Ciezki")){
            iloscKontenerow--;
            iloscKontenerowCiezkich--;
        }
        if(rodzaj.equals("Chlodniczy")){
            iloscKontenerow--;
            iloscKontenerowSiec--;
        }
        if(rodzaj.equals("ToksyczneSypkie") || rodzaj.equals("Wybuchowe") || rodzaj.equals("ToksyczneCiekle")){
            iloscKontenerow--;
            iloscKontenerowToksycznychWybuchowych--;
        }

    }

    public boolean czyMozna(String rodzaj){
        boolean resul = false;
        if(rodzaj.equals("Podstawowy") || rodzaj.equals("Ciekle")){
            if(iloscKontenerow < maxKontenerow)
                resul = true;
        }
        if(rodzaj.equals("Ciezki")){
            if(iloscKontenerow < maxKontenerow && iloscKontenerowCiezkich < maxKontenerowCiezkich)
                resul = true;
        }
        if(rodzaj.equals("Chlodniczy")){
            if(iloscKontenerow < maxKontenerow && iloscKontenerowSiec < maxKontenerowSiec)
                resul = true;
        }
        if(rodzaj.equals("ToksyczneSypkie")|| rodzaj.equals("Wybuchowe") || rodzaj.equals("ToksyczneCiekle")){
            if(iloscKontenerow < maxKontenerow && iloscKontenerowToksycznychWybuchowych < maxKontenerowToksycznychWybuchowych)
                resul = true;
        }

        return resul;
    }



    public void info(){
        System.out.println("------Na statku o ID: " + getId());
        for(Kontener kon : listaKontenerow){
            System.out.println("Kontener o ID:" + kon.getId() + " " + kon.getRodzaj() + " i ladownosci: " + kon.getTara());
        }
    }

    public void ileMoznaZaladowac(){
        System.out.println("Na statek mozna zaladowac: " +
                (maxKontenerow - iloscKontenerow)+ " Kontenerow w tym: " +
        (maxKontenerowCiezkich - iloscKontenerowCiezkich) + " Kontenerow ciezkich, " +
                (maxKontenerowToksycznychWybuchowych - iloscKontenerowToksycznychWybuchowych) + " Kontenerow toksycznych lub wybuchowych, "+
                (maxKontenerowSiec - iloscKontenerowSiec) + " Kontenerow z dostepem do sieci"  +
                ", o lacznej wadze "  +
                (maxLadownosc - ladownosc));
    }

    public List<Kontener> Sortowanie(){
        for (int i = 1; i < listaKontenerow.size(); i++) {
            if(listaKontenerow.get(i-1).getTara() > listaKontenerow.get(i).getTara()){
                Collections.swap(listaKontenerow,i-1,i);
            }
        }
        return listaKontenerow;
    }

    @Override
    public String toString() {
        return "Statek o nazwie: " + getNazwa() + " i ladownosci: " + getLadownosc();
    }
    public int getId() {
        return id;
    }

    public int getLadownosc() {
        return ladownosc;
    }

    public String getNazwa() {
        return nazwa;
    }

    public List<Kontener> getListaKontenerow() {
        return listaKontenerow;
    }
}
