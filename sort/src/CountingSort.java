import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CountingSort {
    public static void main(String[] args) {
        int[] tab = new int[]{0,0,5,1,1,0,0,3,5,0,0,0};
        ArrayList<Integer> E = new ArrayList<Integer>();//tu podać tablice
        for (int i = 0; i <tab.length ; i++) {
            E.add(tab[i]);
        }
        CountingSort(E);
        System.out.println("Tablica E po sortowaniu");
        System.out.print("[");
        for (int i = 0; i <E.size() ; i++) {
            System.out.print(E.get(i)+",");
        }
        System.out.print(E.get(E.size()-1));
        System.out.println("]");

    }
    public static void CountingSort(ArrayList<Integer> E){


        int i;
        int max= Collections.max(E);
        System.out.println("Maksymalna wartość tablicy E: "+max);
        int Tmp[]=new int[max+1];
        int Out[]=new int[E.size()];
        System.out.println("================ZLICZANIE==================");
        for (i = 0; i <E.size() ; i++) {
            Tmp[E.get(i)]=Tmp[E.get(i)]+1;

        }

        System.out.print("[");
        for (int k = 0; k <Tmp.length-1 ; k++) {
            System.out.print(Tmp[k]+",");
        }
        System.out.print(Tmp[Tmp.length-1]);
        System.out.println("]");

        System.out.println("================SUMOWANIE==================");
        for (i = 1; i <max+1 ; i++) {
            Tmp[i]=Tmp[i]+Tmp[i-1];

        }

        System.out.print("[");
        for (int k = 0; k <Tmp.length-1 ; k++) {
            System.out.print(Tmp[k]+",");
        }
        System.out.print(Tmp[Tmp.length-1]);
        System.out.println("]");

        System.out.println("================WYPISYWANIE==================");
        for (i =E.size()-1;  i>=0 ; i--) {
            Out[Tmp[E.get(i)]-1]=E.get(i);
            Tmp[E.get(i)]=Tmp[E.get(i)]-1;

        }

        System.out.print("[");
        for (int k = 0; k <Tmp.length-1 ; k++) {
            System.out.print(Tmp[k]+",");
        }
        System.out.print(Tmp[Tmp.length-1]);
        System.out.println("]");

        E.clear();
        for (int j = 0; j <Out.length ; j++) {
            E.add(Out[j]);
        }
    }
}
