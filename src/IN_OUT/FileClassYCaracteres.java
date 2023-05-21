package IN_OUT;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileClassYCaracteres {

    public static void operacionInOut(String archivo){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce numero uno");
        int numOne = sc.nextInt();
        System.out.println("Introduce numero dos");
        int numTwo = sc.nextInt();
        int operator = numOne%numTwo;

        String salida = numOne+" % "+numTwo+" = "+operator;
        try {
            FileWriter fw = new FileWriter(archivo);
            fw.write(salida);
            fw.close();
        } catch(IOException e) {
            System.out.println("Error E/S: " + e);
        }
    }

    public static void lecturaInOut(String archivo){
        String salida="";
        int ch;
        try {
            FileReader fr = new FileReader(archivo);
            ch = fr.read();
            while (ch != -1) {
                salida=salida+(char)ch;
               //System.out.print((char) ch);
                ch = fr.read();
            }
            fr.close();
        } catch (IOException fe) {
            System.out.println("Error de E/S");
        }
        System.out.println(salida);
    }

    public static void main(String[] args) {
operacionInOut("textoprueba.txt");
lecturaInOut("textoprueba.txt");

    }


    //class
}
