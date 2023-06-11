package BaseDatos.bokuNoHero.Model;

public class Quirks {
    private String nombre;
    private String tipo;

    private Quirks(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }

    private Quirks() {
    }

    private Quirks createQuirk(String nombre, String tipo){
        Quirks quirk = new Quirks(nombre,tipo);
        return quirk;
    }

    public Quirks creadorQuirks(String nombre, String tipo){
        return createQuirk(nombre,tipo);
    }


    //class
}
