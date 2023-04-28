package Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EjerciciosStream2 {


    public static void main(String[] args) {


    //Ejercicio 1 Listado, cambia primera letra a mayuscula
        System.out.println("********************* Ejercicio 1 *************************");

        List<String> ciudades = Arrays.asList(
                "elche",
                "alicante",
                "elda",
                "petrer",
                "aspe",
                "crevillente",
                "alcoy",
                "ibi",
                "benidorm",
                "matola"
        );

        ciudades.stream()
                .map(s -> s.substring(0,1).toUpperCase()+s.substring(1,s.length()))
                .forEach(System.out::println);

//ejercicio2 Añade código para hacer debug en el stream anterior. Imprime los nombres antes de ordenarlos
//para comprobar que la primera letra ha cambiado a mayúsculas y recoge los resultados en una
//lista.

        System.out.println("********************* Ejercicio 2 *************************");
        ciudades.stream()
                .map(s -> s.substring(0,1).toUpperCase()+s.substring(1,s.length()))
                .peek(s -> System.out.println(s))
                .sorted()
                .toList();


        //Ejercicio 3. A partir del ejercicio 1, en vez de imprimir los nombres ordenados, imprime cuantas ciudades
        //empiezan por la letra A. Ayuda: realiza un filtrado y utiliza la operación terminal count().
        System.out.println("********************* Ejercicio 3 *************************");
        System.out.println(
        ciudades.stream()
                .map(s -> s.substring(0,1).toUpperCase()+s.substring(1,s.length()))
                .filter(s -> s.startsWith("A"))
                .count());


        //Ejercicio 4. Crea una clase Persona con un atributo nombre y una clase Viaje con un atributo país. En la clase
        //Persona añade una lista de viajes. En el main crea una lista con dos personas y añádeles
        //diferentes viajes a cada una. Imprime usando bucles los viajes de todas las personas de la lista.
        //Haz lo mismo usando streams.

        System.out.println("********************* Ejercicio 4 *************************");

        Persona Viajero1 = new Persona("Albert");
        Persona Viajero2 = new Persona("Victor");

        Viaje Pais1 = new Viaje("Espanya");
        Viaje Pais2 = new Viaje("Grecia");
        Viaje Pais3 = new Viaje("Jamaica");
        Viaje Pais4 = new Viaje("Japan");
        Viaje Pais5 = new Viaje("Colombia");

        Viajero1.viajes.add(Pais2);
        Viajero1.viajes.add(Pais3);
        Viajero1.viajes.add(Pais4);
        Viajero2.viajes.add(Pais1);
        Viajero2.viajes.add(Pais5);
        Viajero2.viajes.add(Pais4);

        List<Persona> Viajeros = new ArrayList<>();

        Viajeros.add(Viajero1);
        Viajeros.add(Viajero2);

        for (Persona viajero:Viajeros
             ) {
        for (Viaje Viaje:
             viajero.viajes) {
            System.out.println(Viaje.getPais());
        }
        }

        System.out.println("Ahora usando Streams");

        Viajeros.stream()
                .flatMap(persona -> persona.viajes.stream())
                .map(viaje -> viaje.getPais())
                .forEach(System.out::println);


        //Ejercicio 5 Tenemos una clase Punto.java y la siguiente lista de puntos. Usando streams calcula:
        // a. La suma de todas las coordenadas X. Ayúdate de las operaciones mapToInt y reduce.
        //Imprime el resultado para ello ayúdate de la operación ifPresent. ¿Qué imprimiría si la
        //lista de puntos estuviera vacía?
        //b. Ahora calcula la suma de todas las coordenadas X pero usando las operaciones
        //mapToInt y sum. Haz debug en el stream y muestra que los valores de las coordenadas
        //son las x.
        //c. Filtra todos los puntos que sean positivos en las coordenadas X y devuélvelos en una
        //nueva lista.

        System.out.println("********************* Ejercicio 5 *************************");

        List<Punto> puntos = new ArrayList<>();

        puntos.add(new Punto(-4,-8));
        puntos.add(new Punto(-2,9));
        puntos.add(new Punto(-1,-8));
        puntos.add(new Punto(0,-7));
        puntos.add(new Punto(1,1));
        puntos.add(new Punto(2,3));
        puntos.add(new Punto(2,3));
        puntos.add(new Punto(2,-2));
        puntos.add(new Punto(4,-1));

        //A)La suma de todas las coordenadas X. Ayúdate de las operaciones mapToInt y reduce.
        //  Imprime el resultado para ello ayúdate de la operación ifPresent. ¿Qué imprimiría si la
        //  lista de puntos estuviera vacía?

        System.out.println(puntos.stream()
                .mapToInt(value -> value.getX())
                        .reduce((left, right) -> left+right));

        //B) Ahora calcula la suma de todas las coordenadas X pero usando las operaciones
        //mapToInt y sum. Haz debug en el stream y muestra que los valores de las coordenadas
        //son las x.
        System.out.println("El total de la suma es "+
        puntos.stream()
                .mapToInt(value -> value.getX())
                .peek(System.out::println)
                .sum());

        //c. Filtra todos los puntos que sean positivos en las coordenadas X y devuélvelos en una
        //nueva lista.

        puntos.stream()
                .mapToInt(Punto::getX)
                .filter(value -> value>=0)
                .toArray();





//main
    }
    //class
}
