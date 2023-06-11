package BaseDatos.bokuNoHero.Model;

import BaseDatos.bokuNoHero.Mysql.BokuNoHeroeHandleBD;

import java.util.ArrayList;
import java.util.List;

public class Heroe {

    private String nickname;
    private String nombre;
    private int edad;
    private String nombrePoder1;
    private String tipoPoder1;
    private String nombrePoder2;
    private String tipoPoder2;
    private String nombrePoder3;
    private String tipoPoder3;
    private String nombrePoder4;
    private String tipoPoder4;

    public Heroe() {
    }

    private Heroe(String nickname, String nombre, int edad) {
        this.nickname = nickname;
        this.nombre = nombre;
        this.edad = edad;

    }

    public static void createHeroe1Poder(String nickname, String nombre, int edad,String nombrePoder1, String tipoPoder1){
        Heroe heroe = new Heroe(nickname, nombre, edad);
        BokuNoHeroeHandleBD handleBD = new BokuNoHeroeHandleBD();
        int idheroe=handleBD.addHeroe(heroe);
        Quirks poder = Quirks.createQuirk(nombrePoder1,tipoPoder1,idheroe);
        handleBD.addQuirk(poder);
    }

    public String getNickname() {
        return nickname;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    //class
}
