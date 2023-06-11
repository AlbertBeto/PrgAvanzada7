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

    public static void createHeroe2Poderes(String nickname, String nombre, int edad,String nombrePoder1, String tipoPoder1,String nombrePoder2, String tipoPoder2){
        Heroe heroe = new Heroe(nickname, nombre, edad);
        BokuNoHeroeHandleBD handleBD = new BokuNoHeroeHandleBD();
        int idheroe=handleBD.addHeroe(heroe);
        Quirks poder1 = Quirks.createQuirk(nombrePoder1,tipoPoder1,idheroe);
        handleBD.addQuirk(poder1);
        Quirks poder2 = Quirks.createQuirk(nombrePoder2,tipoPoder2,idheroe);
        handleBD.addQuirk(poder2);
    }

    public static void createHeroe3Poderes(String nickname, String nombre, int edad,String nombrePoder1, String tipoPoder1,String nombrePoder2, String tipoPoder2,String nombrePoder3, String tipoPoder3){
        Heroe heroe = new Heroe(nickname, nombre, edad);
        BokuNoHeroeHandleBD handleBD = new BokuNoHeroeHandleBD();
        int idheroe=handleBD.addHeroe(heroe);
        Quirks poder1 = Quirks.createQuirk(nombrePoder1,tipoPoder1,idheroe);
        handleBD.addQuirk(poder1);
        Quirks poder2 = Quirks.createQuirk(nombrePoder2,tipoPoder2,idheroe);
        handleBD.addQuirk(poder2);
        Quirks poder3 = Quirks.createQuirk(nombrePoder3,tipoPoder3,idheroe);
        handleBD.addQuirk(poder3);
    }

    public static void createHeroe4Poderes(String nickname, String nombre, int edad,String nombrePoder1, String tipoPoder1,String nombrePoder2, String tipoPoder2,String nombrePoder3, String tipoPoder3,String nombrePoder4, String tipoPoder4){
        Heroe heroe = new Heroe(nickname, nombre, edad);
        BokuNoHeroeHandleBD handleBD = new BokuNoHeroeHandleBD();
        int idheroe=handleBD.addHeroe(heroe);
        Quirks poder1 = Quirks.createQuirk(nombrePoder1,tipoPoder1,idheroe);
        handleBD.addQuirk(poder1);
        Quirks poder2 = Quirks.createQuirk(nombrePoder2,tipoPoder2,idheroe);
        handleBD.addQuirk(poder2);
        Quirks poder3 = Quirks.createQuirk(nombrePoder3,tipoPoder3,idheroe);
        handleBD.addQuirk(poder3);
        Quirks poder4 = Quirks.createQuirk(nombrePoder4,tipoPoder4,idheroe);
        handleBD.addQuirk(poder4);
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
