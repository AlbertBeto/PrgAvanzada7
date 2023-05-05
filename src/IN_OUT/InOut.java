package IN_OUT;

import java.io.*;
import java.util.Scanner;

public class InOut {

    public static void main(String[] args) {

        try {
            DataOutputStream fos = new DataOutputStream(new FileOutputStream("datos.dat"));
            fos.writeInt(0);
            fos.writeInt(4);
            fos.writeInt(255);
            fos.writeInt(-7);
            fos.close();
        } catch (FileNotFoundException e) { //todas pueden derivar de IOException
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Ahora lectura");
        try {
            DataInputStream fos = new DataInputStream(new FileInputStream("datos.dat"));
            int alfa=0;
            while(fos.available()>0){
            alfa = alfa + fos.readInt();
            }
            System.out.println(alfa);
            fos.close();
        } catch (FileNotFoundException e) { //todas pueden derivar de IOException
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        //main
    }

    //class
}
