package BaseDatos.bokuNoHero.Model;

import java.util.ArrayList;
import java.util.List;

public class Heroe {

    private String nickname;
    private String nombre;
    private int edad;
    private List<Quirks> poderes;

    public Heroe() {
    }

    private Heroe(String nickname, String nombre, int edad) {
        this.nickname = nickname;
        this.nombre = nombre;
        this.edad = edad;
        this.poderes = new ArrayList<>();
    }

    private Heroe createHeroe(String nickname, String nombre, int edad){
        Heroe heroe = new Heroe(nickname, nombre, edad);
        return heroe;
    }
    public Heroe creadorHeroe(String nickname,String nombre, int edad){
        return createHeroe(nickname,nombre,edad);
    }

//class
}
