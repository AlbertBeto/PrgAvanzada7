package IN_OUT;

import java.io.File;
import java.nio.file.Path;

public class FilePath {

public static void cuentaArchivosCarpeta(String ruta){
    int archivos=0;
    int carpetas=0;

    File carpetaBusqueda = new File(ruta);
    File[] cosasEnCarpeta = carpetaBusqueda.listFiles();

    for (File archivosEnArray: cosasEnCarpeta
         ) {
        if (archivosEnArray.isFile()){
            archivos++;
        }else {
            carpetas++;
        }
    }
    System.out.println("En la carpeta hay "+archivos+" archivos y "+carpetas+" carpetas.");
}

    public static void main(String[] args) {

      //  File file = new File("c:\\temp"); // No crea archivo solo es un gestor de ruta.

        File rutaArchivo = new File("textoConEspaciosSalida");

if (rutaArchivo.exists()){
    System.out.println("El archivo existe. ");
}else {
    System.out.println("El archivo no existe. ");
}

        cuentaArchivosCarpeta("B:/Cerbell/GSDAW/PROGRAMACIONJAVA/UNIDAD 7/PrgAvanzada/PrgAvanzada");

        //main
    }

    //class
}
