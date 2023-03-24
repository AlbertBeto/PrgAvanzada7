package Genericos;

public class MainEquipo {

    public static void main(String[] args) {


        JugadorBaloncesto jb = new JugadorBaloncesto("Jordan");
        JugadorFutbol jf = new JugadorFutbol("El bicho");
        JugadorNormal jn = new JugadorNormal("Albert");
        JugadorNormal jn2 = new JugadorNormal("Alba");

        //Al incluir el generico o especificar el tipo de equipo.
        Equipo<JugadorBaloncesto> lakers = new Equipo("Especiales");
        Equipo<JugadorBaloncesto> knicks = new Equipo("Knicks");
        lakers.addJugador(jb);
        lakers.addJugador(jb);
        knicks.addJugador(jb);

        lakers.resultado(knicks,22,33);
    }
    //class
}