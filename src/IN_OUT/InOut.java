package IN_OUT;

import java.io.*;
import java.util.Scanner;

public class InOut {
    public static void test(String file, int number) throws IOException {
        try (OutputStream out = new FileOutputStream(file)) {
            out.write(number);
        }
        System.out.println(Integer.toBinaryString(number));
        try (InputStream input = new FileInputStream(file)) {
            System.out.println(input.read());
        }
    }
    public static void main(String[] args) {
/*
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
*/
/*
        try {
            test("hola.txt", -10);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //Esto es TRY-WITH-RESOURCES automaticamente hace el close
        try (FileWriter fw = new FileWriter("output.txt")){

            fw.write("alfa bravo");
            // fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
*/



        //DataInputStream entrada = new DataInputStream(new FileInputStream(file1));
        //DataOutputStream salida;
        String file1= args[0];
        String file2= args[1];
        try(DataInputStream entrada = new DataInputStream(new FileInputStream(file1));DataOutputStream salida = new DataOutputStream(new FileOutputStream(file2));){
            while(entrada.available()>0) {
                salida.write(entrada.read());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }



        //main
    }

    //class
}
//skinparam LineType ortho