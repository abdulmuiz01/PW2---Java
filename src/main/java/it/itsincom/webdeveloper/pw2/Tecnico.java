package it.itsincom.webdeveloper.pw2;

import java.time.LocalDate;
 
class Tecnico extends Dipendente {
    private String specialita;
    private String codiceFiscManager;
 
    public Tecnico(String ruolo, String codiceFiscale, String nome, String cognome, LocalDate dataAssunzione,
            String codiceFiscManager, String specialita) {
        super(ruolo, codiceFiscale, nome, cognome, dataAssunzione);
        this.codiceFiscManager = codiceFiscManager;
        this.specialita = specialita;
        this.stipendio = calcolaStipendio();
    }
 
    private double calcolaStipendio() {
        LocalDate oggi = LocalDate.now();
        int anzianita = oggi.getYear() - getDataAssunzione().getYear();
 
        if (getDataAssunzione().isAfter(oggi.minusYears(anzianita))
                || getDataAssunzione().isEqual(oggi.minusYears(anzianita))) {
            anzianita--;
        }
 
        if (anzianita < 10) {
            return 1500;
        } else {
            return 1600;
        }
    }
 
    public String getSpecialita() {
        return specialita;
    }
 
    public String getCodiceFiscManager() {
        return codiceFiscManager;
    }
 
    @Override
    public String toString() {
        return "Tecnico [ruolo=" + getRuolo() + ", codiceFiscale=" + getCodiceFiscale() + ", nome=" + getNome()
                + ", cognome=" + getCognome() + ", dataAssunzione=" + getDataAssunzione() + ", stipendio="
                + getStipendio() + ", specialita=" + specialita + "]";
    }
}