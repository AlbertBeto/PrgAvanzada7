package Predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class MainPredicate {

    public static void main(String[] args) {

        Predicate<Integer> mayorCien = x -> x>100;

        Predicate<Integer> menorTrecientos = x -> x<300;

        System.out.println(mayorCien.and(menorTrecientos).test(120));

        Predicate<Integer> menosCincuenta = x -> x<50;

        System.out.println(mayorCien.or(menosCincuenta).test(120));

        Predicate<Integer> igualCien = x -> x==100;

        System.out.println(igualCien.test(101));

        BiPredicate<String,String> textoIgual = (textA,textB) -> textA.equals(textB);
        System.out.println("Texte");
        System.out.println(textoIgual.test("Alfa","Alfa"));

        List<Integer> listaEnteros = new ArrayList<>();
        listaEnteros.add(1);
        listaEnteros.add(10);
        listaEnteros.add(22);
        listaEnteros.add(26);
        listaEnteros.add(28);
        listaEnteros.add(41);
        listaEnteros.add(51);
        listaEnteros.add(61);
        listaEnteros.add(71);
        listaEnteros.add(81);
        System.out.println(listaEnteros);

        Predicate<Integer> mayorVeinticinco = x -> x>25;
        Predicate<Integer> menorTreinta = x -> x<30;
        System.out.println("Listado");
        for (Integer eco: listaEnteros) {
            System.out.println(mayorVeinticinco.and(menorTreinta).test(eco));
        }
        //System.out.println(mayorVeinticinco.and(menorTreinta).test());

        Predicate<Integer> igualVeintidos = x -> x==22;
        System.out.println("Igual a .... 22");
        for (Integer eco: listaEnteros) {
            System.out.println(igualVeintidos.test(eco));
        }

        List<String> cadenaTexto = new ArrayList<>();
        cadenaTexto.add("Molta broma");
        cadenaTexto.add("Molta gracia");
        cadenaTexto.add("Tancat a un lavabo a Grecia");
        cadenaTexto.add("Tancat 36 hores en un tren a Vietnam");
        cadenaTexto.add("Pernil dolç a Hanoi");
        cadenaTexto.add("La competencia a Rac1");
        cadenaTexto.add("Antsu");

        Predicate<String> empiezaA = x -> x.substring(0,1).equals("A");
        Predicate<String> longitudCinco = x -> x.length()==5;
        System.out.println("Text List");
        for (String ecoDos: cadenaTexto) {
            if (empiezaA.test(ecoDos) && longitudCinco.test(ecoDos)){
                System.out.println("Verdad");
            }else{
                System.out.println("False");
            }

        }
        System.out.println("No empieza por P");
        Predicate<String> noEmpiezaP = x -> !x.substring(0,1).equals("P");
        for (String ecoDos: cadenaTexto) {
            if (noEmpiezaP.test(ecoDos)){
                System.out.println("Verdad");
            }else{
                System.out.println("False");
            }

        }
        //main
    }

    //class
}
