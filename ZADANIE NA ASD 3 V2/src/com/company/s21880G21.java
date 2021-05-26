package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class s21880G21 {

    public static void main(String[] args) throws FileNotFoundException {

	String path = "C:\\Users\\PC\\Desktop\\asd3.txt";

        File file = new File(path);
        Scanner sc = new Scanner(file);
        String line;
        String line2;
        line = sc.nextLine();
        line2 = sc.nextLine();
        System.out.println(line2);

        MyLinkedList M1 = new MyLinkedList(path);
        run(line);
    }

}

class Node {
    int dane;
    Node next;

    Node(int d) {
        dane = d;
        next = null;
    }
}

class MyLinkedList {

    Node head=null; // head of list
    Node current=null;
    int length=0;

    public MyLinkedList(String path) throws FileNotFoundException {

        File file = new File(path);
        Scanner sc = new Scanner(file);
        String line;
        while (sc.hasNextLine()) {
            line = sc.nextLine();
            char[] arr = line.toCharArray();
        }

        int tmp=0;
        if(path.length()>0) {
            length++;
            tmp = Character.getNumericValue(path.charAt(0));
            head = new Node(tmp);
            current = head;
        }
        for (int i = 2; i <path.length() ; i+=2) {
            length++;
            tmp=Character.getNumericValue(path.charAt(i));
                current.next=new Node(tmp);
            if (i == path.length() - 1) {
                current.next.next = head;
                current=head;
            }
            else {
                current = current.next;
            }
        }

    }
    public void insert(int data) {
        if(head==null) {
            head = new Node(data);
            current=head;
        }
        else {
            current.next=new Node(data);
            current=current.next;
        }
    }
    private void ADD(){
        int x=current.dane;
        Node tmp1=new Node(x-1);
        Node tmp2=current.next;//kopiowanie node p+1
        current.next=tmp1;////wstawienie na p+1
        tmp1.next=tmp2;//wstawienie skopiowanego node na p+2
        for (int i = 0; i <x%length  ; i++) {
            current=current.next;
        }
    }
    private void DELETE(){
        int x=current.next.dane;
        Node tmp=current.next.next;
        current.next=tmp;
        for (int i = 0; i <x%length ; i++) {
            current=current.next;
        }
    }
    public void run(int k){
        for (int i = 0; i <k ; i++) {
            if(current.dane %2==0)
                DELETE();
            else
                ADD();
        }
    }

    public void printList() {//printowanie od current
        Node tmp=current;
        Node curNode=tmp.next;
        System.out.println(tmp.dane);
        while(curNode!=tmp){
            System.out.println(curNode.dane);
            curNode=curNode.next;
        }
    }

}