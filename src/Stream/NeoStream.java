package Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class NeoStream {
    public static void main(String[] args) {

        List<String> bingonum = Arrays.asList(
                "A40", "B12", "B65", "C34", "C71", "D55", "D20", "D36", "d99", "E89");

        //Imprimir el listado como sea
        bingonum.forEach(System.out::println);

        for (String num: bingonum  ) {
            System.out.println(num);
        }

        //Con stream
        bingonum.stream().forEach(System.out::println);
        bingonum.stream().forEach(s -> System.out.println(s));

        //Ver si algun numero de la lista contiene X

        System.out.println(bingonum.stream().filter(s -> s.contains("x")).collect(Collectors.toSet()));
        System.out.println(bingonum.stream().anyMatch(s -> s.contains("x")));

        //Todos lo s numeros que empiezan por D
for (String s:bingonum){
    if (s.startsWith("D")){
        System.out.println(s);
    }
}

        bingonum.forEach(s -> System.out.println(s.startsWith("D")));

//Muestramelo ordenado
        List<String> list = new ArrayList<>();
        bingonum.forEach(s -> {
                    if (s.toUpperCase().startsWith("D")) {
                        list.add(s);
                    }

                });

        //Con streams
        System.out.println("Con Streams");
        bingonum.stream().filter(s -> s.startsWith("D")).sorted().forEach(System.out::println);
bingonum.stream().map(String::toUpperCase).filter(s -> s.startsWith("D")).sorted().forEach(System.out::println);

        //main
    }
    //class
}
