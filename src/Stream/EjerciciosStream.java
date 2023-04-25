package Stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class EjerciciosStream {


    public static void main(String[] args) {
        List<Integer> listadoEnteros = new ArrayList<>();
        listadoEnteros.add(1);
        listadoEnteros.add(2);
        listadoEnteros.add(3);
        listadoEnteros.add(4);
        listadoEnteros.add(5);

        listadoEnteros.stream().forEach(System.out::println);

        //Ejercicio 2 para convertir el listado de integers devolviendo un set.
        //Podriamos dar un nombre
        listadoEnteros.stream().collect(Collectors.toSet());

        //Ejercicio 3.
        String text1 = "Calabacin";
        String text2 = "Cebolla";
        String text3 = "Aceite";
        String text4 = "Huevo";

        List<String> listadoStrings = new ArrayList<>();

        listadoStrings.add(text1);
        listadoStrings.add(text2);
        listadoStrings.add(text3);
        listadoStrings.add(text4);

        List<String> listadoStringsMays = new ArrayList<>();

        for (String alfa :
        listadoStrings) {
            listadoStringsMays.add(alfa.toUpperCase());
        }

        //Ejercicio 4 que es el 3 pero con streams

        listadoStrings.stream().forEach(s -> s.toUpperCase());

        //Ejercicio 5 Repasa el listado de Strings y que cualquiera contenga una X

        System.out.println(listadoStrings.stream().allMatch(s -> s.contains("x")));

        //Ejercicio 6 filtra las cadenas

        listadoStrings.stream().filter(s -> s.contains("a")).forEach(System.out::println);

        // Ejercico 7

        System.out.println(listadoStrings.stream().filter(s -> s.contains("a")).count());

        //Ejercicio 8


        //main
    }


    //class
}
