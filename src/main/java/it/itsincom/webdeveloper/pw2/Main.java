package it.itsincom.webdeveloper.pw2;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Tecnico> tecnici = new ArrayList<>();
        ArrayList<Manager> managers = new ArrayList<>();
        ArrayList<Dirigente> dirigenti = new ArrayList<>();
        Azienda azienda = new Azienda("Azienda Dipendenz");

        // vedo tutti e riempio arraylist
        try {
            File file = new File("C:\\PW2---Java\\src\\main\\java\\it\\itsincom\\webdeveloper\\pw2\\elenco dipendenti.txt"); 
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] tokens = line.split(";");

                String ruolo = tokens[0];
                String codiceFiscale = tokens[1];
                String nome = tokens[2];
                String cognome = tokens[3];
                LocalDate dataAssunzione = LocalDate.parse(tokens[4]);
                String extraInfo = tokens[5];

                if (ruolo.equals("tecnico")) {
                    String codiceFiscaleDirigente = extraInfo;
                    String specialita = tokens[6];
                    Tecnico tecnico = new Tecnico(ruolo, codiceFiscale, nome, cognome, dataAssunzione,
                            codiceFiscaleDirigente, specialita);
                    if (!tecnici.contains(tecnico)) {
                        tecnici.add(tecnico);
                    }
                } else if (ruolo.equals("manager")) {
                    String settoreCompetenza = extraInfo;
                    Manager manager = new Manager(ruolo, codiceFiscale, nome, cognome, dataAssunzione,
                            settoreCompetenza);
                    if (!managers.contains(manager)) {
                        managers.add(manager);
                    }
                } else if (ruolo.equals("dirigente")) {
                    String divisione = extraInfo;
                    Dirigente dirigente = new Dirigente(ruolo, codiceFiscale, nome, cognome, divisione, dataAssunzione);
                    if (!dirigenti.contains(dirigente)) {
                        dirigenti.add(dirigente);
                    }
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("problema al primo try catch");
        }

        // tecnici a manager
        try {
            File file = new File("C:\\PW2---Java\\src\\main\\java\\it\\itsincom\\webdeveloper\\pw2\\elenco dipendenti.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] tokens = line.split(";");

                String ruolo = tokens[0];
                String codiceFiscale = tokens[1];
                String nome = tokens[2];
                String cognome = tokens[3];
                LocalDate dataAssunzione = LocalDate.parse(tokens[4]);
                String extraInfo = tokens[5];

                if (ruolo.equals("tecnico")) {
                    String codiceFiscaleDirigente = extraInfo;
                    String specialita = tokens[6];
                    Tecnico tecnico = new Tecnico(ruolo, codiceFiscale, nome, cognome, dataAssunzione,
                            codiceFiscaleDirigente, specialita);
                    for (Manager manager : managers) {
                        if (manager.getCodiceFiscale().equals(codiceFiscaleDirigente)) {
                            manager.addTecnico(tecnico);
                            break; // quando tecnico assegnato esci
                        }
                    }
                }
            }
            azienda.getDipendenti().addAll(tecnici);
            azienda.getDipendenti().addAll(managers);
            azienda.calcolaStipendio();
            for (Dirigente dirigente : dirigenti) {
                dirigente.setDipendenti(new ArrayList<>(azienda.getDipendenti()));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("problema al secondo try catch");
        }

        // sout tutti
        System.out.println("Elenco dei tecnici:");
        for (Tecnico tecnico : tecnici) {
            System.out.println(tecnico);
        }

        System.out.println("\nElenco dei manager:");
        for (Manager manager : managers) {
            System.out.println(manager);
        }

        System.out.println("\nElenco dei dirigenti:");
        for (Dirigente dirigente : dirigenti) {
            System.out.println(dirigente);
        }
    }
}
