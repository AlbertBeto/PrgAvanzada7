package IN_OUT;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class ModificaIntDentroArchivoAleatorio {

    public static void modIntDentroAA(){
        try{RandomAccessFile archivoAleatorio = new RandomAccessFile("EnterosArchivosAleatorios.txt", "rw");
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la posición del Int a modificar: ");
        int posicionMod;
        posicionMod=sc.nextInt();
        if (posicionMod>=0 && posicionMod < (archivoAleatorio.length()/4)) {
            int posicionReal = posicionMod * 4;

            archivoAleatorio.seek(posicionReal);
            System.out.println(archivoAleatorio.readInt());
            System.out.println("Introduzca el nuevo valor:");
            int neoInt = sc.nextInt();
            archivoAleatorio.seek(posicionReal);
            archivoAleatorio.writeInt(neoInt);

            //Esto es para comprobar si ha modificado bien
            archivoAleatorio.seek(posicionReal);
            System.out.println("El nuevo int de la posición es: "+archivoAleatorio.readInt());

            //if
        }else {
            System.out.println("La posición introducida es erronea.");}

        //try
     }
     catch(IOException e)
    {
        e.printStackTrace();
    }
      //metodo
    }

    public static void main(String[] args) {
        modIntDentroAA();
    }


    //class
}
