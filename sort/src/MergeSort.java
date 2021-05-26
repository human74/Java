import java.util.ArrayList;
import java.util.List;

public class MergeSort {
    static int RecursiveCount=-1;
    static int RecursiveDrzewo=0;
    public static void main(String[] args) {
        int[] E = new int[]{15,6,2,12,13,1,11,8,10,14,4,7,15};//tu podać tablice
        MergeSort(E,-1);
        System.out.println("Liczba wywołań rekurencyjnych: "+RecursiveCount);
        System.out.println("Liczba wywołań Merge: "+(RecursiveCount+1));
        System.out.println("Wysokość drzewa wywołać rekurencyjnych: "+RecursiveDrzewo);
    }
    public static void MergeSort(int E[],int drzewo){
        drzewo++;
        if(drzewo>RecursiveDrzewo)
            RecursiveDrzewo=drzewo;
        RecursiveCount++;
        System.out.print("Argumentem "+(RecursiveCount+1)+" wywołania algorytmu MergeSort jest: ");
        for (int i = 0; i <E.length ; i++) {
            System.out.print(E[i]+",");
        }
        System.out.println();
        int n=E.length;
        int tab1[]=new int[n/2];
        for (int i = 0; i <tab1.length ; i++) {
            tab1[i]=E[i];
        }
        int tab2[]=new int[n-tab1.length];
        for (int i = 0; i <tab2.length ; i++) {
            tab2[i]=E[i+n/2];
        }
        
        if(n>1){
            if(n/2>1){
                MergeSort(tab1,drzewo);
            }
            if(n-n/2>1){
                MergeSort(tab2,drzewo);
            }
            List<Integer> list=new ArrayList<Integer>();
            int index1=0;
            int index2=0;
            while(index1<tab1.length && index2<tab2.length){//Merge
                if(tab1[index1]<tab2[index2]){
                    list.add(tab1[index1]);
                    index1++;
                }
                else {
                    list.add(tab2[index2]);
                    index2++;
                }
            }
            while(index1<tab1.length){
                list.add(tab1[index1]);
                index1++;
            }
            while(index2<tab2.length){
                list.add(tab2[index2]);
                index2++;
            }
            for (int i = 0; i <E.length ; i++) {
                E[i]=list.get(i);
            }
            for (int i = 0; i <E.length ; i++) {
                System.out.print(E[i]+",");
            }
            System.out.println();
        }
    }
}
