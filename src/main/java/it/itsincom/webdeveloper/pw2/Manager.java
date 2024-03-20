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

    private double calcolaBonus() {
        double totaleBonus = 0;
        for (Tecnico tecnico : tecniciDiretti) {
            if (tecnico.getCodiceFiscManager().equals(getCodiceFiscale())) {
                totaleBonus += tecnico.getStipendio() * 0.1;
            }
        }
        return totaleBonus;
    }

    public static void aggiungiDipendente(Dipendente dipendente) {
        dipendenti.add(dipendente);
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

    public void aggiungiTecnicoDiretto(Tecnico tecnico) {
        tecniciDiretti.add(tecnico);
    }

    @Override
    public String toString() {
        return "Manager [ruolo=" + getRuolo() + ", codiceFiscale=" + getCodiceFiscale() + ", nome=" + getNome()
                + ", cognome=" + getCognome() + ", dataAssunzione=" + getDataAssunzione() + ", stipendio="
                + calcolaStipendio() + ", settoreCompetenza=" + settoreCompetenza + ", tecniciDiretti="
                + tecniciDiretti.size() + "]";
    }

}