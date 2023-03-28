package Genericos;

import java.util.ArrayList;
import java.util.Iterator;

public class GenericosMain2 {
    public static void main(String[] args) {
        System.out.println("Hello world!");


        ArrayList<String> al = new ArrayList<String>();
        al.add("A");
        al.add("B");
        m1(al);
        Iterator<String> itr = al.iterator();
        while (itr.hasNext()){
            String str = itr.next();
            System.out.print(str + " ");
        }

        System.out.println("Viejo");
        System.out.println(al);
        System.out.println(al.get(0));
        System.out.println(al.get(2));

    }


    public static void m1(ArrayList al){
        al.add(10);
        al.add(10.5);
        al.add(true);
    }

    //class
}
