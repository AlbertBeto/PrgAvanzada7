package Predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class Ciudad {

    public String nombre;
    public int poblacion;

    public String getNombre() {
        return nombre;
    }

    public int getPoblacion() {
        return poblacion;
    }


    public Ciudad(String nombre, int poblacion) {
        this.nombre = nombre;
        this.poblacion = poblacion;
    }


    public static void printCiudad(List<Ciudad> lista,Predicate prueba){
        for (Ciudad ciudad: lista) {
            if (prueba.test(ciudad)){
                System.out.println("La ciudad "+ciudad.getNombre()+" tiene una poblacion de "+ciudad.getPoblacion());            }
        }
    }

    public static void main(String[] args) {
        List<Ciudad> ciudades = new ArrayList<>();

        ciudades.add(new Ciudad("Barcelona",1636193));
        ciudades.add( new Ciudad("Madrid",3280782));
        ciudades.add( new Ciudad("Valencia",792492));
        ciudades.add( new Ciudad("Sevilla",681998));
        ciudades.add( new Ciudad("Zaragoza",673010));
        ciudades.add( new Ciudad("Malaga",579076));
        ciudades.add( new Ciudad("Murcia",462979));
        ciudades.add( new Ciudad("Alicante",338577));
        ciudades.add( new Ciudad("Elche",235580));
        ciudades.add( new Ciudad("Estepona",74493));

        Predicate<Ciudad> lo = Ciudad -> Ciudad.getNombre().substring(0,1).equals("E") && Ciudad.getPoblacion()>100000;

printCiudad(ciudades,lo);

        System.out.println("Comprobando dos objetos ciudades son iguales");
        BiPredicate<Ciudad,Ciudad> ciudadIguales = (city1,city2) -> city1.getNombre().equals(city2.getNombre());
        System.out.println(ciudadIguales.test(ciudades.get(1), ciudades.get(1)));

        IntPredicate mayorCien = x -> x>100;
    }




    //class
}
