package Stream;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EjerciciosStream2 {


    public static void main(String[] args) {


    //Ejercicio 1 Listado, cambia primera letra a mayuscula
        System.out.println("********************* Ejercicio 1 *************************");

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

        ciudades.stream()
                .map(s -> s.substring(0,1).toUpperCase()+s.substring(1,s.length()))
                .forEach(System.out::println);

//ejercicio2 Añade código para hacer debug en el stream anterior. Imprime los nombres antes de ordenarlos
//para comprobar que la primera letra ha cambiado a mayúsculas y recoge los resultados en una
//lista.

        System.out.println("********************* Ejercicio 2 *************************");
        ciudades.stream()
                .map(s -> s.substring(0,1).toUpperCase()+s.substring(1,s.length()))
                .peek(s -> System.out.println(s))
                .sorted()
                .toList();


        //Ejercicio 3. A partir del ejercicio 1, en vez de imprimir los nombres ordenados, imprime cuantas ciudades
        //empiezan por la letra A. Ayuda: realiza un filtrado y utiliza la operación terminal count().
        System.out.println("********************* Ejercicio 3 *************************");
        System.out.println(
        ciudades.stream()
                .map(s -> s.substring(0,1).toUpperCase()+s.substring(1,s.length()))
                .filter(s -> s.startsWith("A"))
                .count());


        //Ejercicio 4. Crea una clase Persona con un atributo nombre y una clase Viaje con un atributo país. En la clase
        //Persona añade una lista de viajes. En el main crea una lista con dos personas y añádeles
        //diferentes viajes a cada una. Imprime usando bucles los viajes de todas las personas de la lista.
        //Haz lo mismo usando streams.

        System.out.println("********************* Ejercicio 4 *************************");

        Persona Viajero1 = new Persona("Albert");
        Persona Viajero2 = new Persona("Victor");

        Viaje Pais1 = new Viaje("Espanya");
        Viaje Pais2 = new Viaje("Grecia");
        Viaje Pais3 = new Viaje("Jamaica");
        Viaje Pais4 = new Viaje("Japan");
        Viaje Pais5 = new Viaje("Colombia");

        Viajero1.viajes.add(Pais2);
        Viajero1.viajes.add(Pais3);
        Viajero1.viajes.add(Pais4);
        Viajero2.viajes.add(Pais1);
        Viajero2.viajes.add(Pais5);
        Viajero2.viajes.add(Pais4);

        List<Persona> Viajeros = new ArrayList<>();

        Viajeros.add(Viajero1);
        Viajeros.add(Viajero2);

        for (Persona viajero:Viajeros
             ) {
        for (Viaje Viaje:
             viajero.viajes) {
            System.out.println(Viaje.getPais());
        }
        }

        System.out.println("Ahora usando Streams");

        Viajeros.stream()
                .flatMap(persona -> persona.viajes.stream())
                .map(viaje -> viaje.getPais())
                .forEach(System.out::println);


        //Ejercicio 5 Tenemos una clase Punto.java y la siguiente lista de puntos. Usando streams calcula:
        // a. La suma de todas las coordenadas X. Ayúdate de las operaciones mapToInt y reduce.
        //Imprime el resultado para ello ayúdate de la operación ifPresent. ¿Qué imprimiría si la
        //lista de puntos estuviera vacía?
        //b. Ahora calcula la suma de todas las coordenadas X pero usando las operaciones
        //mapToInt y sum. Haz debug en el stream y muestra que los valores de las coordenadas
        //son las x.
        //c. Filtra todos los puntos que sean positivos en las coordenadas X y devuélvelos en una
        //nueva lista.

        System.out.println("********************* Ejercicio 5 *************************");

        List<Punto> puntos = new ArrayList<>();

        puntos.add(new Punto(-4,-8));
        puntos.add(new Punto(-2,9));
        puntos.add(new Punto(-1,-8));
        puntos.add(new Punto(0,-7));
        puntos.add(new Punto(1,1));
        puntos.add(new Punto(2,3));
        puntos.add(new Punto(2,3));
        puntos.add(new Punto(2,-2));
        puntos.add(new Punto(4,-1));

        //A)La suma de todas las coordenadas X. Ayúdate de las operaciones mapToInt y reduce.
        //  Imprime el resultado para ello ayúdate de la operación ifPresent. ¿Qué imprimiría si la
        //  lista de puntos estuviera vacía?

        System.out.println(puntos.stream()
                .mapToInt(value -> value.getX())
                        .reduce((left, right) -> left+right));

        //B) Ahora calcula la suma de todas las coordenadas X pero usando las operaciones
        //mapToInt y sum. Haz debug en el stream y muestra que los valores de las coordenadas
        //son las x.
        System.out.println("El total de la suma es "+
        puntos.stream()
                .mapToInt(value -> value.getX())
                .peek(System.out::println)
                .sum());

        //c. Filtra todos los puntos que sean positivos en las coordenadas X y devuélvelos en una
        //nueva lista.

        puntos.stream()
                .mapToInt(Punto::getX)
                .filter(value -> value>=0)
                .toArray();


        //Ejercicio 6 Calcula la siguiente información
        //a. Imprime el número de jugadores.
        //b. Imprime la media de puntuaciones de todos los jugadores.
        //c. Imprime el número de jugadores que obtuvo una puntuación mayor o igual a 90.
        //d. Usa collect() para crear una lista de String que contenga el nombre de los jugadores cuya
        //puntuación fue menor a 70.
        //e. Imprime los nombres de la lista generada en el apartado anterior.
        //f. Imprime los nombres y puntuaciones de todos los jugadores ordenados por apellido.
        //g. Imprime los nombres y puntuaciones de todos los jugadores ordenados por puntuación.
        //h. Devuelve el último jugador de la lista.

        System.out.println("********************* Ejercicio 6 *************************");

        List<PuntuacionJugador> puntuaciones = Arrays.asList(
                new PuntuacionJugador("Patricia","Martí",70),
                new PuntuacionJugador("Pablo","Díaz",85),
                new PuntuacionJugador("Ana","Alice",82),
                new PuntuacionJugador("Cooper","Jill",97),
                new PuntuacionJugador("Francisco","Fred",66),
                new PuntuacionJugador("Alicia","Barney",80),
                new PuntuacionJugador("Pablo","Judy",48),
                new PuntuacionJugador("María","James",90),
                new PuntuacionJugador("Claudia","Joe",55),
                new PuntuacionJugador("Pepe","Bill",73),
                new PuntuacionJugador("Noah","Mary",54),
                new PuntuacionJugador("Pablo","Chris",78),
                new PuntuacionJugador("David","Pat",51),
                new PuntuacionJugador("Javier","Omar",93),
                new PuntuacionJugador("Patricia","Ann",95)
        );

        //a. Imprime el número de jugadores.
        System.out.println("Cuantos Jugadores");
        System.out.println( puntuaciones.stream()
                .count());

        //b. Imprime la media de puntuaciones de todos los jugadores.
        System.out.println("La media de puntos es");
        System.out.println(puntuaciones.stream()
                .mapToInt(value -> value.puntuacion)
                .average()
                .orElse(0.0)); //Esto es para quitar el OptionalDouble que aparecía al imprimir el average

        //c. Imprime el número de jugadores que obtuvo una puntuación mayor o igual a 90.
        System.out.println("La cantidad de jugadores con mayor puntuacion de 90");
        System.out.println(puntuaciones.stream()
                .mapToInt(value -> value.puntuacion)
                        .filter(value -> value>=90)
                .count()
        );

        //d. Usa collect() para crear una lista de String que contenga el nombre de los jugadores cuya
        //puntuación fue menor a 70.

        puntuaciones.stream()
                .filter(puntuacionJugador -> puntuacionJugador.puntuacion<70)
                .map(puntuacionJugador -> puntuacionJugador.nombre)
                .collect(Collectors.toList());

        //e. Imprime los nombres de la lista generada en el apartado anterior.
        System.out.println("Los nombres de los jugadores con menos de 70 puntos");

        puntuaciones.stream()
                .filter(puntuacionJugador -> puntuacionJugador.puntuacion<70)
                .map(puntuacionJugador -> puntuacionJugador.nombre)
                .collect(Collectors.toList()).stream().forEach(System.out::println);

        //f. Imprime los nombres y puntuaciones de todos los jugadores ordenados por apellido.
        System.out.println("Imprime nombre y puntuaciones tras ordenar por apellidos");
        puntuaciones.stream()
                .sorted(Comparator.comparing(puntuacionJugador -> puntuacionJugador.apellido))
                .map(value -> value.nombre+ " " + value.puntuacion)
                .forEach(System.out::println);

        //g. Imprime los nombres y puntuaciones de todos los jugadores ordenados por puntuación.

        System.out.println("Imprime nombre y puntuaciones ordenados por puntuación");

        puntuaciones.stream()
                .sorted(Comparator.comparing(puntuacionJugador -> puntuacionJugador.puntuacion))
                .map(puntuacionJugador -> puntuacionJugador.nombre + " " + puntuacionJugador.puntuacion)
                .forEach(System.out::println);


        //h. Devuelve el último jugador de la lista.
        System.out.println("Imprime el último de la lista");
        puntuaciones.stream()
                .skip(puntuaciones.size()-1)
                .map(puntuacionJugador -> puntuacionJugador.nombre + " " + puntuacionJugador.apellido + " " + puntuacionJugador.puntuacion)
                .forEach(System.out::println);

        //Ejercicio 7 Dado el siguiente array, imprime todos los caracteres que sean distintos de “a”.

        System.out.println("********************* Ejercicio 7 *************************");

        List<List<String>> array = Arrays.asList(Arrays.asList("a", "b"),
                Arrays.asList("c", "d"), Arrays.asList("e", "f"));

        array.stream()
                .flatMap(strings -> strings.stream())
                .filter(s -> !s.equals("a"))
                .forEach(System.out::println);

        //Ejercicio 8

        List<Producto> listadoProductos = new ArrayList<>();
        Producto pro1 = new Producto(1122L, "Cable USB C 1m", "IT", 3.20);
        Producto pro2 = new Producto(3311L, "Play Station 5 refurbished", "Juguetes", 380.50);
        Producto pro6 = new Producto(3312L, "Puzzle Guardianes de la Galaxia", "Juguetes", 15.49);
        Producto pro3 = new Producto(1123L, "Altavoces Creative Faulont 2.1", "IT", 59.99);
        Producto pro4 = new Producto(2211L, "Pantalones Levis 501", "Ropa", 115.99);
        Producto pro5 = new Producto(2212L, "Camiseta Obey Killing", "Ropa", 39.99);
        Producto pro8 = new Producto(4411L, "Tropas del Espacio", "Libros", 8.99);
        Producto pro7 = new Producto(4412L, "Tigre Tigre Tigre", "Libros", 14.99);

        Cliente vip1 = new Cliente(666552525L, "MediaMarket Shop1");
        Cliente vip2 = new Cliente(666656565L, "MediaMarket Shop2");
        Cliente vip3 = new Cliente(888656565L, "PekinBonito");

        List<Pedido> listadoPedidos = new ArrayList<>();
        Pedido ped1 = new Pedido(1111L, LocalDate.of(2020,12,01), LocalDate.of(2020,12,15),"Servido", vip1);
        Pedido ped2 = new Pedido(1112L, LocalDate.of(2021,06,15),LocalDate.of(2021,06,30),"Servido", vip1 );
        Pedido ped3 = new Pedido(1113L, LocalDate.of(2023,02,01),LocalDate.of(2023,02,15),"No Pago", vip1 );
        Pedido ped4 = new Pedido(1114L, LocalDate.of(2023,04,01),LocalDate.of(2023,04,7),"No Pago", vip2 );
        Pedido ped5 = new Pedido(1115L, LocalDate.of(2023,04,21),LocalDate.of(2023,04,25),"Pendiente", vip2 );
        Pedido ped6 = new Pedido(1115L, LocalDate.of(2023,04,27),LocalDate.of(2023,04,28),"Pendiente", vip3 );

        listadoProductos.add(pro1);
        listadoProductos.add(pro2);
        listadoProductos.add(pro3);
        listadoProductos.add(pro4);
        listadoProductos.add(pro5);
        listadoProductos.add(pro6);
        listadoProductos.add(pro7);
        listadoProductos.add(pro8);

        listadoPedidos.add(ped1);
        listadoPedidos.add(ped2);
        listadoPedidos.add(ped3);
        listadoPedidos.add(ped4);
        listadoPedidos.add(ped5);
        listadoPedidos.add(ped6);

        ped1.productos.add(pro3);
        ped1.productos.add(pro6);
        ped1.productos.add(pro8);
        ped1.productos.add(pro7);

        ped2.productos.add(pro1);
        ped2.productos.add(pro3);
        ped2.productos.add(pro3); //Como es un set creo que no guarda repetidos y como no hay campo cantidad lo mejor seria montar otro tipo de lista

        ped3.productos.add(pro8);
        ped3.productos.add(pro7);
        ped3.productos.add(pro3);

        ped4.productos.add(pro3);
        ped4.productos.add(pro6);
        ped4.productos.add(pro8);
        ped4.productos.add(pro7);

        ped5.productos.add(pro2);
        ped5.productos.add(pro4);
        ped5.productos.add(pro3);
        ped5.productos.add(pro1);

        ped6.productos.add(pro4);
        ped6.productos.add(pro5);
        ped6.productos.add(pro1);
        ped6.productos.add(pro3);


        System.out.println("------------------------ Ejercicio 8 ------------------------------");
        System.out.println("");

        //a. Obtener de la lista de productos, una lista de productos de la categoría “IT” con precio > 50.
        listadoProductos.stream()
                .filter(producto -> producto.getCategoria().equals("IT"))
                .filter(producto -> producto.getPrecio()>50)
                .peek(producto -> System.out.println(producto.getNombre()))
                .toList();

        //b. Imprime de la lista de pedidos, todos los pedidos con productos pertenecientes a la
        // categoría de “Ropa”.

        /*
        listadoPedidos.stream()
                .filter(pedido. -> pedido.productos.contains())
        */


        // c. De la lista de productos, crea una lista de productos de la categoría “Juguetes” y aplícales
        //un 10% de descuento. Ayuda: usar filter, map y collect.

        listadoProductos.stream()
                .filter(producto -> producto.getCategoria().equals("Juguetes"))
                .map(producto -> producto.getPrecio()-(producto.getPrecio()*0.1))
                //.map(producto -> producto.setPrecio(producto.getPrecio()-(producto.getPrecio()*0.1)))
                //.forEach(producto -> producto.setPrecio(producto.getPrecio()-(producto.getPrecio()*0.1)))

                .peek(System.out::println)
                .collect(Collectors.toList());


        listadoProductos.stream()
                .map(producto -> producto.getPrecio())




//main
    }
    //class
}
