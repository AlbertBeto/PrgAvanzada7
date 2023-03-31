package Consumer;

import java.time.LocalDate;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class ConsumerPrueba {
    public static void main(String[] args) {
//Ejercicio uno
        Consumer<String> alfa = x -> System.out.println(x);

//Ejercicio dos
        List<Integer> listadoNumeros = new ArrayList<>();
        listadoNumeros.add(1);
        listadoNumeros.add(2);
        listadoNumeros.add(3);
        listadoNumeros.add(4);
        listadoNumeros.add(5);
        listadoNumeros.add(6);
        listadoNumeros.add(7);
        listadoNumeros.add(8);
        listadoNumeros.add(9);
        listadoNumeros.add(0);

        //Consumer<Integer> imprimeObjeto = aa -> System.out.println(aa);
        //listadoNumeros.forEach(imprimeObjeto);
        // OTra opción es
        listadoNumeros.forEach(aa -> System.out.println(aa));


        //Ejercicio 3

        List<String> listadoPalabras = new ArrayList<>();
        listadoPalabras.add("Alfa");
        listadoPalabras.add("Bravo");
        listadoPalabras.add("Charly");
        listadoPalabras.add("Delta");
        listadoPalabras.add("Eco");
        listadoPalabras.add("Foxtrot");
        listadoPalabras.add("Golf");
        listadoPalabras.add("Hotel");
        listadoPalabras.add("India");
        listadoPalabras.add("Juliete");

       // Consumer<String> imprimeUltimaLetra = aa -> System.out.println(aa.substring(aa.length()-1));
        // listadoPalabras.forEach(imprimeUltimaLetra);

        listadoPalabras.forEach(aa -> System.out.println(aa.substring(aa.length()-1)));

        //Ejercicio 4

        Supplier<String> queJava = () -> "Java es un lenguaje de programación";
        System.out.println(queJava.get());

//Ejercicio 5  Numero Random

        Supplier<Double> dobleAleatorio = () -> Math.random();
        System.out.println(dobleAleatorio.get());


        //Ejercicio 6

Supplier<HashMap> crearMapa = () -> new HashMap<String,String>();

//Ejercicio 7
        BiConsumer<Integer,Integer> multiplica = (x,y) -> System.out.println(x*y);
multiplica.accept(-9,7);

//Ejercicio 8
        BiConsumer<Integer,Integer> multiple = (x,y) -> {System.out.println(x+y);
            System.out.println(x+y);
            System.out.println(x-y);
            System.out.println(x/y);
        };
        multiple.accept(-9,7);

        System.out.println("Separado");
        BiConsumer<Integer,Integer> suma = (x,y) -> System.out.println(x+y);
        BiConsumer<Integer,Integer> resta = (x,y) -> System.out.println(x-y);
        BiConsumer<Integer,Integer> division = (x,y) -> System.out.println(x/y);
        suma.accept(-9,7);
        resta.accept(-9,7);
        division.accept(-9,7);


        //ejercicio 9
        System.out.println("Esto es Calculator");
        calculator(-9,7,suma);

        //ejercicio 10
        LinkedHashMap<Integer,String> malosPelis = new LinkedHashMap<>();
        malosPelis.put(1,"Scorpion");
        malosPelis.put(2,"WidowMaker");
        malosPelis.put(3,"Lex Lutor");
        malosPelis.put(4,"Bruja del Norte");
        malosPelis.put(5,"Vertorix");

        malosPelis.forEach((key,value) -> System.out.println(key+" "+value));

        //ejercicio 11
        Supplier tiempo = () -> LocalDate.now();
        System.out.println("La fecha de hoy es "+tiempo.get());

        //ejercicio 12
        Programador roger = new Programador("Roger");
        Programador albert = new Programador("Albert");
        Programador ricard = new Programador("Ricard");

        LinkedHashMap<Integer,Programador>listadoProgramadores = new LinkedHashMap<>();
        listadoProgramadores.put(1,roger);
        listadoProgramadores.put(2,albert);
        listadoProgramadores.put(3,ricard);

      listadoProgramadores.forEach((key,value)->System.out.println(listadoProgramadores.get(key).getNombre()+listadoProgramadores.get(key).getSalario()+listadoProgramadores.get(key).getFechaInicio()));
       listadoProgramadores.forEach((key,value)->fabricaProgramadores(value));
        listadoProgramadores.forEach((key,value)->System.out.println(listadoProgramadores.get(key).getNombre()+listadoProgramadores.get(key).getSalario()+listadoProgramadores.get(key).getFechaInicio()));
        //main
    }

    public static void calculator(Integer num1, Integer num2, BiConsumer<Integer,Integer> operator){
        operator.accept(num1,num2);
    }
    public static Programador fabricaProgramadores(Programador alfa){
        if (alfa.getSalario()==0){
            Consumer<Programador> sueldoEstandar = A -> A.setSalario(50000);
            sueldoEstandar.accept(alfa);
        }
        if (alfa.getFechaInicio()==null){
            Consumer<Programador> fechaHoy = A -> A.setFechaInicio(LocalDate.now());
            fechaHoy.accept(alfa);
        }
        return alfa;
    }

    //class
}
