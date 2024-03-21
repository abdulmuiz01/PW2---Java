package it.itsincom.webdeveloper.pw2;

import java.time.LocalDate;
import java.util.ArrayList;
 
public class Dirigente extends Dipendente {
    private String divisione;
    private static ArrayList<Dipendente> dipendenti = new ArrayList<>();
 
    public Dirigente(String ruolo, String codiceFiscale, String nome, String cognome, String divisione,
            LocalDate dataAssunzione) {
        super(ruolo, codiceFiscale, nome, cognome, dataAssunzione);
        this.divisione = divisione;
        this.stipendio = calcolaStipendio();
    }
 
    private double calcolaStipendio() {
        double stipendioDir = 2500;
        double bonus = calcolaBonus();
        return stipendioDir + bonus;
    }
 
    private double calcolaBonus() {
        double totaleStipendi = 0;
 
        for (Dipendente dipendente : dipendenti) {
            if (!(dipendente instanceof Dirigente)) {
                totaleStipendi += dipendente.getStipendio();
            }
        }
        return totaleStipendi * 0.1;
    }
 
    public static void aggiungiDipendente(Dipendente dipendente) {
        dipendenti.add(dipendente);
    }
 
    public String getDivisione() {
        return divisione;
    }
 
    public static void setDipendenti(ArrayList<Dipendente> dipendenti) {
        Dirigente.dipendenti = dipendenti;
    }
 
    @Override
    public String toString() {
        return "Dirigente [codiceFiscale=" + getCodiceFiscale() + ", nome=" + getNome() + ", cognome="
                + getCognome() + ", dataAssunzione=" + getDataAssunzione() + ", stipendio=" + calcolaStipendio()
                + ", divisione=" + divisione + "]";
    }
}