import Czas.Czas;
import Czas.CzasWagon;
import Kontenery.*;
import Magazyny.Magazyn;
import Magazyny.Wagon;
import Nadawca.Nadawca;
import Port.Port;
import Statki.Statek;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main extends Thread{
    public static void main(String[] args){
        List<Magazyn> magazyn = new ArrayList<>();
        List<Nadawca> nadawca = new ArrayList<>();
        List<Wagon> wagony = new ArrayList<>();
        Port port = new Port("Alibun","Francja");
        Czas czas = new Czas(magazyn);
        CzasWagon czasWagon = new CzasWagon(wagony);
        czas.start();
        czasWagon.start();
        Statek statek1 = new Statek("Napoleon", "Gdansk", "Stany", "Rosja", 15, 1000, 2, 3, 2);
        Statek statek2 = new Statek("Budda", "Gdansk", "Stany", "Rosja", 3, 150, 1, 1, 2);
        Statek statek3 = new Statek("Syrenka", "Gdansk", "Stany", "Rosja", 15, 350, 6, 5, 5);
        Statek statek4 = new Statek("Cyrlica", "Gdansk", "Stany", "Rosja", 23, 486, 16, 9, 5);
        Statek statek5 = new Statek("Alibaba", "Gdansk", "Stany", "Rosja", 31, 4566, 23, 32, 32);
        port.przyjmijStatek(statek1);
        port.przyjmijStatek(statek2);
        port.przyjmijStatek(statek3);
        port.przyjmijStatek(statek4);
        port.przyjmijStatek(statek5);
        Nadawca n1 = new Nadawca("Adrian", "Mikolajczak", "01041002473", "Polska");
        Nadawca n2 = new Nadawca("Michal", "Kowalski", "05112602473", "Niemcy");
        Nadawca n3 = new Nadawca("Konrad", "Klich", "06020602473", "Stany");
        nadawca.add(n1);
        nadawca.add(n2);
        nadawca.add(n3);

        Kontener kontener1 = new KonPodstawowy(n1,56,true,55,45, 4);
        Kontener kontener2 = new KonPodstawowy(n2,56,true,55,45, 4);
        Kontener kontener3 = new KonPodstawowy(n3,56,true,55,45, 4);
        Kontener kontener4 = new KonPodstawowy(n3,56,true,55,45, 4);
        Kontener kontener5 = new KonPodstawowy(n2,56,true,55,45, 4);
        Kontener kontener6 = new KonPodstawowy(n3,56,true,55,45, 4);
        Kontener kontener7 = new KonPodstawowy(n1,56,true,55,45, 4);
        Kontener kontener8 = new KonPodstawowy(n2,56,true,55,45, 4);
        Kontener kontener9 = new KonPodstawowy(n1,56,true,55,45, 4);
        Kontener kontener10 = new KonPodstawowy(n2,56,true,55,45, 4);

        Kontener kontener11 = new KonCiezki(n1,55,true,33,33,4,"Carbon");
        Kontener kontener12 = new KonCiezki(n2,55,true,33,33,4,"Carbon");
        Kontener kontener13 = new KonCiezki(n3,55,true,33,33,4,"Carbon");
        Kontener kontener14 = new KonCiezki(n3,55,true,33,33,4,"Carbon");
        Kontener kontener15 = new KonCiezki(n1,55,true,33,33,4,"Carbon");

        Kontener kontener16 = new KonChlodniczy(n1,55,true,33,33,4,"Carbon", 5);
        Kontener kontener17 = new KonChlodniczy(n2,55,true,33,33,4,"Carbon", 5);
        Kontener kontener18 = new KonChlodniczy(n2,55,true,33,33,4,"Carbon", 5);
        Kontener kontener19 = new KonChlodniczy(n1,55,true,33,33,4,"Carbon", 5);
        Kontener kontener20 = new KonChlodniczy(n3,15,true,33,33,4,"Carbon", 5);

        Kontener kontener21 = new KonCiekle(n1,55,true,33,33,4,"Miod");
        Kontener kontener22 = new KonCiekle(n3,55,true,33,33,4,"Miod");
        Kontener kontener23 = new KonCiekle(n3,55,true,33,33,4,"Miod");
        Kontener kontener24 = new KonCiekle(n2,55,true,33,33,4,"Miod");
        Kontener kontener25 = new KonCiekle(n2,55,true,33,33,4,"Miod");

        Kontener kontener26 = new KonWybuchowe(n1,55,true,33,33,4,"Carbon", "Wysokie");
        Kontener kontener27 = new KonWybuchowe(n2,55,true,33,33,4,"Carbon", "Wysokie");
        Kontener kontener28 = new KonWybuchowe(n1,55,true,33,33,4,"Carbon", "Wysokie");
        Kontener kontener29 = new KonWybuchowe(n1,55,true,33,33,4,"Carbon", "Wysokie");
        Kontener kontener30 = new KonWybuchowe(n3,55,true,33,33,4,"Carbon", "Wysokie");

        Kontener kontener31 = new KonToksycznySypki(n1,55,true,33,33,4,"Carbon", "Kwas");
        Kontener kontener32 = new KonToksycznySypki(n3,55,true,33,33,4,"Carbon", "Kwas");
        Kontener kontener33 = new KonToksycznySypki(n1,55,true,33,33,4,"Carbon", "Kwas");
        Kontener kontener34 = new KonToksycznySypki(n3,55,true,33,33,4,"Carbon", "Kwas");
        Kontener kontener35 = new KonToksycznySypki(n1,55,true,33,33,4,"Carbon", "Kwas");

        Kontener kontener36 = new KonToksycznyCiekly(n1,55,true,33,33,4,"Carbon", "Smolisty", "Kwas");
        Kontener kontener37 = new KonToksycznyCiekly(n1,55,true,33,33,4,"Carbon", "Smolisty", "Kwas");
        Kontener kontener38 = new KonToksycznyCiekly(n3,55,true,33,33,4,"Carbon", "Smolisty", "Kwas");
        Kontener kontener39 = new KonToksycznyCiekly(n2,55,true,33,33,4,"Carbon", "Smolisty", "Kwas");
        Kontener kontener40 = new KonToksycznyCiekly(n2,55,true,33,33,4,"Carbon", "Smolisty", "Kwas");

        Kontener kontener41 = new KonCiekle(n2,55,true,33,33,4,"Miod");
        Kontener kontener42 = new KonCiekle(n2,55,true,33,33,4,"Miod");
        Kontener kontener43 = new KonChlodniczy(n1,55,true,33,33,4,"Carbon", 5);
        Kontener kontener44 = new KonChlodniczy(n3,55,true,33,33,4,"Carbon", 5);
        Kontener kontener45 = new KonCiezki(n3,55,true,33,33,4,"Carbon");
        Kontener kontener46 = new KonCiezki(n1,55,true,33,33,4,"Carbon");
        Kontener kontener47 = new KonPodstawowy(n1,56,true,55,45, 4);
        Kontener kontener48 = new KonPodstawowy(n2,56,true,55,45, 4);



        Magazyn m1 = new Magazyn(10000, czas);
        magazyn.add(m1);
        Wagon wagon = new Wagon();
        wagony.add(wagon);

        m1.dodajKontener(kontener1);
        m1.dodajKontener(kontener2);
        m1.dodajKontener(kontener3);
        m1.dodajKontener(kontener4);
        m1.dodajKontener(kontener5);
        m1.dodajKontener(kontener6);
        m1.dodajKontener(kontener7);
        m1.dodajKontener(kontener8);
        m1.dodajKontener(kontener9);
        m1.dodajKontener(kontener10);
        m1.dodajKontener(kontener11);
        m1.dodajKontener(kontener12);
        m1.dodajKontener(kontener13);
        m1.dodajKontener(kontener14);
        m1.dodajKontener(kontener15);
        m1.dodajKontener(kontener16);
        m1.dodajKontener(kontener17);
        m1.dodajKontener(kontener18);
        m1.dodajKontener(kontener19);
        m1.dodajKontener(kontener20);
        m1.dodajKontener(kontener21);
        m1.dodajKontener(kontener22);
        m1.dodajKontener(kontener23);
        m1.dodajKontener(kontener24);
        m1.dodajKontener(kontener25);
        m1.dodajKontener(kontener26);
        m1.dodajKontener(kontener27);
        m1.dodajKontener(kontener28);
        m1.dodajKontener(kontener29);
        m1.dodajKontener(kontener30);
        m1.dodajKontener(kontener31);
        m1.dodajKontener(kontener32);
        m1.dodajKontener(kontener33);
        m1.dodajKontener(kontener34);
        m1.dodajKontener(kontener35);
        m1.dodajKontener(kontener36);
        m1.dodajKontener(kontener37);
        m1.dodajKontener(kontener38);
        m1.dodajKontener(kontener39);
        m1.dodajKontener(kontener40);
        m1.dodajKontener(kontener41);
        m1.dodajKontener(kontener42);
        m1.dodajKontener(kontener43);
        m1.dodajKontener(kontener44);
        m1.dodajKontener(kontener45);
        m1.dodajKontener(kontener46);
        m1.dodajKontener(kontener47);
        m1.dodajKontener(kontener48);

        statek1.zaladuj(1,m1);
        statek1.zaladuj(2,m1);
        statek1.zaladuj(3,m1);
        statek2.zaladuj(4,m1);
        statek3.zaladuj(5,m1);
        statek4.zaladuj(6,m1);
        statek5.zaladuj(7,m1);
        statek3.zaladuj(8,m1);
        statek1.zaladuj(9,m1);
        statek3.zaladuj(10,m1);
        statek3.zaladuj(11,m1);
        statek5.zaladuj(12,m1);
        statek1.zaladuj(13,m1);
        statek1.zaladuj(14,m1);
        statek4.zaladuj(15,m1);
        statek4.zaladuj(16,m1);
        statek5.zaladuj(17,m1);
        statek5.zaladuj(18,m1);
        statek3.zaladuj(19,m1);
        statek2.zaladuj(20,m1);
        statek3.zaladuj(21,m1);
        statek1.zaladuj(22,m1);
        statek4.zaladuj(23,m1);
        statek1.zaladuj(24,m1);
        statek2.zaladuj(25,m1);
        statek1.zaladuj(26,m1);
        statek5.zaladuj(27,m1);
        statek5.zaladuj(28,m1);
        statek5.zaladuj(29,m1);
        statek4.zaladuj(30,m1);
        statek5.zaladuj(31,m1);
        statek4.zaladuj(32,m1);
        statek5.zaladuj(33,m1);
        statek5.zaladuj(34,m1);
        statek4.zaladuj(35,m1);
        statek5.zaladuj(36,m1);
        statek4.zaladuj(37,m1);
        statek4.zaladuj(38,m1);
        statek5.zaladuj(39,m1);
        statek5.zaladuj(40,m1);

        for(int i = 0; i < 22; i++)
            System.out.println();
        menu();
        boolean exit = false;
        while(!exit){
            System.out.println("        Jezeli chcesz zobaczyc menu jeszcze raz wpisz 11");
        System.out.println("        Podaj co chcesz zrobic:");
        Scanner scanner = new Scanner(System.in);
        int end = scanner.nextInt();
        scanner.nextLine();
        switch (end){
            case 0:{
                exit = true;
                System.exit(0);
            }break;

            case 1:{
                System.out.println("Wybierz id statku z ponizszych: ");
                for(Statek s : port.getStatki())
                    System.out.print(s.getId() + " ");
                System.out.println();
                int st = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Wybierz 1 by wybrac magazyn");
                System.out.println("Wybierz 2 by wybrac wagon");
                int wybor = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Wybierz kontener ze statku:");
                for(Statek s : port.getStatki()){
                    if(s.getId() == st){
                        s.info();
                    }
                }
                int kontener = scanner.nextInt();
                scanner.nextLine();
                for(Statek s : port.getStatki()){
                    if(s.getId() == st){
                        if(wybor == 1){
                            s.wyladuj(m1,kontener);
                        }else{
                            s.wyladuj(wagon,kontener);
                        }
                    }
                }
                czekajChwile();
            }break;

            case 2:{
                System.out.println("Wybierz na jaki statek chcesz zaladowac kontener");
                for(Statek s : port.getStatki()){
                    System.out.print(s.getId() + " ");
                }
                System.out.println();
                int st = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Wybierz ktory kontener");
                m1.info();
                int kon = scanner.nextInt();
                scanner.nextLine();
                for(Statek s : port.getStatki()){
                    if(s.getId() == st){
                        s.zaladuj(kon,m1);
                    }
                }
                czekajChwile();
            }break;

            case 3:{
                for(Statek s : port.getStatki()){
                    s.info();
                }
                czekajChwile();
            }break;

            case 4:{
                for(Magazyn m : magazyn)
                    m.info();
                czekajChwile();
            }break;

            case 5:{
                System.out.println("Wybierz ktory kontener chcesz utylizowac");
                m1.info();
                int kon = scanner.nextInt();
                scanner.nextLine();
                m1.utylizacja(kon);
            }break;

            case 6:{
                System.out.println("Aby stworzyc statek musisz podac nastepujace informacje");
                System.out.println("Nazwa:");
                String nazwa = scanner.nextLine();
                System.out.println("Port macierzysty:");
                String portMa = scanner.nextLine();
                System.out.println("Lokalizacja Zrodlowa:");
                String lokZr = scanner.nextLine();
                System.out.println("Lokalizacja Docelowa:");
                String lokDo = scanner.nextLine();
                System.out.println("Maxymalna ilosc Kontenerow:");
                int maxKon = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Maxylamna ladownosc:");
                int ladownosc = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Maxymalna ilosc kontenerow wybuchowych i toksycznych:");
                int maxKonWy = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Maxymalna ilosc kontenerow ciezkich:");
                int maxCie = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Maxymalna ilosc kontenerow z dostepem do sieci:");
                int maxSiec = scanner.nextInt();
                scanner.nextLine();
                Statek tmp = new Statek(nazwa,portMa,lokZr,lokDo, maxKon, ladownosc, maxKonWy, maxCie, maxSiec);
                port.przyjmijStatek(tmp);
                System.out.println("Nowy statek posiada ID: " + tmp.getId());
            }break;

            case 7:{
                System.out.println("Wybierz jaki rodzaj kontenera chcesz stworzyc");
                System.out.println("0: Podstawowy");
                System.out.println("1: Ciezki");
                System.out.println("2: Chlodniczy");
                System.out.println("3: Z materialami Cieklymi");
                System.out.println("4: Z materialami Wybuchowymi");
                System.out.println("5: Z materialami toksycznymi sypkimi");
                System.out.println("6: Z materialami toksycznymi cieklymi");
                int numer = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Podaj podstawowe informacje");
                System.out.println("Id Nadawcy");
                for(Nadawca n : nadawca)
                    System.out.print(n.getId() + " ");
                int nad = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Tara");
                int tara = scanner.nextInt();
                scanner.nextLine();
                System.out.println("zabezpieczenia");
                boolean zab = scanner.nextBoolean();
                System.out.println("wagaNetto");
                int wagaNe = scanner.nextInt();
                scanner.nextLine();
                System.out.println("wagaBrutto");
                int wagaBr = scanner.nextInt();
                scanner.nextLine();
                switch (numer) {
                    case 0 -> {
                        System.out.println("Ilosc palet");
                        int palety = scanner.nextInt();
                        scanner.nextLine();
                        for (Nadawca n : nadawca) {
                            if (n.getId() == nad) {
                                Kontener tmp = new KonPodstawowy(n, tara, zab, wagaNe, wagaBr, palety);
                                m1.dodajKontener(tmp);
                                System.out.println("Stworzyles kontener o id: " + tmp.getId());
                            }
                        }
                    }
                    case 1 -> {
                        System.out.println("Ilosc Palet");
                        int palety = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Rodzaj Wykonczenia");
                        String rodzaj = scanner.nextLine();
                        for (Nadawca n : nadawca) {
                            if (n.getId() == nad) {
                                Kontener tmp = new KonCiezki(n, tara, zab, wagaNe, wagaBr, palety, rodzaj);
                                m1.dodajKontener(tmp);
                                System.out.println("Stworzyles kontener o id: " + tmp.getId());
                            }
                        }
                    }
                    case 2 -> {
                        System.out.println("Ilosc Palet");
                        int palety = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Rodzaj Wykonczenia");
                        String rodzaj = scanner.nextLine();
                        System.out.println("Ilosc Wyjsc Do Sieci");
                        int ilosc = scanner.nextInt();
                        scanner.nextLine();
                        for (Nadawca n : nadawca) {
                            if (n.getId() == nad) {
                                Kontener tmp = new KonChlodniczy(n, tara, zab, wagaNe, wagaBr, palety, rodzaj, ilosc);
                                m1.dodajKontener(tmp);
                                System.out.println("Stworzyles kontener o id: " + tmp.getId());
                            }
                        }
                    }
                    case 3 -> {
                        System.out.println("Ilosc palet");
                        int palety = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("rodzaj Cieczy");
                        String Ciecz = scanner.nextLine();
                        for (Nadawca n : nadawca) {
                            if (n.getId() == nad) {
                                Kontener tmp = new KonCiekle(n, tara, zab, wagaNe, wagaBr, palety, Ciecz);
                                m1.dodajKontener(tmp);
                                System.out.println("Stworzyles kontener o id: " + tmp.getId());
                            }
                        }
                    }
                    case 4 -> {
                        System.out.println("Ilosc Palet");
                        int palety = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Rodzaj Wykonczenia");
                        String rodzaj = scanner.nextLine();
                        System.out.println("rodzaj Niebezpieczenstwa");
                        String rodzajNie = scanner.nextLine();
                        for (Nadawca n : nadawca) {
                            if (n.getId() == nad) {
                                Kontener tmp = new KonWybuchowe(n, tara, zab, wagaNe, wagaBr, palety, rodzaj, rodzajNie);
                                m1.dodajKontener(tmp);
                                System.out.println("Stworzyles kontener o id: " + tmp.getId());
                            }
                        }
                    }
                    case 5 -> {
                        System.out.println("Ilosc Palet");
                        int palety = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Rodzaj Wykonczenia");
                        String rodzaj = scanner.nextLine();
                        System.out.println("rodzaj Zanieczyszczenia");
                        String rodzajZa = scanner.nextLine();
                        for (Nadawca n : nadawca) {
                            if (n.getId() == nad) {
                                Kontener tmp = new KonToksycznySypki(n, tara, zab, wagaNe, wagaBr, palety, rodzaj, rodzajZa);
                                m1.dodajKontener(tmp);
                                System.out.println("Stworzyles kontener o id: " + tmp.getId());
                            }
                        }
                    }
                    case 6 -> {
                        System.out.println("Ilosc Palet");
                        int palety = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Rodzaj Wykonczenia");
                        String rodzaj = scanner.nextLine();
                        System.out.println("Rodzaj Cieczy");
                        String rodzajCieczy = scanner.nextLine();
                        System.out.println("rodzaj Niebezpieczenstwa");
                        String rodzajNie = scanner.nextLine();

                        for (Nadawca n : nadawca) {
                            if (n.getId() == nad) {
                                Kontener tmp = new KonToksycznyCiekly(n, tara, zab, wagaNe, wagaBr, palety, rodzaj, rodzajCieczy, rodzajNie);
                                m1.dodajKontener(tmp);
                                System.out.println("Stworzyles kontener o id: " + tmp.getId());
                            }
                        }
                    }
                }
                czekajChwile();
            }break;

            case 8:{
                try {
                    zapis(port, m1, nadawca);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }break;
            case 9:{
                System.out.println("Wybierz id statku");
                for(Statek st : port.getStatki()){
                    System.out.print(st.getId() + " ");
                }
                System.out.println();
                int id = scanner.nextInt();
                scanner.nextLine();
                port.wypuscStatek(id);
                czekajChwile();
            }
            case 10:{
                System.out.println("Wybierz id statku");
                for(Statek st : port.getStatki())
                    System.out.print(st.getId() + " ");
                System.out.println();
                int id = scanner.nextInt();
                scanner.nextLine();
                for(Statek st : port.getStatki())
                    if(st.getId() == id)
                        st.ileMoznaZaladowac();
            }break;
            case 11:{
                menu();
            }break;

        }
        }

    }
    public static void czekajChwile(){
        try{
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void zapis(Port port, Magazyn magazyn, List<Nadawca> nadawcas) throws IOException {
        List<Kontener> konMagazyn;
        List<Kontener> konStatek;
        List<Statek> statki;
        StringBuilder tmp = new StringBuilder();
        tmp.append("Nadawcy: \n");
        for(Nadawca nada : nadawcas){
            Wyswietlanie<Nadawca> wys = new Wyswietlanie<>(nada);
            tmp.append(wys.info()).append("\n");
        }
        tmp.append("\n");
        tmp.append("Statki i ich kontenery: \n");
        statki = port.Sortowanie();
        for(Statek statek : statki) {
            Wyswietlanie<Statek> st = new Wyswietlanie<>(statek);
            tmp.append(st.info()).append("\n");
            konStatek=statek.Sortowanie();
            for(Kontener kon : konStatek){
                Wyswietlanie<Kontener> wys = new Wyswietlanie<>(kon);
                tmp.append("-").append(wys.info()).append("\n");
            }
            tmp.append("\n");
        }
        konMagazyn = magazyn.Sortowanie();
        tmp.append("Magazyny i ich kontenery:\n");
        tmp.append("Magazyn o id: ").append(magazyn.getId()).append("\n");
        for(Kontener kon : konMagazyn){
            Wyswietlanie<Kontener> wys = new Wyswietlanie<>(kon);
            if(kon.getRodzaj().equals("Wybuchowe") || kon.getRodzaj().equals("ToksyczneCiekle") || kon.getRodzaj().equals("ToksyczneSypkie"))
                tmp.append(wys.info()).append(", czas do utylizacji ").append((kon.getCzasMaxymalny()-kon.getCzasNaNaMagazynie())).append("\n");
            else
                tmp.append(wys.info()).append("\n");
        }

        FileWriter fileWriter = new FileWriter("daneAplikacji.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(tmp.toString());
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    public static void menu(){
        System.out.println("        Program posiada takie rzeczy jak:");
        System.out.println("        0: Zamkniecie programu");
        System.out.println("        1: Zaladowanie kontenera ze statku do magazynu lub na wagonu");
        System.out.println("        2: Zaladowanie kontenera na statek");
        System.out.println("        3: Informacje na temat statku i jego kontenerow");
        System.out.println("        4: Informacje na temat magazynu i jego kontenerow");
        System.out.println("        5: Utylizacja wskazanego kontenera z magazynu");
        System.out.println("        6: Stworzenie nowego statku");
        System.out.println("        7: Stworzenie nowego kontenera");
        System.out.println("        8: Zapisanie aktualnego stanu portu");
        System.out.println("        9: Wypusc statek z portu");
        System.out.println("        10: Jaka ilosc kontenerow mozna wsadzic na statek");

    }
}
