package com.company;
import java.util.Comparator;
public class PrzedmiotComparator<T extends Przedmiot> implements Comparator<T> {
    private PrzedmiotCrit type;
    PrzedmiotComparator(PrzedmiotCrit type){
        this.type=type;
    }
    @Override
    public int compare(T o1, T o2) {
        Przedmiot A1= (Przedmiot)o1;
        Przedmiot A2= (Przedmiot)o2;
        switch (type){
            case ROZMIAR:
                return A1.PowierzchniaPrzedmiotu()-A2.PowierzchniaPrzedmiotu();
            case NAZWA:
            return A1.Nazwa.compareTo(A2.Nazwa);
        }
        return 0;
    }
}
