package it.itsincom.webdeveloper.pw2;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
 
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Azienda azienda = new Azienda("Azienda di test");
        ArrayList<Dipendente> dipendenti = new ArrayList<>();
        String filePath = "C:\\PW2---Java\\src\\main\\java\\it\\itsincom\\webdeveloper\\pw2\\elenco dipendenti.txt";
 
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
 
                try {
                    azienda.addDipendente(dipendente);
                } catch (IllegalArgumentException e) {
                    System.out.println("Errore: " + e.getMessage());
                }
                dipendenti.add(dipendente);
 
                // Aggiorna la lista dei dipendenti nella classe Dirigente
                Dirigente.aggiungiDipendente(dipendente);
 
                Manager.aggiungiDipendente(dipendente);
            }
 
        }
        scanner.close();
 
        Collections.sort(dipendenti, new Comparator<Dipendente>() {
            public int compare(Dipendente d1, Dipendente d2) {
                return d1.getNome().compareTo(d2.getNome());
            }
        });
 
        System.out.println("Elenco dei dipendenti in ordine alfabetico per nome:");
 
        Dipendente precedente = null; // Aggiungiamo una variabile per tenere traccia del dipendente precedente
        for (Dipendente dipendente : dipendenti) {
            // Controlliamo se il dipendente è diverso dal precedente
            if (precedente == null || !precedente.equals(dipendente)) {
                System.out.println(dipendente);
            }
            precedente = dipendente; // Aggiorniamo il dipendente precedente
        }
 
        // Ordinamento per anzianità
        Collections.sort(dipendenti, new Comparators.AnzianitaComparator());
 
        System.out.println("Elenco dei dipendenti ordinato per anzianità:");
        Dipendente precedenteAnzianita = null;
        for (Dipendente dipendente : dipendenti) {
            if (precedenteAnzianita == null
                    || !precedenteAnzianita.getCodiceFiscale().equals(dipendente.getCodiceFiscale())) {
                System.out.println(dipendente);
            }
            precedenteAnzianita = dipendente;
        }
 
        // Ordinamento personalizzato per stipendio
        Collections.sort(dipendenti, new Comparator<Dipendente>() {
            @Override
            public int compare(Dipendente d1, Dipendente d2) {
                // Se entrambi i dipendenti sono manager o dirigenti, li ordiniamo per stipendio
                if ((d1 instanceof Manager || d1 instanceof Dirigente)
                        && (d2 instanceof Manager || d2 instanceof Dirigente)) {
                    return Double.compare(d1.getStipendio(), d2.getStipendio());
                }
                // Altrimenti, manteniamo l'ordine attuale
                return 0;
            }
        });
 
        // Ordinamento personalizzato per stipendio decrescente
        Collections.sort(dipendenti, new Comparator<Dipendente>() {
            @Override
            public int compare(Dipendente d1, Dipendente d2) {
                // Se entrambi i dipendenti sono manager o dirigenti, li ordiniamo per stipendio
                if ((d1 instanceof Manager || d1 instanceof Dirigente)
                        && (d2 instanceof Manager || d2 instanceof Dirigente)) {
                    if (d1 instanceof Dirigente && d2 instanceof Dirigente) {
                        return Double.compare(d2.getStipendio(), d1.getStipendio());
                    } else if (d1 instanceof Manager && d2 instanceof Manager) {
                        return Double.compare(d2.getStipendio(), d1.getStipendio());
                    } else if (d1 instanceof Dirigente) {
                        return -1; // d1 è un dirigente, quindi viene prima
                    } else {
                        return 1; // d2 è un dirigente, quindi viene prima
                    }
                }
                // Se uno dei dipendenti è un manager o un dirigente, lo ordiniamo prima
                else if (d1 instanceof Manager || d1 instanceof Dirigente) {
                    return -1;
                } else if (d2 instanceof Manager || d2 instanceof Dirigente) {
                    return 1;
                }
                // Altrimenti, manteniamo l'ordine attuale
                return 0;
            }
        });
 
        System.out.println("Elenco dei dipendenti ordinato per stipendio (decrescente):");
        Dipendente precedenteStipendio = null;
        for (Dipendente dipendente : dipendenti) {
            if (precedenteStipendio == null
                    || !precedenteStipendio.getCodiceFiscale().equals(dipendente.getCodiceFiscale())) {
                System.out.println(dipendente);
            }
            precedenteStipendio = dipendente;
        }
 
    }
}