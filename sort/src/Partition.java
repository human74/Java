public class Partition {
    public static void main(String[] args) {
//PARTITION

        int [] tab={19,9,5,12,1,18,4,3,13,11,7};
        int l=-1;
        int r=0;
        int n= tab.length;
        int x=1;

        System.out.println("PIERWOTNA");
        for(int i=0;i<tab.length;i++){

            System.out.print(tab[i]+" ");
        }
        System.out.println("\n**********************************");

        while (r<n-1) {

            System.out.println("porównanko "+(r+1));
            if(tab[r]<tab[n-1]){
                if(r>l+1) {
                    int temp = tab[r];
                    tab[r] = tab[l + 1];
                    tab[l + 1] = temp;

                    System.out.println("PRZESTAWIENIE "+x);
                    for(int i=0;i<tab.length;i++){

                        System.out.print(tab[i]+" ");
                    }
                    System.out.println();
                    System.out.println("l= "+(l+1)+" r= "+(r+1));
                    x++;
                }
                l=l+1;
            }
            r=r+1;


        }
        if(l+1<n-1){

            int temp = tab[l+1];
            tab[l+1] = tab[n-1];
            tab[n-1] = temp;

        }


        System.out.println("OSTATECZNIE");
        for(int i=0;i<tab.length;i++){

            System.out.print(tab[i]+" ");
        }
    }
}
