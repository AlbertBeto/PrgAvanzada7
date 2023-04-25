package Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamTest {

    public static void main(String[] args) {

        Emp e1 = new Emp("Robert", 34);
        Emp e2 = new Emp("Josef", 19);
        Emp e3 = new Emp("Mathew", 45);
        Emp e4 = new Emp("Christine", 32);
        Emp e5 = new Emp("Magdalene", 64);

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
