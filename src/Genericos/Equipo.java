package Genericos;

import java.util.ArrayList;
import java.util.Objects;

//Especificamos dentre junto a la T el tipo de generico que solo podemos usar en equipos.
// Con esto podemos quitar los castings del codigo
public class Equipo <T extends Jugador> implements Comparable<Equipo>{

    private String nombre;
    private int jugados;
    private int ganados;
    private int perdidos;
    private int empatados;

    private ArrayList<T> jugadores = new ArrayList();


    public Equipo(String nombre){
        this.nombre=nombre;

    }


    public boolean addJugador (T t){

        if (jugadores.contains(t)){
            //Hay que quitar el castin
            System.out.println("El jugador ya existe "+((Jugador)t).getNombre()+" ya existe.");
            return false;
        }else{
            jugadores.add(t);
            System.out.println("Se ha añadido el jugador "+((Jugador)t).getNombre());
            return true;
        }
    }

    public int numeroJugadores (){

        return jugadores.size();
    }

    public void resultado (Equipo<T> contrincante, int marcador, int marcadorContrincante){
        jugados++;
        if (marcador>marcadorContrincante){
            ganados++;
        }else if (marcador == marcadorContrincante){
            empatados++;
        }else{
            perdidos++;
        }
        //Esto es para que ponga los valores del contrincante de victorias, empates, etc...
        if (contrincante !=null){
            contrincante.resultado(null,marcadorContrincante,marcador);
        }
    }

    public int ranking(){
        return (ganados*10)+empatados;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Equipo<?> equipo = (Equipo<?>) o;
        return Objects.equals(nombre, equipo.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    //Para esto necesito implementar el compare en la clase.
    @Override
    public int compareTo(Equipo o) {
        if (this.ranking()>o.ranking()){
            return -1;
        }return +1;
        //return this.nombre.compareTo(o.nombre);
    }

//class
}