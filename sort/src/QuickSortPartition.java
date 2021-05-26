import java.util.ArrayList;
import java.util.Collections;

public class QuickSortPartition {
    public static int liczbaRekurencji=-1;

    public static void main(String[] args) {
        int[] tab = new int[]{3,16,6,13,3,10,4,14,18,0,1,5};
        ArrayList<Integer> E = new ArrayList<Integer>();//tu podać tablice
        for (int i = 0; i <tab.length ; i++) {
            E.add(tab[i]);
        }
        QuickSortPartition(E,-1);
        System.out.println("Liczba wykonań rekurencyjnych algorytmu QuickSortPartition: "+liczbaRekurencji);

        int var =1;
        System.out.println(var << 1);

    }


    public static void QuickSortPartition(ArrayList<Integer> E,int drzewo){
        liczbaRekurencji++;
        System.out.println("Wykonanie QuickSortPartition nr: "+(liczbaRekurencji+1));
        drzewo++;
        System.out.println("Wysokość tej gałęzi to: "+drzewo);
        int m=0;
        int n=E.size();
        System.out.print("[");
        for (int i = 0; i <n-1 ; i++) {
            System.out.print(E.get(i)+",");
        }
        System.out.print(E.get(n-1));
        System.out.println("]");

        m=Partition(E);

        System.out.print("[");
        for (int i = 0; i <n-1 ; i++) {
            System.out.print(E.get(i)+",");
        }
        System.out.print(E.get(n-1));
        System.out.println("]");
        System.out.println();
        if(m>1){
            ArrayList<Integer> tab1 = new ArrayList<Integer>();
            for (int i = 0; i <m ; i++) {
                tab1.add(E.get(i));
            }
            QuickSortPartition(tab1,drzewo);
        }
        if((n-m-1)>1){
            ArrayList<Integer> tab2 = new ArrayList<Integer>();
            for (int i = m+1; i <n ; i++) {
                tab2.add(E.get(i));
            }
            QuickSortPartition(tab2,drzewo);
        }
    }
    public static int Partition(ArrayList<Integer> E){
        int l=-1;
        int r=0;
        int n = E.size();
        while (r<n-1)  {
            if (E.get(r)<E.get(n-1)) {
                if (r>l+1)
                    Collections.swap(E,r,l+1);
                l+=1;
            }
            r+=1;
        }
        if(l+1<n-1)
            Collections.swap(E,l+1,n-1);
        return l+1;
    }

}
