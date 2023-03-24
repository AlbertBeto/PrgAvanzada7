package Genericos;

public class MainEquipo {

    public static void main(String[] args) {


        JugadorBaloncesto jb = new JugadorBaloncesto("Jordan");
        JugadorFutbol jf = new JugadorFutbol("El bicho");
        JugadorNormal jn = new JugadorNormal("Albert");
        JugadorNormal jn2 = new JugadorNormal("Alba");

        //Al incluir el generico o especificar el tipo de equipo.
        Equipo<JugadorBaloncesto> lakers = new Equipo("Lakers");
        Equipo<JugadorBaloncesto> knicks = new Equipo("Knicks");
        Equipo<JugadorBaloncesto> barcelona = new Equipo("Barcelona");
        barcelona.addJugador(new JugadorBaloncesto("Joan"));
        lakers.addJugador(jb);
        knicks.addJugador(jb);
        Equipo<JugadorFutbol> City = new Equipo("ManchesterCity");

        lakers.resultado(knicks,22,33);
        knicks.resultado(lakers,44,8);
        barcelona.resultado(knicks,88,12);
        barcelona.resultado(lakers,92,22);
        barcelona.resultado(lakers,92,22);
        barcelona.resultado(knicks,88,12);
        Liga<Equipo<JugadorBaloncesto>> endesa = new Liga<>("Endesa");
        endesa.addEquipo(lakers);
        endesa.addEquipo(knicks);
        endesa.addEquipo(barcelona);
        endesa.printEquipos(endesa);

    }
    //class
}