package Czas;

import Kontenery.Kontener;
import Magazyny.Magazyn;

import java.util.List;

public class Czas extends Thread{

    public static int czas = 1;
    List<Magazyn> list;
    IrresponsibleSenderWithDangerousGoods problem;

    public Czas(List<Magazyn> list){
        this.list = list;
    }

    public void run(){
        while(true){
            try{
                sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            czas = czas + 1;

            for(Magazyn m : list){
                List<Kontener> kontenery = m.getKontenery();
                for(Kontener kon : kontenery){
                    if(kon.getRodzaj().equals("Wybuchowe") || kon.getRodzaj().equals("ToksyczneCiekle") || kon.getRodzaj().equals("ToksyczneSypkie")){
                        kon.setCzasNaNaMagazynie(getCzas());
                    }
                }
                for(int i = 0; i < kontenery.size(); i++){
                    if(kontenery.get(i).getRodzaj().equals("Wybuchowe") || kontenery.get(i).getRodzaj().equals("ToksyczneCiekle") || kontenery.get(i).getRodzaj().equals("ToksyczneSypkie")){
                        if(kontenery.get(i).getCzasNaNaMagazynie() == kontenery.get(i).getCzasMaxymalny()){
                            problem = new IrresponsibleSenderWithDangerousGoods(kontenery.get(i));
                            m.koniecCzasu(kontenery.get(i));
                            i--;
                        }
                    }
                }
            }
        }
    }

    public int getCzas(){
        return czas;
    }




}
