package Function;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionPrueba {

    public static void main(String[] args) {


        //ejercicio 1
        Function<String,Integer> longitudText = alfa -> alfa.length();
        System.out.println(longitudText.apply("Raditz era buen tio"));

//Ejercicio 2
        Function<Integer,Integer> cuadrado = alfa -> alfa*alfa;
        System.out.println(cuadrado.apply(4));

        //Ejercicio 3

        System.out.println(longitudText.andThen(cuadrado).apply("Goku dejo morir a su hermano"));

        //Ejercicio 4
        List<String> listadoAlfaString = new ArrayList<>();
        listadoAlfaString.add("Pua tocaba a Yansha");
        listadoAlfaString.add("Goku no sabia identificar generos humanos");
        listadoAlfaString.add("Goku toco la entrepierna de Arale");
        listadoAlfaString.add("TauPauPai era gay");

        System.out.println(convertirListaEnMap(listadoAlfaString,longitudText));

        //Ejercicio 5

        BiFunction<Integer,Integer,Integer> suma = (ee, aa) -> (ee+aa);
        System.out.println(suma.apply(8,7));

        //Ejercicio 6
        BiFunction<Integer,Integer,Double> aDoble = (x,y) -> Math.pow(x,y);
        System.out.println(aDoble.apply(4,6));

        //Ejercicio 7
        Function<Double,String> muestraResultado = valor -> "Resultado: "+ valor;

        //Ejercicio 8
        System.out.println(aDoble.andThen(suma).apply(2,4));

        //main
    }


    //Ejercicio 4 Metodo

    public static Map convertirListaEnMap(List<String> listadoOriginal,Function<String,Integer> conversor) {
        Map<String, Integer> listaSalida = new HashMap<>();
        listadoOriginal.forEach((key) -> listaSalida.put(key, conversor.apply(key)));
        return listaSalida;
    }



    //class
}
