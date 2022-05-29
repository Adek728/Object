package Port;

import Statki.Statek;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Port {
    String nazwa;
    String lokalizacja;
    List<Statek> statki = new ArrayList<>();
    public Port(String nazwa, String lokalizacja) {
        this.nazwa = nazwa;
        this.lokalizacja = lokalizacja;
    }
    public void przyjmijStatek(Statek statek){
        statki.add(statek);
    }
    public void wypuscStatek(int id){
        statki.removeIf(statek -> statek.getId() == id);
        System.out.println("Statek o id: " + id + " opuscil port");
    }

    public List<Statek> Sortowanie(){
        for (int i = 1; i < statki.size(); i++) {
            if(compare(statki.get(i-1), statki.get(i)) < 0) {
                Collections.swap(statki, i - 1, i);
                i = 1;
            }
        }
        return statki;
    }

    public int compare(Statek o1, Statek o2) {
        return o1.getNazwa().compareTo(o2.getNazwa());
    }

    public List<Statek> getStatki() {
        return statki;
    }
}
