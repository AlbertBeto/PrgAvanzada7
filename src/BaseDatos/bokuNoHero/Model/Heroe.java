package BaseDatos.bokuNoHero.Model;

import java.util.ArrayList;
import java.util.List;

public class Heroe {

    private String nickname;
    private String nombre;
    private int edad;
    private List<Quirks> poderes;

    private Heroe(String nickname, String nombre, int edad) {
        this.nickname = nickname;
        this.nombre = nombre;
        this.edad = edad;
        this.poderes = new ArrayList<>();
    }

//class
}
