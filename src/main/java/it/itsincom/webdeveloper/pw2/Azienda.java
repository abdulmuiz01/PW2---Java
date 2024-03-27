package it.itsincom.webdeveloper.pw2;

import java.util.ArrayList;

public class Azienda {
    private String nome;
    private ArrayList<Dipendente> dipendenti;
    protected double stipendioTotale;

    public Azienda(String nome) {
        this.nome = nome;
        dipendenti = new ArrayList<>();
        this.stipendioTotale = 0.0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Dipendente> getDipendenti() {
        return dipendenti;
    }

    public void setDipendenti(ArrayList<Dipendente> dipendenti) {
        this.dipendenti = dipendenti;
    }

    @Override
    public String toString() {
        return "Azienda [nome=" + nome + ", dipendenti=" + dipendenti + "]";
    }
    public void calcolaStipendio() {
        stipendioTotale = 0.0;
        for (Dipendente dipendente : dipendenti) {
            stipendioTotale += dipendente.calcolaStipendio();
        }
    }
      public double getStipendioTotale() {
        double totalEarnings = 0.0;
        for (Dipendente dipendente : dipendenti) {
            totalEarnings += dipendente.getStipendio();
        }
        return totalEarnings;
    }
}
