package Nadawca;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Nadawca {
    String name;
    String nazwisko;
    String pesel;
    String adres;
    LocalDate date;
    static int numer = 0;
    int id;
    int iloscOstrzezen;
    public Nadawca(String name, String nazwisko, String pesel, String adres) {
        this.name = name;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
        this.adres = adres;
        nadajDate(pesel);
        numer = numer + 1;
        this.id = numer;

    }

    public void nadajDate(String pesel){
        String data = pesel.substring(0,6);
        this.date = LocalDate.parse(data, DateTimeFormatter.ofPattern("yyMMdd"));
    }

    public LocalDate getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
    public void setIloscOstrzezen(){
        this.iloscOstrzezen = iloscOstrzezen + 1;
    }

    public int getIloscOstrzezen() {
        return iloscOstrzezen;
    }

    public String toString(){
        return "Id Nadawcy: " + getId() + ", imie: " + getName() + ", data ur: " + getDate() + ", ilosc ostrzezen: " + getIloscOstrzezen();
    }
}
