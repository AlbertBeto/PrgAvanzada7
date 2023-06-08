package IN_OUT;

import java.nio.file.Path;
import java.nio.file.Paths;

public class NIO {

    public static void main(String[] args) {

/*
        Path ruta = Paths.get("\\Cerbell\\.\\GSDAW\\PROGRAMACIONJAVA\\UNIDAD 7\\PrgAvanzada\\..\\PrgAvanzada\\..\\..\\..\\src\\IN_OUT\\ArchivosAleatorios.java");
        Path rutaLimpia = ruta.normalize();
        System.out.println("Ruta original: " + ruta);
        System.out.println("Ruta limpia: " + rutaLimpia);
*/

        /*
        Path rutaBase = Paths.get("\\GSDAW");
        Path RutaResuelta = rutaBase.resolve("PROGRAMACIONJAVA\\UNIDAD 8");
        System.out.println("Ruta resuelta: " + RutaResuelta);
*/
        /*
        Path rutaBase = Paths.get("\\GSDAW\\PROGRAMACIONJAVA\\UNIDAD 7");
        Path rutaObjetivo = Paths.get("\\GSDAW\\PROGRAMACIONJAVA\\UNIDAD 7\\PrgAvanzada\\");
        Path rutaRelativa = rutaBase.relativize(rutaObjetivo);
        System.out.println("Ruta relativa: " + rutaRelativa);
*/

        Path ruta = Paths.get("C:/temp/aules/ada/");
        Path subruta = ruta.subpath(1, ruta.getNameCount());
        System.out.println("Subruta: " + subruta);

        //main
    }
}
