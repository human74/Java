package com.company;
import java.io.*;
import java.util.Scanner;

class Tree {
    int data;
    int parent, left, right;
    public Tree(int data, int parent, int left, int right) {
        this.data = data;
        this.parent = parent;
        this.left = left;
        this.right = right;
    }
    public Tree(int data) {
             this(data, -1, -1, -1) ;
    }
    public Tree() {
        this(0);
    }
}

class Treev2 {
      private final int leafNumber;
      private final Tree[] treetab;
      public Treev2 (int[] weights) {
      int n = weights.length;
      this.leafNumber = n;
      this.treetab = new Tree[2 * n - 1];
      for(int i = 0 ; i < n; ++i) {
            this.treetab[i] = new Tree(weights[i]);
      }
      for(int i = 0 ; i < n - 1; ++i) {
          int min1 = Integer.MAX_VALUE;
          int min2 = min1;
          int p1 = -1, p2 = -1;
          for(int j = 0 ; j < n + i ; ++j) {

          if(treetab[j].data < min1 && treetab[j].parent == -1) {
            min2 = min1;
            p2 = p1;
            min1 = treetab[j].data;
            p1 = j;
          }
          else if(treetab[j].data < min2 && treetab[j].parent == -1) {
             min2 = treetab[j].data;
             p2 = j;
          }
          }
          treetab[p1].parent = n + i;
          treetab[p2].parent = n + i;
          this.treetab[n + i] = new Tree(min1 + min2, -1, p1, p2) ;
      }
}

    public String[] toNumbers() {
        String[] huffcodes = new String[this.leafNumber];
        for(int i = 0 ; i < this.leafNumber ; ++i) {
            huffcodes[i] = "";
            int child = i;
            int parent = treetab[child].parent;
            while(parent != -1) {
            if(treetab[parent].left == child) {
               huffcodes[i] = "0" + huffcodes[i];
            }
            else {
                huffcodes[i] = "1" + huffcodes[i];
         }
                child = parent;
                parent = treetab[child].parent;
        }
    }
       return huffcodes;
}
    public static void main(String[] args) throws IOException {
        String  path = args[0];
        BufferedReader reader = new BufferedReader(new FileReader(path));
        int lines = 0;
        while (reader.readLine() != null) lines++;
        reader.close();
        File file = new File(path);
        Scanner sc = new Scanner(file);
        String line;
        int n=0;
        int [] weights = new int[lines];
        String [] arr3 = new String[lines];
        while (sc.hasNextLine()) {
            line = sc.nextLine();
            String[] arr = line.split("\\s+", -1);
            weights[n] = Integer.parseInt(arr[1]);
            arr3[n] = arr[0];
            n++;
        }
        Treev2 tree = new Treev2(weights);
        String[] codes = tree.toNumbers();
        for(int i = 0 ; i < codes.length ; ++i) {
            System.out.println(arr3[i] + " " + codes[i] + "   ");
        }
     }
}