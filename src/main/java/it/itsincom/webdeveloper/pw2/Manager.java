package it.itsincom.webdeveloper.pw2;

import java.time.LocalDate;
import java.util.ArrayList;
 
public class Manager extends Dipendente {
    private String settoreCompetenza;
    private ArrayList<Tecnico> tecniciDiretti;
    private String codiceFiscDirigente;
    private static ArrayList<Dipendente> dipendenti = new ArrayList<>();
 
    public Manager(String ruolo, String codiceFiscale, String nome, String cognome, LocalDate dataAssunzione,
            String codiceFiscDirigente, String settoreCompetenza) {
        super(ruolo, codiceFiscale, nome, cognome, dataAssunzione);
        this.codiceFiscDirigente = codiceFiscDirigente;
        this.settoreCompetenza = settoreCompetenza;
        this.tecniciDiretti = new ArrayList<>();
        this.stipendio = calcolaStipendio();
    }
 
    double calcolaStipendio() {
        double stipendioBase = 2000;
        double bonus = calcolaBonus();
        return stipendioBase + bonus;
    }
 
    double calcolaBonus() {
        double totaleBonus = 0;
        for (Dipendente dipendente : dipendenti) {
            if (dipendente instanceof Tecnico) {
                Tecnico tecnico = (Tecnico) dipendente;
                if (tecnico.getCodiceFiscManager().equals(getCodiceFiscale())) {
                    totaleBonus += tecnico.getStipendio() * 0.1;
                }
            }
        }
        return totaleBonus;
    }
 
    public void aggiungiTecnicoDiretto(Tecnico tecnico) {
        tecniciDiretti.add(tecnico);
    }
 
    public static void aggiungiDipendente(Dipendente dipendente) {
        dipendenti.add(dipendente);
    }
 
    public static void setDipendenti(ArrayList<Dipendente> dipendenti) {
        Manager.dipendenti = dipendenti;
    }
 
    public String getCodiceFiscDirigente() {
        return codiceFiscDirigente;
    }
 
    public String getSettoreCompetenza() {
        return settoreCompetenza;
    }
 
    public ArrayList<Tecnico> getTecniciDiretti() {
        return tecniciDiretti;
    }
 
    @Override
    public double getStipendio() {
        return calcolaStipendio();
    }
 
    @Override
    public String toString() {
        return "Manager [ruolo=" + getRuolo() + ", codiceFiscale=" + getCodiceFiscale() + ", nome=" + getNome()
                + ", cognome=" + getCognome() + ", dataAssunzione=" + getDataAssunzione() + ", stipendio="
                + getStipendio() + ", settoreCompetenza=" + settoreCompetenza;
    }
}