package IN_OUT;

import java.io.IOException;
import java.io.RandomAccessFile;

public class MeteDatosArchivosAleatorios {

    public static void meteIntsAA(String nombreArchivo) {
        try {
            RandomAccessFile archivoAleatorio = new RandomAccessFile(nombreArchivo, "rw");

            archivoAleatorio.writeInt(1);
            archivoAleatorio.writeInt(2);
            archivoAleatorio.writeInt(3);
            archivoAleatorio.writeInt(4);
            archivoAleatorio.writeInt(12);
            archivoAleatorio.writeInt(13);
            archivoAleatorio.writeInt(14);
            System.out.println(archivoAleatorio.getFilePointer());
        }
     catch(
    IOException e)

    {
        e.printStackTrace();
    }
}

    public static void main(String[] args) {
        meteIntsAA("EnterosArchivosAleatorios.txt");
    }
    //class
}
