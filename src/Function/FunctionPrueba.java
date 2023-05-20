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
        listadoAlfaString.add("TauPaiPai era gay");

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
        System.out.println(aDoble.andThen(muestraResultado).apply(2,4));

        //Ejercicio 9
        potenciadoEImpreso(2,4);
potenciadoEImpreso22(2,4);

//Ejercicio 10
        potenciadoEImpresoGenerico(aDoble,2,12);

        //Ejercicio 11
        List<String> listadoBravoString = new ArrayList<>();
        listadoBravoString.add("Pua tocaba a Yansha");
        listadoBravoString.add("Goku no sabia identificar generos humanos");
        listadoBravoString.add("Goku tocó la entrepierna de Arale");
        listadoBravoString.add("TauPaiPai era gay");

        BiFunction<String,Integer,String> debeSerMayor = (texto,distancia) -> {
            if (texto.length()>distancia){return texto;}else{return null;}
        };

        for (String posicion:listadoBravoString) {
            System.out.println(debeSerMayor.apply(posicion,20));
        }


        //Ejercicio 12
        BiFunction<String,String,String> debeEmpezarIgual = (texto,comparador) -> {
            if (texto.substring(0,comparador.length()).equals(comparador)){return texto;}else{return null;}
        };
        for (String posicion:listadoBravoString) {
            System.out.println(debeEmpezarIgual.apply(posicion,"Goku"));
        }

        //Ejercicio 13
        filtrarLista(listadoBravoString,2,debeSerMayor);

        //main
    }


    //Ejercicio 4 Metodo

    public static Map convertirListaEnMap(List<String> listadoOriginal,Function<String,Integer> conversor) {
        Map<String, Integer> listaSalida = new HashMap<>();
        listadoOriginal.forEach((key) -> listaSalida.put(key, conversor.apply(key)));
        return listaSalida;
    }
 //Ejercicio 9 Metodo
    public static void potenciadoEImpreso(int x, int y){
        double potenciado = Math.pow((double)x,(double) y);
        String textoSalida = "Resultado: "+potenciado;
        System.out.println(textoSalida);
    }

    public static void potenciadoEImpreso22(int a, int b){
        BiFunction<Integer,Integer,Double> aDoble = (x,y) -> Math.pow(x,y);
        Function<Double,String> muestraResultado = valor -> "Resultado: "+ valor;
        System.out.println(aDoble.andThen(muestraResultado).apply(a,b));
    }



    //Ejercicio 10 Metodo genérico

    public static <T,R> void potenciadoEImpresoGenerico(BiFunction<T,T,R> funcion, T a,T b ){
        Function<R,String> muestraResultado = valor -> "Resultado: "+ valor;
        System.out.println(funcion.andThen(muestraResultado).apply(a,b));
    }

    //Ejercicio 13 Metodo

    public static <T,R> void filtrarLista(List<T> listado,R condicion,BiFunction<T,R,T> funcion){
        for (T posicion:listado) {
            System.out.println(funcion.apply(posicion,condicion));
        }
    }

    //class
}
