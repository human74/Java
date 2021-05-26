public class HoarePartition {

        public static void main(String[] args) {
            //HOAREPARTITION
            int [] tab={11,0,6,8,13,14,19,18,3};
            int k=2;

            System.out.println("TMP= "+hoarePartition(tab,k));


        }

        public static int partition(int [] tab){
            System.out.println("!!XXXXXXXX POCZATEK PARTITION XXXXXXXX!!");
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
            System.out.println("\n!!XXXXXXXX KONIEC PARTITION XXXXXXXX!!");

            return l+1;
        }
        public static int hoarePartition(int [] tab, int k){

            System.out.println("\n======");
            System.out.println("= HP =");
            System.out.println("======");
            System.out.println("k= "+k);
            int m=0, tmp=0, n=tab.length;
            m=partition(tab);

            if(n-m==k)
                return m;
            else if(n-m>k){
                int[] arr1= new int[tab.length-(m+1)];
                for(int i=m+1;i<tab.length;i++)
                    arr1[i-(m+1)]=tab[i];
                tmp=m+1+hoarePartition(arr1,k);
            }else{
                int[] arr2= new int[tab.length-(tab.length-(m-1))+1];
                for(int i=0;i<tab.length-(tab.length-(m-1))+1;i++)
                    arr2[i]=tab[i];
                tmp=hoarePartition(arr2,k-(n-m));
                System.out.println();

            }
            return tmp;
        }
}
