package Lambda;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class LambdaMain {

    public static String paresEjecuta(CaracteresPares porMetodo, String texto){
return porMetodo.caracteresPares(texto);

    }

    public static void main(String[] args) {

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

CambiarMays cambioMays = (listado) -> {
    Collections.sort(ciudades);
    for (String aa: listado) {
String roma=aa.substring(0,1).toUpperCase();
String poma=roma+aa.substring(1,aa.length());
aa=poma;
        System.out.println(aa);
    }
};

cambioMays.cambiarMays(ciudades);




        Supplier<String> aa = () -> {
            String prg = "Estoy en clase de programación";
            return prg;
    };



        Supplier<String> prg = () -> "Estoy en clase de programación";

        String textoPrg = prg.get();
        System.out.println(textoPrg);


        CaracteresPares losPares =(texto) -> {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < texto.length();i++){
                if (i%2==0){
                    sb.append(texto.charAt(i));
                }
            }
            return sb.toString();
        };
        System.out.println(losPares.caracteresPares("1234567890"));


        System.out.println("");
        System.out.println("Por metodo");
        System.out.println(paresEjecuta(losPares,"1234567890"));

        Runnable run = ()-> {
            String texto = "Vamos a crear un array";
            String[] partes = texto.split(" ");
            for (String parte: partes) {
                System.out.println(parte);
            }
        } ;

run.prun();


        MiPrimerLambda aPorEllo = (word, radio) -> {
            LinkedHashMap<String,Integer> mapa = new LinkedHashMap<String, Integer>();
            mapa.put(word,radio);
            int porDos=radio*2;
            System.out.println(mapa.get(word)) ;
        };

        aPorEllo.print("Rema y calla",12);



        //main
    }


    //class
}
