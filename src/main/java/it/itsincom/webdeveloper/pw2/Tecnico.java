package it.itsincom.webdeveloper.pw2;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class Tecnico extends Dipendente {
    private String codiceFiscaleDirigente;
    private String specialita;

    public Tecnico(String ruolo, String codiceFiscale, String nome, String cognome, LocalDate dataAssunzione,
                   String codiceFiscaleDirigente, String specialita) {
        super(ruolo, codiceFiscale, nome, cognome, dataAssunzione);
        this.codiceFiscaleDirigente = codiceFiscaleDirigente;
        this.specialita = specialita;
        this.stipendio = calcolaStipendio();
    }

    @Override
    double calcolaStipendio() {
        if (anniLavorati() < 10) {
            return 1500.0; // tecnico - 10 anni lavoro
        } else {
            return 1600.0; // tecnico + 10 anni lavoro
        }
    }

   public int anniLavorati() {
        LocalDate today = LocalDate.now();
        Period period = Period.between(getDataAssunzione(), today);
        return period.getYears();
    }

    // Getters and setters

    public String getCodiceFiscaleDirigente() {
        return codiceFiscaleDirigente;
    }

    public void setCodiceFiscaleDirigente(String codiceFiscaleDirigente) {
        this.codiceFiscaleDirigente = codiceFiscaleDirigente;
    }

    public String getSpecialita() {
        return specialita;
    }

    public void setSpecialita(String specialita) {
        this.specialita = specialita;
    }

    @Override
    public String toString() {
        return "Tecnico [ruolo=" + getRuolo() + ", codiceFiscale=" + getCodiceFiscale() + ", nome=" + getNome()
                + ", cognome=" + getCognome() + ", dataAssunzione=" + getDataAssunzione() + ", stipendio=" + stipendio
                + ", codiceFiscaleDirigente=" + codiceFiscaleDirigente + ", specialita=" + specialita + "]";
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
    return Objects.equals(codiceFiscale, other.codiceFiscale);
}

}
