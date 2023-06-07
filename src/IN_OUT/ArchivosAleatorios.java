package IN_OUT;

import java.io.IOException;
import java.io.RandomAccessFile;

public class ArchivosAleatorios {


    public static void main(String[] args) {

        try {
            RandomAccessFile archivoAleatorio = new RandomAccessFile("textoAleatorio.txt", "rw");

            // a. Escribe tres datos usando los métodos writeChar(), writeInt() y writeDouble().
            archivoAleatorio.writeChar('A');
            archivoAleatorio.writeInt(1234);
            archivoAleatorio.writeDouble(2.22);

            // b. Lleva el puntero al principio del fichero usando el método seek().
            archivoAleatorio.seek(0);

            // c. c. Lee los tres elementos e imprímelos por consola.
            char infoChar1 = archivoAleatorio.readChar();
            int infoInt2 = archivoAleatorio.readInt();
            double infoDouble3 = archivoAleatorio.readDouble();

            System.out.println("El valor Char es "+infoChar1);
            System.out.println("El valor Int es "+ infoInt2);
            System.out.println("El valor Double es "+infoDouble3);

            // d. Ahora lleva el puntero al segundo elemento y luego lee e imprime el segundo elemento del fichero.
            archivoAleatorio.seek(2);
            infoInt2 = archivoAleatorio.readInt();
            System.out.println("**El valor Int es "+infoInt2);

            // e. Mueve el puntero al final usando el método length(), luego añade el segundo elemento y debajo añade otro ítem booleano.
            archivoAleatorio.seek(archivoAleatorio.length());
            archivoAleatorio.writeInt(infoInt2);
            archivoAleatorio.writeBoolean(true);

           // f. Ahora tenemos 5 ítems en el fichero y el puntero está al final, es decir, más allá del
           //  quinto elemento, lleva el puntero al cuarto elemento e imprímelo.
            archivoAleatorio.seek(4);
            int infoInt4 = archivoAleatorio.readInt();
            System.out.println(infoInt4);
            boolean infoBoo5 = archivoAleatorio.readBoolean();
            System.out.println(infoBoo5);
          //  System.out.println(archivoAleatorio.length());

            // g. Al final, cierra el fichero usando el método close().

            archivoAleatorio.close();
//try
        } catch (IOException e){
            e.printStackTrace();
        }


        //main
    }




    //class
}
