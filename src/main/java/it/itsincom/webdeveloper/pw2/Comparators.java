package it.itsincom.webdeveloper.pw2;

import java.util.Comparator;
 
public class Comparators {
    public static class AnzianitaComparator implements Comparator<Dipendente> {
        @Override
        public int compare(Dipendente d1, Dipendente d2) {
            return d1.getDataAssunzione().compareTo(d2.getDataAssunzione());
        }
    }
 
    public static class StipendioComparator implements Comparator<Dipendente> {
        @Override
        public int compare(Dipendente d1, Dipendente d2) {
            return Double.compare(d1.getStipendio(), d2.getStipendio());
        }
    }
}
 