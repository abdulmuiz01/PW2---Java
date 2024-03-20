package it.itsincom.webdeveloper.pw2;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Dipendente> dipendenti = new ArrayList<>();
        String filePath = "C:\\Users\\AbdulMuizKhan\\OneDrive - ITS Incom\\Desktop\\pwfinto\\elenco dipendenti.txt";
        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] tokens = line.split(";");
                String ruolo = tokens[0];
                String codiceFiscale = tokens[1];
                String nome = tokens[2];
                String cognome = tokens[3];
                LocalDate dataAssunzione = LocalDate.parse(tokens[4]);

                Dipendente dipendente = null;
                switch (ruolo) {
                    case "dirigente":
                        String divisione = tokens[5];
                        dipendente = new Dirigente(ruolo, codiceFiscale, nome, cognome, divisione, dataAssunzione);
                        break;
                    case "manager":
                        String codiceFiscDirigente = tokens[5];
                        String settoreCompetenza = tokens[6];
                        dipendente = new Manager(ruolo, codiceFiscale, nome, cognome, dataAssunzione,
                                codiceFiscDirigente, settoreCompetenza);
                        break;
                    case "tecnico":
                        String codiceFiscManager = tokens[5];
                        String specialita = tokens[6];
                        dipendente = new Tecnico(ruolo, codiceFiscale, nome, cognome, dataAssunzione, codiceFiscManager,
                                specialita);
                        break;
                    default:
                        System.out.println("Ruolo non riconosciuto: " + ruolo);
                }

                if (dipendente != null) {
                    dipendenti.add(dipendente);

                    // Aggiorna la lista dei dipendenti nella classe Dirigente
                    Dirigente.aggiungiDipendente(dipendente);
                }
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Collections.sort(dipendenti, new Comparator<Dipendente>() {
            public int compare(Dipendente d1, Dipendente d2) {
                return d1.getNome().compareTo(d2.getNome());
            }
        });

        System.out.println("Elenco dei dipendenti in ordine alfabetico per nome:");
        for (Dipendente dipendente : dipendenti) {
            System.out.println(dipendente);
        }
    }
}
