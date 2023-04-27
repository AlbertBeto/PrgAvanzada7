package Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Persona {

    private String nombre;
    List<Viaje> viajes;
    public Persona(String nombre) {
        this.nombre = nombre;
        viajes = new ArrayList<>() ;
    }

    public String getNombre() {
        return nombre;
    }


    //class
}
