package IN_OUT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArchivosAleatorios2 {

    public static void main(String[] args) {
/*
        String nombreArchivo = "textoAleatorio.txt";

        try (RandomAccessFile archivo = new RandomAccessFile(nombreArchivo, "rw")) {
            // Calculamos la cantidad de enteros que contiene el archivo
            int cantidadEnteros = (int) (archivo.length() / 4);

            // Pedimos al usuario la posición del entero a modificar
            int posicion;
            do {
                System.out.print("Ingrese la posición del entero a modificar (entre 1 y " + cantidadEnteros + "): ");
                posicion = obtenerEnteroDesdeConsola();
            } while (posicion < 1 || posicion > cantidadEnteros);

            // Calculamos la posición en bytes dentro del archivo
            long posicionBytes = (posicion - 1) * 4;

            // Movemos el puntero de lectura/escritura al inicio del entero a modificar
            archivo.seek(posicionBytes);

            // Leemos el valor actual del entero en esa posición
            int valorAntiguo = archivo.readInt();
            System.out.println("Valor actual en la posición " + posicion + ": " + valorAntiguo);

            // Pedimos al usuario el nuevo valor
            System.out.print("Ingrese el nuevo valor entero: ");
            int nuevoValor = obtenerEnteroDesdeConsola();

            // Movemos nuevamente el puntero al inicio del entero a modificar
            archivo.seek(posicionBytes);

            // Escribimos el nuevo valor en la posición indicada
            archivo.writeInt(nuevoValor);
            System.out.println("Valor modificado en la posición " + posicion + ": " + nuevoValor);
        } catch (IOException e) {
            System.out.println("Ocurrió un error al acceder al archivo: " + e.getMessage());
        }
    }

    // Método auxiliar para obtener un entero desde la consola
    private static int obtenerEnteroDesdeConsola() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            return Integer.parseInt(reader.readLine());
        } catch (IOException | NumberFormatException e) {
            System.out.println("Ingrese un valor entero válido.");
            return obtenerEnteroDesdeConsola();
        }
*/
        //main
    }



//class
}
