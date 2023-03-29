package PredicateII;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

public class PredicateTest {

    public static void main(String[] args) {


        Employee e1 = new Employee("Albert Perez", 32);
        Employee e2 = new Employee("Robert Perez", 21);
        Employee e3 = new Employee("Alfred Perez", 22);
        Employee e4 = new Employee("Scumm Perez", 55);
        Employee e5 = new Employee("Alt Perez", 44);
        Employee e6 = new Employee("Al Perez", 37);
        Employee e7 = new Employee("bert Perez", 21);
        Employee e8 = new Employee("Cobre Perez", 55);

        List<Employee> employees = new ArrayList<>();

        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
        employees.add(e4);
        employees.add(e5);
        employees.add(e6);
        employees.add(e7);
        employees.add(e8);

        //Vamos a crear una Function que devuelva el nombre de un empleado en mayusculas.
        Function<Employee,String> convertirMayusculaName = currela -> currela.getName().toUpperCase();


        //Quiero a partir del nombre en mayuscular solo devolver el nombre no el apellido.
        Function<String, String> soloNombre = nombre -> nombre.substring(0, nombre.indexOf(' '));


        //Y nuestro amigo ANDTHEN!!! aparece. Es una tuberia.
        Function unionFunicones = convertirMayusculaName.andThen(soloNombre);

        System.out.println(unionFunicones.apply(employees.get(1)));

        //Ahora vmaos a concatenar el nombre de un empleado, con su edad y un salario que me pasan y lo devuelvo.

        BiFunction<Employee, Integer, String> situacionEmpleado = (empleado, salario) -> (empleado.getName())+" "+(empleado.getAge())+" "+(salario);
        System.out.println(situacionEmpleado.apply(employees.get(2),1000));

        //Funcion que realice una suma

        BiFunction<Integer,Integer,Integer> suma = (a1,a2) -> a1+a2;

        // Funcion que multiplique

        BiFunction<Integer,Integer,Integer> multiplica = (a1,a2) -> a1*a2;

        //Funicon en cadena que suma ym ultiplica

        Function<Integer,Integer> multiplica2 = (a1) -> a1*a1;

        BiFunction sumaMulti = suma.andThen(multiplica2);
        System.out.println(sumaMulti.apply(2,3));


        //El unaryOperator solo trabaja con un solo digito.
        UnaryOperator<Integer> doble = x -> x*x;


        Predicate<Employee> menoresDeEdad = e -> e.getAge() <18;

        Predicate<Employee> mayor10 = s -> s.getAge() >= 10;

        //menoresDeEdad.and(mayor10);
        mayor10.and(menoresDeEdad).test(new Scrapper("", 13));
        //con or
        mayor10.or(menoresDeEdad).test(new Scrapper("", 13));

        Predicate<String> eq = Predicate.isEqual("java");
        System.out.println(eq.test("Patri"));

        printEmployeeByAge(employees, (e) -> e.getAge()<18);

        //Supplier que devuelva un número

        Supplier<Integer> supplierNumero = () -> 6;
        IntSupplier suplierNumero2 = () ->6+2;

        //Supplier que devuelva una Arraylist

        Supplier<ArrayList> listaTurn = () -> new ArrayList();
        List l = listaTurn.get();

        //supplier que me devuelve un numero random
        Supplier<Double> random= () -> Math.random()*100;
        for (int i = 0; i < 10;i++){
            System.out.println(random.get());
        }

        //Consumer imprimir el nombre d eun empleado. Consumer no returnea nada

        Consumer<Employee> currela = Employee -> System.out.println(Employee.getName());
        currela.accept(employees.get(1));
        //especial listas
        employees.forEach((e) -> System.out.println(e.getName()));

        //imprimir empleados con edad mayor a 30
        employees.forEach(e -> {
             if(e.getAge() > 30){
                 System.out.println(e);
             }
        }
        );


//main
    }


    public static void printEmployeeByAge(List<Employee> empleados, Predicate<Employee> ageCondition){
        for (Employee e : empleados){
            if (ageCondition.test(e)){
                System.out.println(e.getName());
            }
        }
    }



    //class
}

