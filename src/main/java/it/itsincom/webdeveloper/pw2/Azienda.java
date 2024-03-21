package it.itsincom.webdeveloper.pw2;

import java.util.ArrayList;
 
public class Azienda implements Comparable<Dipendente> {
    private String nome;
    private ArrayList<Dipendente> dipendenti = new ArrayList<>();
 
    public Azienda(String nome) {
        this.nome = nome;
    }
 
    public void addDipendente(Dipendente dipendente) {
        if (dipendenti.contains(dipendente)) {
            throw new IllegalArgumentException("Il dipendente" + " " + dipendente + " è già presente nell'azienda.");
        }
        dipendenti.add(dipendente);
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
 
    @Override
    public int compareTo(Dipendente d) {
        return this.getNome().compareTo(d.getNome());
    }
 
}