

public class InsertionSort {

    public static void main(String args[])
    {
        int arr[] = {0,0,5,1,1,0,0,3,5,0,0,0};

        InsertionSort ob = new InsertionSort();
        ob.sort(arr);

    }

    void sort(int E[])
    {
        int liczbaporównań = 0;
        int licznikiteracji = 1;
        int liczbaprzestawien =0;
        int pomoc = 0;
        int j=0;
        for (int i = 1; i < E.length; ++i) {
            j = i;



            while ((j > 0) && (E[j - 1] > E[j])) {
                liczbaporównań++;
                liczbaprzestawien++;
                int tab[]=new int[E.length];
                for (int k = 0; k <E.length ; k++) {
                    tab[k]=E[k];
                }
                tab[j - 1] = E[j];
                tab[j] = E[j - 1];
                E=tab;
                j = j - 1;
            }
            if((j > 0))
                liczbaporównań++;

            System.out.println("PO "+licznikiteracji+" iteracjach tablica wygląda");
            printArray(E);
            System.out.println("liczba porównań to "+liczbaporównań);
            System.out.println("liczba przestawien to "+liczbaprzestawien);
            System.out.println();

            licznikiteracji++;
        }
    }

    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");

        System.out.println();
    }

}