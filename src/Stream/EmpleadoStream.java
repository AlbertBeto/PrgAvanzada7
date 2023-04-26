package Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class EmpleadoStream{

    private String nombre;
    private int edad;

    private String departamento;

    public EmpleadoStream(String nombre, int edad, String departamento) {
        this.nombre = nombre;
        this.edad = edad;
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return "EmpleadoStream{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", departamento='" + departamento + '\'' +
                '}';
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getDepartamento() {
        return departamento;
    }

    public static void main(String[] args) {
        EmpleadoStream el1 = new EmpleadoStream("Alfa", 22, "Sistemas");
        EmpleadoStream el2 = new EmpleadoStream("Bravo", 42, "Recursos Humanos");
        EmpleadoStream el3 = new EmpleadoStream("Charlie", 54, "Sistemas");
        EmpleadoStream el4 = new EmpleadoStream("Delta", 38, "Produccion");
        List<EmpleadoStream> listaEmpleados2 = new ArrayList<>();
        listaEmpleados2.add(el1);
        listaEmpleados2.add(el4);
        listaEmpleados2.add(el3);
        listaEmpleados2.add(el2);
//Ejercicio 9. Devuelve una lista que contenga el nombre de los trabajadores.
       System.out.println(listaEmpleados2.stream().map(empleadoStream -> empleadoStream.nombre).toList());

       //Ejercicio 10. Filtra los empleados que tengan más de 30 años y muestra cuantos cumplen la condición.
        System.out.println(listaEmpleados2.stream().filter(empleadoStream -> empleadoStream.edad>30).count());

        //Ejercicio 11. Crea un alista de nombre con los empleados de más de 30 años.
        System.out.println(listaEmpleados2.stream().filter(empleadoStream -> empleadoStream.edad>30).map(empleadoStream -> empleadoStream.nombre).toList());

        //Ejercicio 12.
        //Añade en la clase empleado el nombre del departamento al que pertenece el empleado.
        // Sobre la lista filtramos los empleados que pertenencen al departamento sistemas, luego ordenamos por nombre de forma ascendente,
        // filtramos para no hayan repetidos e imprimimos los nombres restantes.


        listaEmpleados2.stream()
        .filter(empleadoStream -> empleadoStream.departamento.equals("Sistemas"))

        //.sorted(Comparator.reverseOrder())
        //.sorted(Comparator.comparing(emp -> emp.getNombre()))
        .distinct()
        .forEach(System.out::println);

        //Ejercicio 13. Investiga el método .reduce que sirve que le das dos valores y te devuelve 1.
    //    listaEmpleados2.stream().filter(empleadoStream -> empleadoStream.getDepartamento().equals("Sistemas")).reduce((empleadoStream, empleadoStream2) -> empleadoStream.getNombre()+"-"+empleadoStream2.getNombre()));

//main
    }
/*
    @Override
    public int compareTo(Object o) {
        EmpleadoStream alfa = (EmpleadoStream) o;

        return this.getNombre().compareTo(alfa.getNombre());
    }

 */


    //class
}


