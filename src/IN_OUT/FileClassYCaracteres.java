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
//Metodo para guardar en un archivo un texto que en este caso en String
//de una operación matematica.
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

    //Metodo para sacar de un archivo un texto.
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

//Tengo un archivo con un texto con espacios extras en cada linea de texto.
//La idea es traer esas lineas quitarles el espacio extra y guardar ese
//String en otro archivo.
    public static void quitaEspacios (String archivoEntrada) {
        String textoSinEspacios = "";
        int primero = 0;
        Path caminoArchivoEntrada = FileSystems.getDefault().getPath(archivoEntrada);
        try {
            //FileReader fr = new FileReader(archivoEntrada);
            BufferedReader br = Files.newBufferedReader(caminoArchivoEntrada);
            String entrada="";
            while ((entrada = br.readLine()) != null) {
                //Pensando en meter el siguiente if en un bucle pero tengo
                //presente all el rato que no es eficiente.
                int cuentaEspaciosSalida=0;
                int cuentaLetrasSalida=0;
                //Monto un for coin tres pasos el primero para limpiar la parte delantera de espacios
                //Que al contarlos vuelve a empezar el for. Luego monto dos fases donde van contando
                //espacios y letras y van cambiando entre ellos mientras construye la linea.
            for (int i =0;i<entrada.length();i++){
                if (entrada.charAt(i)==' '&&primero==0){
                    cuentaEspaciosSalida++;
                } else if (!(entrada.charAt(i) ==' ')&&primero==0){
                    entrada=entrada.substring(cuentaEspaciosSalida,entrada.length());
                    primero=1;
                    cuentaEspaciosSalida=0;
                    i=-1;
                }else if (!(entrada.charAt(i) ==' ')&&primero==1){
                    cuentaLetrasSalida++;
                } else if (entrada.charAt(i)==' '&&primero==1) {
                    primero=2;
                }else if (entrada.charAt(i)==' '&&primero==2){
                    cuentaEspaciosSalida++;
                } else if (!(entrada.charAt(i) ==' ')&&primero==2) {
                    entrada = entrada.substring(0,cuentaLetrasSalida)+entrada.substring(cuentaEspaciosSalida+cuentaLetrasSalida, entrada.length());
                    primero = 1;
                    cuentaEspaciosSalida = 0;
                }
                //for
            }
            textoSinEspacios = textoSinEspacios+entrada+"\n";
               primero=0;
                //while
               }
                //fr.close();
            } catch(IOException fe){
                System.out.println("Error de E/S");
            }

        System.out.println(textoSinEspacios);

        try {
            FileWriter fw = new FileWriter("textoConEspaciosSalida");
            fw.write(textoSinEspacios);
            fw.close();
        } catch(IOException e) {
            System.out.println("Error E/S: " + e);
        }
        }

    public static void main(String[] args) {
//operacionInOut("textoprueba.txt");
//lecturaInOut("textoprueba.txt");
quitaEspacios("textoConEspacios.txt");
    //main
    }
 //class
}
