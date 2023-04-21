package Stream;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamTest {

    public static void main(String[] args) {

        List<Integer> lista = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        Set<Integer> set = lista.stream()
                .peek(System.out::println)
                .collect(Collectors.toSet());

        List<String> cadenas = Arrays.asList("Texto1", "Texto2", "texto3");
        cadenas.stream().filter(s -> s.length() == 5);



        //main
    }


    //class
}
