package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

class Element {
    private Integer label;
    private Element next;
    private Element back;

    public void insert(Element e1, Element e2) {
        e2.next = e1;
        push(e1, e2);
        e1.back = e2;
    }

    private void push(Element e1, Element e2) {
        e2.back = e1.back;
        e1.back.next = e2;
    }

    public void ADD_OPERATION(int idx) {
        Element newElement = new Element(idx);
        rewrite(newElement);
    }

    private void rewrite(Element newElement) {
        this.next.back = newElement;
        newElement.next = this.next;
        this.next = newElement;
        newElement.back = this;
    }

    public int DEL_OPERATION() {
        Element delete = this.next;
        changePlaces();
        return delete.label;
    }

    private void changePlaces() {
        this.next.next.back = this;
        this.next = this.next.next;
    }

    public void print(Element e1, Element e2) {
        System.out.printf("%s ",e1.getLabel());
        if (e1.next != e2)
            print(e1.next, e2);
    }

    public Element pop(int x) {
        if (x > 0)
            return next.pop(x - 1);
        return this;
    }

    public int getValue() {
        return label;
    }

    public Element operate(int k, Element main) {
        for (; k > 0;) {
            int key = main.getValue();
            if (!(key % 2 == 0))
                main.ADD_OPERATION(key - 1);
            if (key % 2 == 0)
                key = main.DEL_OPERATION();

            main = main.pop(key);
            k--;
        }

        return main;

    }

    public void create(int[] data) {
        int i = 1;
        while (i < data.length) {
            Element last = new Element(data[i]);
            last.next = this;
            last.back = back;
            back.next = last;
            back = last;
            i++;
        }
    }

    Element(int label) {
        this.label = label;
        next = this;
        back = this;
    }

    public String getLabel() {
        return label.toString();
    }

}

public class g21s21880 {

    public g21s21880(String path) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(path)));
            int k = Integer.parseInt(br.readLine());
            String[] linia = br.readLine().split(" ");
            int[] data = new int[linia.length];
            convertDataType(linia, data);
            go(k, data);

        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }

    public static void main(String[] args) {
        new g21s21880(args[0]);
    }

    private static void go(int k, int[] data) {
        Element main = new Element(data[0]);
        main.create(data);
        main = main.operate(k, main);
        main.print(main, main);
    }

    private static void convertDataType(String[] linia, int[] data) {
        for (int i = 0; i < linia.length; i++)
            data[i] = Integer.parseInt(linia[i]);
    }
}