package com.company;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class g21s21880 {
    public static void main(String[] args) throws FileNotFoundException {
        String  path = args[0];
        DrzewoBinarne( path );
   }
   public static void DrzewoBinarne(String path) throws FileNotFoundException {

        File file = new File(path);
        Scanner sc = new Scanner(file);
        String line;
        int najwieksza = 0;
        while (sc.hasNextLine()) {
            line = sc.nextLine();
            String.
            char[] arr = line.toCharArray();
            int obenienajwieksza = arr.length;
            if (obenienajwieksza >= najwieksza) {
                najwieksza = obenienajwieksza;
            }
        }

        if (najwieksza>=3) {
            int ilerazy = najwieksza - 1;
            char[] ostateczna = new char[ilerazy];
            char[] literki = new char[ilerazy - 1];

            for (int i = 0; i < ilerazy; i++) {
                boolean czyTrue = false;
                char tymczasowa;
                char najwiekszychar = 'A';
                file = new File(path);
                sc = new Scanner(file);

                while (sc.hasNextLine()) {
                    line = sc.nextLine();
                    char[] arr = line.toCharArray();
                    czyTrue = false;
                    tymczasowa = arr[0];
                    if (i == 0) {
                        if (arr.length == najwieksza && tymczasowa >= najwiekszychar) {
                            najwiekszychar = tymczasowa;
                            for (int j = 0; j < ilerazy - 2; j++) {
                                literki[j] = arr[2 + j];
                            }
                        }
                    }
                    int k = ilerazy + 1;
                    if (arr.length >= 3 && i > 0 && i < ilerazy - 1 && arr.length == k - i) {
                        char[] literki2 = new char[arr.length - 2];
                        for (int j = 0; j < arr.length - 2; j++) {
                            literki2[j] = arr[2 + j];
                        }
                        for (int j = i; j <= ilerazy - 2; j++) {
                            int u = i - 1;
                            if (literki[j - 1 - u] == literki2[j - 1 - u]) {
                                czyTrue = true;
                            } else {
                                czyTrue = false;
                                j = ilerazy - 1;
                            }
                        }
                    }
                    if (czyTrue && tymczasowa >= najwiekszychar) {
                        najwiekszychar = tymczasowa;
                    }

                    if (i == ilerazy - 1 && arr.length == najwieksza) {
                        najwiekszychar = tymczasowa;
                    }
                    ostateczna[i] = najwiekszychar;
                }
                najwieksza--;
            }
            for (int i = 0; i < ilerazy; i++) {
                System.out.print(ostateczna[i]);
            }
        }else {
            System.out.print("drzewo musi mieć jakieś gałezie więc napisz więcej niż jedną linijke w pliku");
        }
    }
}