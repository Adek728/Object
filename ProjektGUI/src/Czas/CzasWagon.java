package Czas;

import Magazyny.Wagon;

import java.util.List;

public class CzasWagon extends Thread{

    List<Wagon> wagon;
    public CzasWagon(List<Wagon> w){
        this.wagon = w;
    }

    public void run(){
        while(true){
            try{
                sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
            for(Wagon w : wagon){
                if(w.getIloscNaWagonie() == 10){
                    w.setCzyMoznaZaladowac(false);
                    System.err.println("maxymalna ilosc kontenerow na wagonie, musisz poczekac 30 sekund na nowy wagon");
                    w.maxymalnaIlosc();
                    try{
                        sleep(30000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    w.setCzyMoznaZaladowac(true);
                    System.err.println("[Nowy wagon przyjechal do portu]");
                }
            }
        }
    }
}
