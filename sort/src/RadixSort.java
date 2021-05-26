import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RadixSort {
    public static int FirstCount=0;
    public static int InCount=0;

    public static void main(String[] args) {
        int[] E = new int[]{222,639,399,501,655,743,685,538,592,679,167};//tu podać tablice
        int d=3;//tu podac d
        RadixSort(E,d);

    }
    public static void RadixSort(int E[], int d){
        int i,j,k;
         List<LinkedList<Integer>> Q=new ArrayList<LinkedList<Integer>>();//elem
        for (int l = 0; l <10 ; l++) {//Q[elem]
            Q.add(new LinkedList<Integer>());
        }

        for (i = d; i>0 ; i--) {
            for (j = 0; j <E.length ; j++) {
                int index=Character.getNumericValue(Integer.toString(E[j]).charAt(i-1));
                Q.get(index).add(E[j]);
                InCount++;
            }
            System.out.println("Kolejka biorąca pod uwagę element numer "+i);
            for (int l = 0; l <Q.size() ; l++) {
                for (int m = 0; m <Q.get(l).size() ; m++) {
                    System.out.print(Q.get(l).get(m)+",");
                }
                System.out.println();

            }



        k=0;
        for (j = 0; j <10 ; j++) {
            while (!Q.get(j).isEmpty()) {
                E[k] = Q.get(j).getFirst();
                FirstCount++;
                Q.get(j).remove(0);
                k++;
            }
        }
            System.out.println("Po sortowaniu obiektów względem "+(4-i)+"-ej pozycji składowej zawartość tablicy (liczonej od prawej do lewej strony):");
            System.out.print("[");
            for (int l = 0; l <E.length-1; l++) {
                System.out.print(E[l]+",");

            }
            System.out.print(E[E.length-1]+"]");
            System.out.println();

        }
        System.out.println("Program użył operacji FIRST dokładnie "+FirstCount+" razy");
        System.out.println("Program użył operacji IN dokładnie "+InCount+" razy");
    }
}
