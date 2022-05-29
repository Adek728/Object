package Czas;

import Kontenery.Kontener;

public class IrresponsibleSenderWithDangerousGoods extends Exception{

    public IrresponsibleSenderWithDangerousGoods(Kontener kontener){
        System.err.println("Kontener o ID: " + kontener.getId() + ", ktory przybyl do magazynu: " +
                kontener.getCzasWejsciaNaMagazyn() + " dnia, zostal zutilizowany dnia: " + kontener.getCzasMaxymalny());
    }


}
