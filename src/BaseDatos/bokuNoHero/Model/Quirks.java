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

    public Quirks createQuirk(String nombre, String tipo){
        Quirks quirk = new Quirks(nombre,tipo);
        return quirk;
    }

    //class
}
