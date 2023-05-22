package IN_OUT;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
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


    public static void quitaEspacios (String archivoEntrada) {
        String textoSinEspacios = "";
        int primero = 0;
        Path p = FileSystems.getDefault().getPath(archivoEntrada);
        try {
            //FileReader fr = new FileReader(archivoEntrada);
            BufferedReader br = Files.newBufferedReader(p);
            String entrada="";
            while ((entrada = br.readLine()) != null) {

                //Pensando en meter el siguiente if en un bucle pero tengo
                //presente all el rato que no es eficiente.

if(entrada.substring(0).equals(" ")&&primero==0){
    entrada=entrada.substring(1,entrada.length());
}

            //System.out.println(entrada);
textoSinEspacios = textoSinEspacios+entrada+"\n";
                 //   ch = fr.read();
               }
                //fr.close();
            } catch(IOException fe){
                System.out.println("Error de E/S");
            }

        System.out.println(textoSinEspacios);
        }



    public static void main(String[] args) {
//operacionInOut("textoprueba.txt");
//lecturaInOut("textoprueba.txt");
quitaEspacios("textoConEspacios.txt");
    }


        /* Restos de codigo
        while (ch != -1) {
                char comparador = (char)ch;
                String comparadorS = Character.toString(comparador);
                if (!comparadorS.equals(" ")&&primero==0){
                textoSinEspacios=(char)ch+" ";
                primero=1;
                } else if (!comparadorS.equals(" ")&&primero==1) {
                    textoSinEspacios=textoSinEspacios+(char)ch;
                }

                ch = fr.read();
            }
            fr.close();
        } catch (IOException fe) {
            System.out.println("Error de E/S");
        }
         */



    //class
}
