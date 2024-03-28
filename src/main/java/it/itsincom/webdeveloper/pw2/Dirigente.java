package it.itsincom.webdeveloper.pw2;

import java.time.LocalDate;
import java.util.ArrayList;

public class Dirigente extends Dipendente {
    private String divisione;
    private static ArrayList<Dipendente> dipendenti = new ArrayList<>();

    public static ArrayList<Dipendente> getDipendenti() {
        return dipendenti;
    }

    public Dirigente(String ruolo, String codiceFiscale, String nome, String cognome, String divisione,
            LocalDate dataAssunzione) {
        super(ruolo, codiceFiscale, nome, cognome, dataAssunzione);
        this.divisione = divisione;
        this.stipendio = calcolaStipendio();
    }

    // si basa sull'araylist dipendenti deve esserre inizializzato

    public double calcolaStipendio() {
        double stipendioBase = 2500; // salario standard
        double bonus = calcolaBonus(); // calc bonus
        return stipendioBase + bonus;
    }

    public double calcolaBonus() {
        double totaleStipendi = 0;

        for (Dipendente dipendente : dipendenti) {
            totaleStipendi += dipendente.calcolaStipendio();
        }

        return totaleStipendi * 0.1;
    }

    public void aggiungiDipendente(Dipendente dipendente) {
        dipendenti.add(dipendente);
    }

    public String getDivisione() {
        return divisione;
    }

    public void setDipendenti(ArrayList<Dipendente> dipendenti) {
        Dirigente.dipendenti = dipendenti;
    }

    @Override
    public String toString() {
        return "Dirigente [codiceFiscale=" + getCodiceFiscale() + ", nome=" + getNome() + ", cognome="
                + getCognome() + ", dataAssunzione=" + getDataAssunzione() + ", stipendio=" + calcolaStipendio()
                + ", divisione=" + divisione + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Dipendente other = (Dipendente) obj;
        if (codiceFiscale == null) {
            return other.codiceFiscale == null;
        } else {
            return codiceFiscale.equals(other.codiceFiscale);
        }
    }

}
