package it.itsincom.webdeveloper.pw2;

import java.time.LocalDate;
import java.util.ArrayList;

public class Manager extends Dipendente {
    private ArrayList<Tecnico> tecniciDiretti;
    private String settoreCompetenza;

    public Manager(String ruolo, String codiceFiscale, String nome, String cognome, LocalDate dataAssunzione,
            String settoreCompetenza) {
        super(ruolo, codiceFiscale, nome, cognome, dataAssunzione);
        this.settoreCompetenza = settoreCompetenza;
        this.tecniciDiretti = new ArrayList<>();
    }

    public void addTecnico(Tecnico tecnico) {
        if (!tecniciDiretti.contains(tecnico)) {
            tecniciDiretti.add(tecnico);
        }
    }

    double calcolaStipendio() {
        double stipendioBase = 2000.0;
        double bonus = 0.0;

        for (Tecnico tecnico : tecniciDiretti) {
            if (tecnico.anniLavorati() < 10) {
                bonus += 150.0; // 10% di 1500€ quelli - 10 anni
            } else {
                bonus += 160.0; // 10% di 1600€ quelli + 10 anni
            }
        }

        return stipendioBase + bonus;
    }

    public ArrayList<Tecnico> getTecniciDiretti() {
        return tecniciDiretti;
    }

    public double getStipendio() {
        return calcolaStipendio(); // O restituisci il valore dello stipendio memorizzato nell'attributo
    }

    public void setTecniciDiretti(ArrayList<Tecnico> tecniciDiretti) {
        this.tecniciDiretti = tecniciDiretti;
    }

    public String getSettoreCompetenza() {
        return settoreCompetenza;
    }

    public void setSettoreCompetenza(String settoreCompetenza) {
        this.settoreCompetenza = settoreCompetenza;
    }

    @Override
    public String toString() {
        return "Manager [ruolo=" + getRuolo() + ", codiceFiscale=" + getCodiceFiscale() + ", nome=" + getNome()
                + ", cognome=" + getCognome() + ", dataAssunzione=" + getDataAssunzione() + ", stipendio="
                + calcolaStipendio() + ", settoreCompetenza=" + settoreCompetenza + "]";
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
