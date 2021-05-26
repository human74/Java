public class BinSearch {
    public static void main(String[] args) {
        // BINSEARCH

        int [] tab={0,2,3,4,5,6,7,8,10,11,13,14,15,17,18};
        int x=18;

        System.out.println("TABLICA:");
        for(int i=0;i<tab.length;i++){

            System.out.print(tab[i]+" ");
        }
        System.out.println("\nROZPATRYWANY X = "+x);
        System.out.println("********************************");


        int l = 0;
        int r =tab.length-1;
        int m=((l+r)/2);
        int j=0;
        System.out.println("m"+j+" = "+m);
        j++;

        while(tab[m]!=x){


            if(tab[m]<x){
                l=m+1;
            }else{
                r=m-1;
            }
            m=((l+r)/2);
            System.out.println("m"+j+" = "+m);
            j++;
        }
        System.out.println("Porównanka x"+(((j-1)*2)+1));

    }
}
