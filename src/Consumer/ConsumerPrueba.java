package Consumer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class ConsumerPrueba {
    public static void main(String[] args) {
//Ejercicio uno
        Consumer<String> alfa = x -> System.out.println(x);

//Ejercicio dos
        List<Integer> listadoNumeros = new ArrayList<>();
        listadoNumeros.add(1);
        listadoNumeros.add(2);
        listadoNumeros.add(3);
        listadoNumeros.add(4);
        listadoNumeros.add(5);
        listadoNumeros.add(6);
        listadoNumeros.add(7);
        listadoNumeros.add(8);
        listadoNumeros.add(9);
        listadoNumeros.add(0);

        //Consumer<Integer> imprimeObjeto = aa -> System.out.println(aa);
        //listadoNumeros.forEach(imprimeObjeto);
        // OTra opción es
        listadoNumeros.forEach(aa -> System.out.println(aa));


        //Ejercicio 3

        List<String> listadoPalabras = new ArrayList<>();
        listadoPalabras.add("Alfa");
        listadoPalabras.add("Bravo");
        listadoPalabras.add("Charly");
        listadoPalabras.add("Delta");
        listadoPalabras.add("Eco");
        listadoPalabras.add("Foxtrot");
        listadoPalabras.add("Golf");
        listadoPalabras.add("Hotel");
        listadoPalabras.add("India");
        listadoPalabras.add("Juliete");

       // Consumer<String> imprimeUltimaLetra = aa -> System.out.println(aa.substring(aa.length()-1));
        // listadoPalabras.forEach(imprimeUltimaLetra);

        listadoPalabras.forEach(aa -> System.out.println(aa.substring(aa.length()-1)));

        //Ejercicio 4

        Supplier<String> queJava = () -> "Java es un lenguaje de programación";
        System.out.println(queJava.get());

//Ejercicio 5  Numero Random

        Supplier<Double> dobleAleatorio = () -> Math.random();
        System.out.println(dobleAleatorio.get());


        //Ejercicio 6

Supplier<HashMap> crearMapa = () -> new HashMap<>();

//Ejercicio 7
        BiConsumer<Integer,Integer> epsilon = (x,y) -> System.out.println(x*y);
epsilon.accept(-9,7);



        //main

    }


    //class
}
