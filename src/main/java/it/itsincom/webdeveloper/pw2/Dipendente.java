package it.itsincom.webdeveloper.pw2;
import java.time.LocalDate;

public abstract class Dipendente implements Comparable<Dipendente> {
    protected String ruolo;
    protected String codiceFiscale;
    protected String nome;
    protected String cognome;
    protected LocalDate dataAssunzione;
    protected double stipendio;

    public Dipendente(String ruolo, String codiceFiscale, String nome, String cognome, LocalDate dataAssunzione) {
        this.ruolo = ruolo;
        this.codiceFiscale = codiceFiscale;
        this.nome = nome;
        this.cognome = cognome;
        this.dataAssunzione = dataAssunzione;
    }

    abstract double calcolaStipendio();

    // Getters and setters

    public String getRuolo() {
        return ruolo;
    }

    public void setRuolo(String ruolo) {
        this.ruolo = ruolo;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public LocalDate getDataAssunzione() {
        return dataAssunzione;
    }

    public void setDataAssunzione(LocalDate dataAssunzione) {
        this.dataAssunzione = dataAssunzione;
    }

    public double getStipendio() {
        return stipendio;
    }

    public void setStipendio(double stipendio) {
        this.stipendio = stipendio;
    }

    @Override
    public String toString() {
        return "Dipendente [ruolo=" + ruolo + ", codiceFiscale=" + codiceFiscale + ", nome=" + nome + ", cognome="
                + cognome + ", dataAssunzione=" + dataAssunzione + ", stipendio=" + stipendio + "]";
    }

    @Override
    public int compareTo(Dipendente d) {
        return this.getCognome().compareTo(d.getCognome());
    }
}
