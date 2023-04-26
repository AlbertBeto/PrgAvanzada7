package Stream;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {

    public static void main(String[] args) {

        Emp e1 = new Emp("Robert", 34, 2000);
        Emp e2 = new Emp("Josef", 19, 1500);
        Emp e3 = new Emp("Mathew", 45, 1000);
        Emp e4 = new Emp("Christine", 32, 1000);
        Emp e5 = new Emp("Magdalene", 64, 1400);

        Dept dInf = new Dept("Informatica");

        dInf.addEmps(e1);
        dInf.addEmps(e2);
        dInf.addEmps(e3);

        Dept rrhh = new Dept("Recursos Humanos");
        rrhh.addEmps(e4);
        rrhh.addEmps(e5);

        List<Dept> empresa = new ArrayList<>();
        empresa.add(dInf);
        empresa.add(rrhh);

        // SIEMPRE EMPRESA.

        //Mostrar el nombre del primer empleado de cada departamento

        empresa.stream()
                .map(d -> d.getEmps()
                        .get(0)).map(e ->e.getNombre())
                            .forEach(System.out::println);

        // Enla tuberia tiene que haber al final todos los empleados de la empresa
        // y luego los imprimo.

        empresa.stream().flatMap(dept -> dept.getEmps().stream()).forEach(System.out::println);

        // En la tuberia tiene que haber losnombres de los empleados del departamento de informatica y los imprimo

        empresa.stream()
                .filter(dept -> dept.getNombre().equals("Informatica"))
                .flatMap(dept -> dept.getEmps().stream())
                //Filtramos por mayor de 40 anos
                .filter(emp -> emp.getEdad()>40)
                .map(emp -> emp.getNombre())
                .forEach(System.out::println);

        //Mostrar todos los empleados consalario entre 1500 y 2000, ordenados ascendentemente por salario.
        Predicate<Emp> filtrado = emp -> emp.getSalario()>=1500&&emp.getSalario()<=2000;
        Comparator<Emp> comparator = (o1, o2) -> (int) (o1.getSalario() - o2.getSalario());

        empresa.stream()
                .flatMap(dept -> dept.getEmps().stream())
                .filter(emp -> emp.getSalario()>=1500&&emp.getSalario()<=2000) //Aqui podria poner el predicate filtrado
                .sorted(Comparator.comparing(emp -> emp.getSalario()))
                //.sorted(Comparator.comparing(Emp::get.Salario, (o1,o2) -> (int) (o2 - o1))) //Con el comparing se introduce los valores del comparator.
                .forEach(System.out::println);


        // FORMAS DE CREAR STREAMS
        //Stream a partir de una colección
        List<String> lista = Arrays.asList("A", "B");
        lista.stream();

        //Lista de argumentos
        Stream.of("A", "B");

        Stream.of(new Emp("Joseph", 125, 1));

        //Arrays de enteros
        Stream.of(new int[]{1,2});

        Stream<Integer> stream = Stream.of(1,2,3);

        //Stream de objetos
       // Arrays.stream(new Object[]{new Emp("Sara",22,1100), new Dept("Pimpollos")};

        //Steam de supplier
        Stream.generate(() -> Arrays.asList(1,2,3));

        //
        IntStream.range(0,11);
        //Sumar los 10 primeros números
        //System.out.println(IntStream.range(0,11).sum());

        //Bucle infinito
        //Stream.iterate(0,i -> i+1).forEach(System.out::println);
        //Bucle limitado
       // Stream.iterate(0,i -> i+1).limit(10).forEach(System.out::println);
        //Aqui limitamos el bucle sin limit
       Stream.iterate(0, i -> i<10, i -> i+1).forEach(System.out::println);;

        // Empezamos desde ', queremos mostrar las 5 primeras combinaciones
        // de los pares a partir del 10, es decir 12,14,16

Stream.iterate(0, i -> i+1).filter(i-> i % 2 ==0).skip(6).limit(5).forEach(System.out::println);



        /*

        List<Integer> lista = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        Set<Integer> set = lista.stream()
                .peek(System.out::println)
                .collect(Collectors.toSet());

        List<String> cadenas = Arrays.asList("Texto1", "Texto2", "texto3");
        cadenas.stream().filter(s -> s.length() == 5);

        List<Integer> l1 = Arrays.asList(1,2,3);
        List<Integer> l2 = Arrays.asList(4,5,6);
        List<Integer> l3 = Arrays.asList(7,8,9);

        List<List<Integer>> lists = Arrays.asList(l1,l2,l3);

        lists.stream().map(integers -> integers.get(0)+2).forEach(System.out::println);

        //Imprimir todos los elementos de todas las listas
        System.out.println("Aplatanados con flatmap");
        lists.stream().flatMap(integers -> integers.stream()).forEach(System.out::print);

        //Imprimir 56789 de la tuberia
        lists.stream().flatMap(integers -> integers.stream()).skip(4).forEach(System.out::println);

        //

*/
        //main
    }


    //class
}
